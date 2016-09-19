package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistence.Usuario;

/**
 * 
 * @author Turbo
 *
 */
@Repository("alumnoDAOImp")
public class UsuarioDAOImp implements UsuarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub

	}

	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		final String SQL = "SELECT codigo, nombre, apellidos, fNacimiento, email FROM usuario;";
		try {
			usuarios = jdbctemplate.query(SQL, new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			usuarios = new ArrayList<Usuario>();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return usuarios;
	}

	public Usuario GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario create(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario update(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
