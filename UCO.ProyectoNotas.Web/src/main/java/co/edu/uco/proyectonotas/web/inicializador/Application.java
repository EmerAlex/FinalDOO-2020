package co.edu.uco.proyectonotas.web.inicializador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import co.edu.uco.proyectonotas.web.inicializador.configurador.Configurador;

@ComponentScan(basePackages = { "co.edu.uco.proyectonotas" })
@SpringBootApplication
public class Application {

	@SuppressWarnings("unused")
	@Autowired
	private Configurador configurador;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
