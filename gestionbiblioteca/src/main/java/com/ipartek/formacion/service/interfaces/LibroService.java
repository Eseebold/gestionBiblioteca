package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.persistence.Libro;

/**
 * 
 * @author Turbo
 *
 */
public interface LibroService {
	/**
	 * 
	 * @return <code>List<Usuario></code>
	 */
	public List<Libro> getAll();

	public Libro getById(int id);

	public Libro create(Libro libro);

	public Libro update(Libro libro);

	public void delete(int id);

	public void setLibDAO(LibroDAOImp libDAO);
}
