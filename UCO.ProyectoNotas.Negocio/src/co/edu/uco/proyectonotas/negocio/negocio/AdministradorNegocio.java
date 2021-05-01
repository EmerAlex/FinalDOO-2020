package co.edu.uco.proyectonotas.negocio.negocio;

import java.util.List;

import co.edu.uco.proyectonotas.dto.AdministradorDTO;

public interface AdministradorNegocio {
	void registrar(AdministradorDTO personaDto);

	void modificar(AdministradorDTO personaDto);

	void eliminar(AdministradorDTO personaDto);

	List<AdministradorDTO> consultar(AdministradorDTO personaDto);

}
