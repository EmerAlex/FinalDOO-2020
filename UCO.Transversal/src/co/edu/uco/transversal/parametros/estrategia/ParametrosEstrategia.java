package co.edu.uco.transversal.parametros.estrategia;

import co.edu.uco.transversal.enumeracion.FuenteDatosEnum;
import co.edu.uco.transversal.parametros.CatalogoParametros;
import co.edu.uco.transversal.parametros.implementacion.CatalogoParametrosProperties;

public class ParametrosEstrategia {

	private static String FUENTE;

	public static void colocarFuente(String fuente) {
		FUENTE = fuente;
	}

	public static String obtenerParametro(String clave) {
		CatalogoParametros catalogo = null;

		if (FuenteDatosEnum.PROPERTIES.toString().equals(FUENTE)) {
			catalogo = CatalogoParametrosProperties.obtenerInstancia();
		} else if (FuenteDatosEnum.EXCEL.toString().equals(FUENTE)) {
			// catalogo = CatalogoParametrosExcel.obtenerInstancia();
		} else if (FuenteDatosEnum.BASE_DATOS.toString().equals(FUENTE)) {
			// catalogo = CatalogoParametrosBaseDatos.obtenerInstancia();
		} else if (FuenteDatosEnum.TEXTO.toString().equals(FUENTE)) {
			// catalogo = CatalogoParametrosTexto.obtenerInstancia();
		} else if (FuenteDatosEnum.SERVICIO_WEB.toString().equals(FUENTE)) {
			// catalogo = CatalogoParametrosServicio.obtenerInstancia();
		}

		return catalogo.obtener(clave);
	}

	public static int obtenerParametroComoEntero(String clave) {
		return Integer.valueOf(obtenerParametro(clave));
	}

}
