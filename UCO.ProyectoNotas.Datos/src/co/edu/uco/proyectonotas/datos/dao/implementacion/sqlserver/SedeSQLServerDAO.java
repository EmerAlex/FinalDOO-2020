package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.SedeDAO;
import co.edu.uco.proyectonotas.dto.SedeDTO;

public class SedeSQLServerDAO implements SedeDAO {
	private Connection conexion;

	public SedeSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(SedeDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(SedeDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(SedeDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SedeDTO> consultar(SedeDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
