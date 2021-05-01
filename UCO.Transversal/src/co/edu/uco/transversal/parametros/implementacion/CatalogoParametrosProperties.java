package co.edu.uco.transversal.parametros.implementacion;

import java.util.Properties;

import co.edu.uco.transversal.parametros.CatalogoParametros;

public class CatalogoParametrosProperties implements CatalogoParametros {

	private Properties parametros;
	private static CatalogoParametros INSTANCIA = new CatalogoParametrosProperties();

	private CatalogoParametrosProperties() {
		super();
	}

	private CatalogoParametrosProperties(Properties parametros) {
		this.parametros = parametros;
	}

	public static void alimentarParametros(Properties parametros) {
		INSTANCIA = new CatalogoParametrosProperties(parametros);
	}

	public static CatalogoParametros obtenerInstancia() {
		return INSTANCIA;
	}

	@Override
	public String obtener(String clave) {
		return parametros.getProperty(clave);
	}

}
