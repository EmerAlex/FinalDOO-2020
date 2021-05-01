package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.GrupoDAO;
import co.edu.uco.proyectonotas.dto.GrupoDTO;

public class GrupoSQLServerDAO implements GrupoDAO {
	private Connection conexion;

	public GrupoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(GrupoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(GrupoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(GrupoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GrupoDTO> consultar(GrupoDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
