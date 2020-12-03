package co.grandcircus.jsonsamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
	@Autowired
	TestJsonService mserve;

	@GetMapping("/")
	public String index() {
		mserve.testApiCall();
		return "index";
	}
	
}
