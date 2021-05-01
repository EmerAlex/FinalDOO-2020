package co.edu.uco.proyectonotas.negocio.fachada;

import java.util.List;

import co.edu.uco.proyectonotas.dto.AdministradorDTO;

public interface AdministradorFachada {
	void registrar(AdministradorDTO administradorDto);

	void modificar(AdministradorDTO administradorDto);

	void eliminar(AdministradorDTO administradorDto);

	List<AdministradorDTO> consultar(AdministradorDTO administradorDto);

}
