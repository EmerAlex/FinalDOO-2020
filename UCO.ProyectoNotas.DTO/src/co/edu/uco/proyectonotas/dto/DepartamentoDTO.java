package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la información de un
 * departamento.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:30 p. m.
 */
public class DepartamentoDTO {

	/**
	 * <ul>
	 * <li>Propiedad que representa el código de un departamento.</li>
	 * <li>Es un dato de tipo entero.</li>
	 * <li>Es un dato mayor que cero.</li>
	 * <li>Es un dato que debe ser único.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de un departamento.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>Sólo permite letras y espacios.</li>
	 * <li>Su longitud máxima es de 100 caracteres.</li>
	 * <li>El nombre de un departamento no se puede repetir para el mismo país.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nombre;
	/**
	 * <ul>
	 * <li>Propiedad que representa el país al que pertenece el departamento.</li>
	 * <li>Es un dato de tipo Pais.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Pais.</li>
	 * </ul>
	 */
	private PaisDTO pais;

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

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

}