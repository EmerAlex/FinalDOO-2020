package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.DepartamentoDAO;
import co.edu.uco.proyectonotas.dto.DepartamentoDTO;

public class DepartamentoSQLServerDAO implements DepartamentoDAO {
	private Connection conexion;

	public DepartamentoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(DepartamentoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(DepartamentoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(DepartamentoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DepartamentoDTO> consultar(DepartamentoDTO objeto) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

}
