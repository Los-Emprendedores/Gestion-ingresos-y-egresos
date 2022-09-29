package com.emprendedores.UdeaCiclo3;
// Importe de librerias

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //(exclude ={SecurityAutoConfiguration.class})
public class UdeaCiclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(UdeaCiclo3Application.class, args);
	}


}
