package co.edu.uco.proyectonotas.dto;

/**
 * Clase que representa a un objeto de dominio que contiene la informaci�n de
 * sede donde est� ubicada una instituci�n.
 * 
 * @author Luciana
 * @version 1.0
 * @created 15-may.-2020 7:31:31 p. m.
 */
public class SedeDTO {

	private int codigo;
	/**
	 * <ul>
	 * <li>Propiedad que representa el nombre de una sede.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>S�lo permite letras y espacios.</li>
	 * <li>Su longitud m�xima es de 100 caracteres.</li>
	 * <li>El nombre de una sede para una instituci�n determinada no se puede
	 * repetir.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String nombre;
	/**
	 * <ul>
	 * <li>Propiedad que representa la direcci�n donde est� ubicada la sede en una
	 * ciudad.</li>
	 * <li>Es un dato de tipo texto.</li>
	 * <li>Permite cualquier caracter.</li>
	 * <li>Su longitud m�xima es de 250 caracteres.</li>
	 * <li>Es un dato obligatorio.</li>
	 * </ul>
	 */
	private String direccion;
	/**
	 * <ul>
	 * <li>Propiedad que representa la ciudad donde est� ubicada una sede.</li>
	 * <li>Es un dato de tipo Ciudad.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Ciudad.</li>
	 * </ul>
	 */
	private CiudadDTO ciudad;
	/**
	 * <ul>
	 * <li>Propiedad que representa la instituci�n a la que pertenece la sede.</li>
	 * <li>Es un dato de tipo Institucion.</li>
	 * <li>Es un dato obligatorio.</li>
	 * <li>Aplican las reglas del objeto Institucion.</li>
	 * </ul>
	 */
	private InstitucionDTO institucion;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	public InstitucionDTO getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDTO institucion) {
		this.institucion = institucion;
	}

}