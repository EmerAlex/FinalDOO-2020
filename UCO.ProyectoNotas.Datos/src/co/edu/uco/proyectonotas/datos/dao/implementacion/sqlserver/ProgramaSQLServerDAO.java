package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.ProgramaDAO;
import co.edu.uco.proyectonotas.dto.ProgramaDTO;

public class ProgramaSQLServerDAO implements ProgramaDAO {
	private Connection conexion;

	public ProgramaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(ProgramaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(ProgramaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(ProgramaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProgramaDTO> consultar(ProgramaDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
