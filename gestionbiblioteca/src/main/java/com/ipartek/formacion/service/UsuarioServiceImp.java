package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDAO usuDAO = null;

	public List<Usuario> getAll() {
		return usuDAO.getAll();
	}

	public Usuario getById(int id) {
		return usuDAO.getById(id);
	}

	public Usuario create(Usuario usuario) {
		return usuDAO.create(usuario);
	}

	public Usuario update(Usuario usuario) {

		return usuDAO.update(usuario);
	}

	public void delete(int id) {
		usuDAO.delete(id);

	}

	public void setusuDAO(UsuarioDAOImp usuDAO) {
		this.usuDAO = usuDAO;
	}

}