/**
 * 
 */
package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Libro;

/**
 * @author va00
 *
 */
public interface LibroService {
	public List<Libro> getAll();

	public List<Libro> find(Libro libro);
}
