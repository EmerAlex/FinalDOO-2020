package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.EstudianteDAO;
import co.edu.uco.proyectonotas.dto.EstudianteDTO;

public class EstudianteSQLServerDAO implements EstudianteDAO {
	private Connection conexion;

	public EstudianteSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(EstudianteDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(EstudianteDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(EstudianteDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstudianteDTO> consultar(EstudianteDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
