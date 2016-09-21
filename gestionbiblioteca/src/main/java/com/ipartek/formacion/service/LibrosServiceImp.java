package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.LibroDAOImp;
import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;
@Service
public class LibrosServiceImp implements LibroService {

	@Autowired
	private LibroDAO libDAO = null;

	public List<Libro> getAll() {
		return libDAO.getAll();
	}

	public Libro getById(int id) {
		return libDAO.getById(id);
	}

	public Libro create(Libro libro) {
		return libDAO.create(libro);
	}

	public Libro update(Libro libro) {

		return libDAO.update(libro);
	}

	public void delete(int id) {
		libDAO.delete(id);

	}

	public void setLibDAO(LibroDAOImp libDAO) {
		this.libDAO = libDAO;
	}

}