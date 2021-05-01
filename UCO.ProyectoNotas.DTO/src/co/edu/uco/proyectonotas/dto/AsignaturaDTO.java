package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la informaci�n de
 * una asignatura.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:30 p. m.
 */
public class AsignaturaDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el c�digo de una asignatura.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser �nico.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	public int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de una asignatura.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>S�lo permite letras y espacios.</li>
	 * <li>Su longitud m�xima es de 100 caracteres.</li>
	 * <li>El nombre de una asignatura no se puede repetir.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	public String nombre;

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

}