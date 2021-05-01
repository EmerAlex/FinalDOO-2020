package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.SesionDAO;
import co.edu.uco.proyectonotas.dto.SesionDTO;

public class SesionSQLServerDAO implements SesionDAO {
	private Connection conexion;

	public SesionSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(SesionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(SesionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(SesionDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SesionDTO> consultar(SesionDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
