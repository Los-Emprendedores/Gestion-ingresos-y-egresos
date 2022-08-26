package com.emprendedores.UdeaCiclo3;
// Importe de librerias

import com.emprendedores.UdeaCiclo3.Entidades.Empleado;
import com.emprendedores.UdeaCiclo3.Entidades.Empresa; // Impotar clase empresa
import com.emprendedores.UdeaCiclo3.Entidades.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class UdeaCiclo3Application {

	// GetMapping pueba saludo
	@GetMapping("/hello")
	public String hello(){
		return "Hola Cliclo 3...";
	}

	@GetMapping("/Empresa")// GetMapping Prueba Empresa
	public String Empresa(){Empresa empr = new Empresa("STARK INDUSTRIES", "Calle 94b # 57a - 26", "3206217113", "900321745-1");

		// Editar atributos
		empr.setNombre("<b>STARK INDUSTRIES LTDA</b>");

		// Retorno en pagina
		return "<br>NOMBRE: " + empr.getNombre() + "</br>" +
				"<br>DIRECCION: " +  empr.getDireccion() + "</br>" +
				"<br>TELEFONO: "+ empr.getTelefono() + "</br>" +
				"<br>NIT: " + empr.getNIT();
	}
	@GetMapping("/Empleado")// GetMapping Prueba Empresa
	public String Empleado(){Empleado empl = new Empleado(/*"Nombre", email, "empresa", "rol"*/);

		return "";
	}

	@GetMapping("/Movimientos")//GetMapping prueba movimientos
	public String Movimientos(){MovimientoDinero mov = new MovimientoDinero(/*"monto", "concepto", usuario*/);
		return "";
	}

		public static void main(String[] args) {
		SpringApplication.run(UdeaCiclo3Application.class, args);
//		System.out.println("Hola, mundo");

	}


}
