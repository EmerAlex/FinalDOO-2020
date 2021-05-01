package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.EstadoCivilDAO;
import co.edu.uco.proyectonotas.dto.EstadoCivilDTO;

public class EstadoCivilSQLServerDAO implements EstadoCivilDAO {
	private Connection conexion;

	public EstadoCivilSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(EstadoCivilDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(EstadoCivilDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(EstadoCivilDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstadoCivilDTO> consultar(EstadoCivilDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
