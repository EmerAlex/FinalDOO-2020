package co.edu.uco.transversal.mensajes.implementacion;

import java.util.Properties;

import co.edu.uco.transversal.mensajes.CatalogoMensajes;
import co.edu.uco.transversal.parametros.codigos.CodigosParametro;
import co.edu.uco.transversal.parametros.estrategia.ParametrosEstrategia;

public class CatalogoMensajesProperties implements CatalogoMensajes {

	private Properties mensajes;
	private static final CatalogoMensajes INSTANCIA = new CatalogoMensajesProperties();

	private CatalogoMensajesProperties() {
		try {
			String ubicacionArchivoMensajes = ParametrosEstrategia.obtenerParametro(CodigosParametro.UBICACION_ARCHIVO_MENSAJES);
			mensajes = new Properties();
			mensajes.load(CatalogoMensajesProperties.class.getResourceAsStream(ubicacionArchivoMensajes));
		} catch (Exception excepcion) {
			// TODO: handle exception
		}
	}

	public static CatalogoMensajes obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public String obtener(String clave) {
		return mensajes.getProperty(clave);
	}
}
