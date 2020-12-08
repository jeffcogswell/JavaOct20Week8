package co.grandcircus.passworddemo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	// todo: I recommend moving this to a service and autowire it. Then it can be shared between controllers
	public static BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	

	@Autowired
	PWUserRepository pwrep;
	
	@GetMapping("/")
	public String index(String m, Model model) {
		
		// The "m" parameter comes from the redirect of the postlogin() method. It's a flag to display a login error message.
		
		if (m != null && m.compareTo("l") == 0) {
			model.addAttribute("message", "Sorry, that login did not work. Please try again.");
		}
		return "index";
	}
	
	@PostMapping("/login")
	public String postlogin(String email, String password, HttpSession session) {
		
		// Locate the user by email
		
		PWUser user = pwrep.findOneByEmail(email);
		if (user != null) {
			// Found the user. Check the password.
			
			if (pwEncoder.matches(password, user.getPassword())) {
				// They match. We're good. So create the session and go to the home page.
				session.setAttribute("user", user.getEmail());
				return "redirect:/profile";
			}
			
		}
		
		// If we made it here, it means the login failed. Clear out any existing session just in case
		session.invalidate();
		// todo: Add a message that the login was unsuccessful
		return "redirect:/?m=l";
	}
	
	@PostMapping("/register")
	public String postregister(PWUser user, HttpSession session) {	
		
		// todo: Validation. Make sure email is valid format, password isn't blank, etc.
		
		// Get the existing password
		String pw = user.getPassword();
		// Encode the password
		pw = pwEncoder.encode(pw);
		// Save it back into the user
		user.setPassword(pw);
		
		// Note: All of the above can be condensed into a single line if you prefer:
		// user.setPassword(pwrep.pwEncoder.encode(user.getPassword()));
		
		pwrep.save(user);
		
		session.setAttribute("user", user.getEmail());
		return "redirect:/profile";
	}
	
	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {
		// This one is "guarded" by the session. Only logged-in users can access it.
		
		String email = (String)session.getAttribute("user");
		if (email != null) {
			PWUser user = pwrep.findOneByEmail(email);
			if (user != null) {
				// All is good! Fill model and display profile page.
				model.addAttribute("user", user);
				return "profile";
			}
		}
		
		// If we made it here, it means something went wrong, possibly the user was
		// removed from the database table, or the user managed to fool us with a fake token.
		// Either way, invalidate the session and go back to index.
		
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
