package co.edu.uco.proyectonotas.web.inicializador.configurador;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.edu.uco.transversal.enumeracion.FuenteDatosEnum;
import co.edu.uco.transversal.parametros.estrategia.ParametrosEstrategia;
import co.edu.uco.transversal.parametros.implementacion.CatalogoParametrosProperties;

@Component
public class Configurador {

	@Value("${UBICACION_ARCHIVO_PARAMETROS}")
	private String ubicacionParametros;

	@Value("${CONFIGURACION_CATALOGO_PARAMETROS}")
	public void configurarFuenteParametros(String fuente) {
		ParametrosEstrategia.colocarFuente(fuente);

		if (FuenteDatosEnum.PROPERTIES.toString().equals(fuente)) {
			try {
				Properties propiedades = new Properties();
				propiedades.load(Configurador.class.getResourceAsStream(ubicacionParametros));
				CatalogoParametrosProperties.alimentarParametros(propiedades);
			} catch (Exception excepcion) {
				// TODO: handle exception
			}
		}
	}
}
