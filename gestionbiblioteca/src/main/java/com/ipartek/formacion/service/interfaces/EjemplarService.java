package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Libro;

public interface EjemplarService extends LibroService {

	public List<Ejemplar> getEjemplares(Libro libro);

	public Ejemplar getEjemplar(int codEjemplar);

	public void eliminar(int codEjemplar);

	public Ejemplar update(Ejemplar ejemplar);

}