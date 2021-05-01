package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.AsignaturaDAO;
import co.edu.uco.proyectonotas.dto.AsignaturaDTO;

public class AsignaturaSQLServerDAO implements AsignaturaDAO {

	private Connection conexion;

	public AsignaturaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(AsignaturaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(AsignaturaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(AsignaturaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AsignaturaDTO> consultar(AsignaturaDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
