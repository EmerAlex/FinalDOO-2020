package co.edu.uco.transversal.excepcion;

public class NotasExcepcion extends RuntimeException {

	private static final long serialVersionUID = 4939334005151894699L;
	private Exception excepcion;
	private String mensaje;

	private NotasExcepcion(Exception excepcion, String mensaje) {
		super();
		this.excepcion = excepcion;
		this.mensaje = mensaje;
	}

	public static NotasExcepcion crear(Exception excepcion, String mensaje) {
		return new NotasExcepcion(excepcion, mensaje);
	}

	public static NotasExcepcion crear(String mensaje) {
		return new NotasExcepcion(new Exception(), mensaje);
	}

	public Exception getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(Exception excepcion) {
		this.excepcion = excepcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
