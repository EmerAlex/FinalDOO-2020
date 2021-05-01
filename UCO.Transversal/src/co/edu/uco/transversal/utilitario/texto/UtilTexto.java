package co.edu.uco.transversal.utilitario.texto;

import static co.edu.uco.transversal.utilitario.objeto.UtilObjeto.*;

public class UtilTexto {

	public static final String VACIO = "";
	public static final String PATRON_SOLO_TEXTO = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$";

	private UtilTexto() {
		super();
	}

	public static boolean cadenaEsNula(String cadena) {
		return objetoEsNulo(cadena);
	}

	public static boolean cadenaEstaVacia(String cadena) {
		return aplicarTrim(cadena).equals(VACIO);
	}

	public static String aplicarTrim(String cadena) {
		return obtenerValorDefecto(cadena, VACIO).trim();
	}

	public static boolean cadenaEstaNulaOVacia(String cadena) {
		return cadenaEsNula(cadena) || cadenaEstaVacia(cadena);
	}

	public static String concatenar(String... cadenas) {

		StringBuilder concatenador = new StringBuilder();

		for (String cadena : cadenas) {
			concatenador.append(obtenerValorDefecto(cadena, VACIO));
		}

		return concatenador.toString();
	}

	public static boolean longitudEsValida(String cadena, int longitudMinima, int longitudMaxima) {
		String texto = aplicarTrim(cadena);
		return (texto.length() >= longitudMinima && texto.length() <= longitudMaxima);
	}

	public static boolean cumplePatron(String cadena, String patron) {
		return aplicarTrim(cadena).matches(aplicarTrim(patron));
	}

	public static boolean soloTexto(String cadena) {
		return cumplePatron(cadena, PATRON_SOLO_TEXTO);
	}
}