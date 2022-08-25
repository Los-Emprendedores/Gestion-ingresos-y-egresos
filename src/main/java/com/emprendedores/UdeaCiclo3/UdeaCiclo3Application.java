package com.emprendedores.UdeaCiclo3;
// Importe de librerias

import com.emprendedores.UdeaCiclo3.Entidades.Empresa; // Impotar clase empresa
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class UdeaCiclo3Application {

	// GetMapping pueba saludo
	@GetMapping("/hello")
	public String hello(){
		return "Hola Cliclo 3...";
	}

	// GetMapping Pueba Empresa
	@GetMapping("/test")
	public String test(){Empresa emp = new Empresa("STARK INDUSTRIES", "Calle 94b # 57a - 26", "3206217113", "900321745-1");

		// Cambiar nombre
		emp.setNombre("<b>STARK INDUSTRIES LTDA</b>");

		// Retorno en pagina
		return "<br>NOMBRE: " + emp.getNombre() + "</br>" +
				"<br>DIRECCION: " +  emp.getDireccion() + "</br>" +
				"<br>TELEFONO: "+ emp.getTelefono() + "</br>" +
				"<br>NIT: " + emp.getNIT();
	}

		public static void main(String[] args) {
		SpringApplication.run(UdeaCiclo3Application.class, args);
//		System.out.println("Hola, mundo");

	}


}
