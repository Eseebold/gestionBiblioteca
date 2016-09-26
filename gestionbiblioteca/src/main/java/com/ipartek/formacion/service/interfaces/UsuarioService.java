package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Usuario;

public interface UsuarioService {

	public List<Usuario> getAll();

	public void delete(int id);

	public Usuario create(Usuario usuario);

	public Usuario update(Usuario usuario);

	public List<Usuario> find(Usuario usuario);

}
