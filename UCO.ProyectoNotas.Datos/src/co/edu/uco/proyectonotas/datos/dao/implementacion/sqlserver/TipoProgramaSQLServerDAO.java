package co.edu.uco.proyectonotas.datos.dao.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.proyectonotas.datos.dao.TipoProgramaDAO;
import co.edu.uco.proyectonotas.dto.TipoProgramaDTO;

public class TipoProgramaSQLServerDAO implements TipoProgramaDAO {
	private Connection conexion;

	public TipoProgramaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoProgramaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(TipoProgramaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(TipoProgramaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoProgramaDTO> consultar(TipoProgramaDTO objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
