package co.edu.uco.proyectonotas.dto;

public class AdministradorDTO {
	
	protected int codigo;
	
	protected int codigoSuperAdministrador;
	
	protected String nombre;
	
	protected String Apellido;

	protected boolean estado;
	
	protected String nombreUsuario;
	
	protected String contraseña;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoSuperAdministrador() {
		return codigoSuperAdministrador;
	}

	public void setCodigoSuperAdministrador(int codigoSuperAdministrador) {
		this.codigoSuperAdministrador = codigoSuperAdministrador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
