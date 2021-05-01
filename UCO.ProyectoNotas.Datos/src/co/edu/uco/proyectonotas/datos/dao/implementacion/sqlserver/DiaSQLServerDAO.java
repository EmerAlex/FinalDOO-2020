package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.DiaDAO;
import co.edu.uco.proyectonotas.dto.DiaDTO;

public class DiaSQLServerDAO implements DiaDAO {
	private Connection conexion;

	public DiaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(DiaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(DiaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(DiaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DiaDTO> consultar(DiaDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
