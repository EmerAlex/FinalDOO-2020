package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la informaci�n de
 * una instituci�n.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class InstitucionDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el c�digo de una instituci�n.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser �nico.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de una instituci�n.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>S�lo permite letras y espacios.</li>
	 * <li>Su longitud m�xima es de 100 caracteres.</li>
	 * <li>El nombre de una instituci�n no se puede repetir.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nombre;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nit de una instituci�n.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>S�lo permite letras y espacios.</li>
	 * <li>Su longitud m�xima es de 100 caracteres.</li>
	 * <li>El nit de una instituci�n no se puede repetir.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nit;

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

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

}