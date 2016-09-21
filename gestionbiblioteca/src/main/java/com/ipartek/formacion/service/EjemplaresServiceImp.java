package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.EjemplarDAOImp;
import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.service.interfaces.EjemplarService;
@Service
public class EjemplaresServiceImp implements EjemplarService {

	@Autowired
	private EjemplarDAO ejeDAO = null;

	public List<Ejemplar> getAll() {
		return ejeDAO.getAll();
	}

	public Ejemplar getById(int id) {
		return ejeDAO.getById(id);
	}

	public Ejemplar create(Ejemplar ejemplar) {
		return ejeDAO.create(ejemplar);
	}

	public Ejemplar update(Ejemplar ejemplar) {

		return ejeDAO.update(ejemplar);
	}

	public void delete(int id) {
		ejeDAO.delete(id);

	}

	public void setEjeDAO(EjemplarDAOImp ejeDAO) {
		this.ejeDAO = ejeDAO;
	}

}