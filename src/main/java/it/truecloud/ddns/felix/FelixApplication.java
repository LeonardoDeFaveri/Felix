package it.truecloud.ddns.felix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FelixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FelixApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Hello, world";
	}
}
