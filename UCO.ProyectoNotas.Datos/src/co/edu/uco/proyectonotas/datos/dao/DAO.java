package co.edu.uco.proyectonotas.datos.dao;

import java.util.List;

public interface DAO<T> {

	void crear(T objeto);

	void actualizar(T objeto);

	void eliminar(T objeto);

	List<T> consultar(T objeto);
}
