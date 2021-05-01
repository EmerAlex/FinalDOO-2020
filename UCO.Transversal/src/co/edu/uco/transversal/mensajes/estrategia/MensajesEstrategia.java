package co.edu.uco.transversal.mensajes.estrategia;

import co.edu.uco.transversal.enumeracion.FuenteDatosEnum;
import co.edu.uco.transversal.mensajes.CatalogoMensajes;
import co.edu.uco.transversal.mensajes.implementacion.CatalogoMensajesProperties;
import co.edu.uco.transversal.parametros.codigos.CodigosParametro;
import co.edu.uco.transversal.parametros.estrategia.ParametrosEstrategia;

public class MensajesEstrategia {

	public static String obtener(String clave) {
		String fuente = ParametrosEstrategia.obtenerParametro(CodigosParametro.CONFIGURACION_CATALOGO_MENSAJES);
		CatalogoMensajes catalogo = null;

		if (FuenteDatosEnum.PROPERTIES.toString().equals(fuente)) {
			catalogo = CatalogoMensajesProperties.obtenerInstancia();
		} else if (FuenteDatosEnum.EXCEL.toString().equals(fuente)) {
			// catalogo = CatalogoMensajesExcel.obtenerInstancia();
		} else if (FuenteDatosEnum.BASE_DATOS.toString().equals(fuente)) {
			// catalogo = CatalogoMensajesBaseDatos.obtenerInstancia();
		} else if (FuenteDatosEnum.TEXTO.toString().equals(fuente)) {
			// catalogo = CatalogoMensajesTexto.obtenerInstancia();
		} else if (FuenteDatosEnum.SERVICIO_WEB.toString().equals(fuente)) {
			// catalogo = CatalogoMensajesServicio.obtenerInstancia();
		}

		return catalogo.obtener(clave);
	}

}
