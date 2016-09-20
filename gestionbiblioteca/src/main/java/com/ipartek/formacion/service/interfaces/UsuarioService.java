package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.UsuarioDAOImp;
import com.ipartek.formacion.dao.persistence.Usuario;

/**
 * 
 * @author Turbo
 *
 */
public interface UsuarioService {
	/**
	 * 
	 * @return <code>List<Usuario></code>
	 */
	public List<Usuario> getAll();

	public Usuario getById(int id);

	public Usuario create(Usuario usuario);

	public Usuario update(Usuario usuario);

	public void delete(int id);

	public void setusuDAO(UsuarioDAOImp usuDAO);
}
