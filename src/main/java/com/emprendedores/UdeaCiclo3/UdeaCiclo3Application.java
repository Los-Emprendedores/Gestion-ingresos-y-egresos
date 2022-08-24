package com.emprendedores.UdeaCiclo3;
// Importe de librerias
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class UdeaCiclo3Application {

	@GetMapping("/hello")
	public String hello(){
		return "Hola Cliclo 3...";
	}

	public static void main(String[] args) {
		SpringApplication.run(UdeaCiclo3Application.class, args);
//		System.out.println("Hola, mundo");

	}


}
