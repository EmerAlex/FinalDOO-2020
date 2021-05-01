package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la información de un
 * tipo de identificación.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class TipoIdentificacionDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el código de un tipo de identificación.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser único.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de un tipo de identificación.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>Sólo permite letras y espacios.</li>
	 * <li>Su longitud máxima es de 100 caracteres.</li>
	 * <li>El nombre de un tipo de identificación no se puede repetir.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nombre;
	/**
	 * <ul>
	 * <li>Propiedad que representa la edad mínima en la que aplica un tipo de
	 * identificación.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser menor o igual a la edad máxima.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int edadMinima;
	/**
	 * <ul>
	 * <li>Propiedad que representa la edad máxima en la que aplica un tipo de
	 * identificación.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * </ul>
	 * <ul>
	 * <li>Es un dato que debe ser mayor o igual a la edad mínima.</li>
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