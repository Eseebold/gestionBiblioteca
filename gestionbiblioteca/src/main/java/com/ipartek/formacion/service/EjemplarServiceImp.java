package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.service.interfaces.EjemplarService;

@Service
public class EjemplarServiceImp implements EjemplarService {

	@Autowired
	EjemplarDAO eDao;

	@Override
	public List<Libro> getAll() {
		return eDao.getAll();
	}

	@Override
	public List<Libro> find(Libro libro) {
		return eDao.find(libro);
	}

	@Override
	public List<Ejemplar> getEjemplares(Libro libro) {
		return eDao.getEjemplares(libro);
	}

	@Override
	public Ejemplar getEjemplar(int codEjemplar) {
		return eDao.getEjemplar(codEjemplar);
	}

	@Override
	public void eliminar(int codEjemplar) {
		eDao.eliminar(codEjemplar);
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		return eDao.update(ejemplar);
	}

}
