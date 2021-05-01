package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.CiudadDAO;
import co.edu.uco.proyectonotas.dto.CiudadDTO;

public class CiudadSQLServerDAO implements CiudadDAO {
	private Connection conexion;

	public CiudadSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(CiudadDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(CiudadDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(CiudadDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CiudadDTO> consultar(CiudadDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
