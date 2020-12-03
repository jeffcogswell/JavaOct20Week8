package co.grandcircus.spacexbuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@Autowired
	SpacexApiService spacex;
	
	@GetMapping("/")
	public String index() {
		spacex.testApiCall2();
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/latest")
	public String latest(Model model) {
		SpaceXLaunch launch = spacex.getLatestLaunch();
		model.addAttribute("launch", launch);
		return "launchpage";
	}
	
}
