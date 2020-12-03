package co.grandcircus.propertiestest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
	// Just an example if you need a properties variable in a controller
	@Value("${co.grandcircus.test}")
	private String propsample;
	
	@Autowired
	private MovieApiService movies;
	
	@GetMapping("/")
	public String index() {
		System.out.println("Property value:");
		System.out.println(propsample);
		movies.testApiCall2();
		return "index";
	}
}
