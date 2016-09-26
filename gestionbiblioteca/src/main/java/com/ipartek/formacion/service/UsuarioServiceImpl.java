package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO uDao;

	@Override
	public List<Usuario> getAll() {
		return uDao.getAll();
	}

	@Override
	public void delete(int id) {
		uDao.delete(id);
	}

	@Override
	public Usuario create(Usuario usuario) {
		return uDao.create(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return uDao.update(usuario);
	}

	@Override
	public List<Usuario> find(Usuario usuario) {
		return uDao.find(usuario);
	}

}
