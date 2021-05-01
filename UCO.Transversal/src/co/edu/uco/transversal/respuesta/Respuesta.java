package co.edu.uco.transversal.respuesta;

import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.objetoEsNulo;
import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.obtenerValorDefecto;
import static co.edu.uco.transversal.utilitario.texto.UtilTexto.cadenaEstaNulaOVacia;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.transversal.respuesta.enumeracion.TipoRespuestaEnum;

public class Respuesta<T> {

	private TipoRespuestaEnum tipoRespuesta;
	private List<String> mensajesOperacion;
	private List<T> datos;

	public TipoRespuestaEnum getTipoRespuesta() {
		setTipoRespuesta(tipoRespuesta);
		return tipoRespuesta;
	}

	public void setTipoRespuesta(TipoRespuestaEnum tipoRespuesta) {
		this.tipoRespuesta = obtenerValorDefecto(tipoRespuesta, TipoRespuestaEnum.ERROR);
	}

	public List<String> getMensajesOperacion() {
		setMensajesOperacion(mensajesOperacion);
		return mensajesOperacion;
	}

	public void setMensajesOperacion(List<String> mensajesOperacion) {
		this.mensajesOperacion = obtenerValorDefecto(mensajesOperacion, new ArrayList<String>());
	}

	public List<T> getDatos() {
		setDatos(datos);
		return datos;
	}

	public void setDatos(List<T> datos) {
		this.datos = obtenerValorDefecto(datos, new ArrayList<T>());
	}

	public void agregarMensaje(String mensaje) {
		if (!cadenaEstaNulaOVacia(mensaje)) {
			getMensajesOperacion().add(mensaje);
		}
	}

	public void agredarDato(T dato) {
		if (!objetoEsNulo(dato)) {
			getDatos().add(dato);
		}
	}
}