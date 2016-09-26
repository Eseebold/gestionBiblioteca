package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Libro;

public interface EjemplarDAO extends LibroDAO {

	public List<Ejemplar> getEjemplares(Libro libro);

	public Ejemplar getEjemplar(int codEjemplar);

	public void eliminar(int codLibro);

	public Ejemplar update(Ejemplar ejemplar);

}
