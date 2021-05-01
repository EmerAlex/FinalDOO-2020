package co.edu.uco.transversal.utilitario.objeto;

public class UtilObjeto {

	private UtilObjeto() {
		super();
	}

	public static <T> boolean objetoEsNulo(T objeto) {
		return objeto == null;
	}

	public static <T> T obtenerValorDefecto(T valor, T valorDefecto) {
		return objetoEsNulo(valor) ? valorDefecto : valor;
	}
}
