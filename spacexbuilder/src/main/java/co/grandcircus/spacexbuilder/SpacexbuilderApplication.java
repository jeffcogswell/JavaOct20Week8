package co.grandcircus.spacexbuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpacexbuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacexbuilderApplication.class, args);
		System.out.println("SpaceX Model Builder: Port 8102");
	}

}
