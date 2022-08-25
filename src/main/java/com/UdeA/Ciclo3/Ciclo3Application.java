package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController
@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")
	public String hello() {
		return "Esto es un saludo";
	}
	@GetMapping("/equipo")
	public String equipo() {
		return "<b>Vamos con toda</b>";
	}

	@GetMapping("/test")
	public String test() {
		Empresa emp = new Empresa("Industrias.Stark","Calle la gata","32179855","80022114");
		emp.setDireccion("Calle los Avengers");

		return emp.getDireccion();
	}
	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
