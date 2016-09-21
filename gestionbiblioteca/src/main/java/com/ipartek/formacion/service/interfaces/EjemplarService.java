package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.persistence.Ejemplar;

/**
 * 
 * @author Turbo
 *
 */
public interface EjemplarService {
	/**
	 * 
	 * @return <code>List<Usuario></code>
	 */
	public List<Ejemplar> getAll();

	public Ejemplar getById(int id);

	public Ejemplar create(Ejemplar ejemplar);

	public Ejemplar update(Ejemplar ejemplar);

	public void delete(int id);

	public void setEjeDAO(EjemplarDAOImp ejeDAO);
}
