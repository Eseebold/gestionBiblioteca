package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Usuario;

/**
 * 
 * @author Turbo
 *
 */
public interface UsuarioDAO extends DAOSetter {

	public List<Usuario> getAll();

	public Usuario GetById(int id);

	public Usuario create(Usuario usuario);

	public Usuario update(Usuario usuario);

	public void delete(int id);

}
