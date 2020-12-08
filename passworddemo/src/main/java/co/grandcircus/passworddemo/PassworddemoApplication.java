package co.grandcircus.passworddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PassworddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassworddemoApplication.class, args);
		System.out.println("PW Demo: PORT 8203");
	}

}
