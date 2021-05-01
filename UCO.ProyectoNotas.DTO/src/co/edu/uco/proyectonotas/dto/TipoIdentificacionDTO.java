package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la informaci�n de un
 * tipo de identificaci�n.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class TipoIdentificacionDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el c�digo de un tipo de identificaci�n.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser �nico.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de un tipo de identificaci�n.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>S�lo permite letras y espacios.</li>
	 * <li>Su longitud m�xima es de 100 caracteres.</li>
	 * <li>El nombre de un tipo de identificaci�n no se puede repetir.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nombre;
	/**
	 * <ul>
	 * <li>Propiedad que representa la edad m�nima en la que aplica un tipo de
	 * identificaci�n.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser menor o igual a la edad m�xima.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int edadMinima;
	/**
	 * <ul>
	 * <li>Propiedad que representa la edad m�xima en la que aplica un tipo de
	 * identificaci�n.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * </ul>
	 * <ul>
	 * <li>Es un dato que debe ser mayor o igual a la edad m�nima.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int edadMaxima;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
}