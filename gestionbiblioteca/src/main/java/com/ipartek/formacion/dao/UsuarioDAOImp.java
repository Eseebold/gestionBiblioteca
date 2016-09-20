package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.neo4j.cypher.internal.compiler.v2_1.perty.printToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
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
		logger.info("GetAll ejecutado");
		return usuarios;
	}

	public Usuario GetById(int id) {
		Usuario usuario = null;
		final String SQL = "SELECT codigo, nombre, apellidos, fNacimiento, email FROM usuario WHERE codigo = ?;";
		try {
			usuario = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new UsuarioMapper());
		} catch (EmptyResultDataAccessException e) {
			usuario = new Usuario();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("GetById ejecutado");
		return usuario;
	}

	public Usuario create(Usuario usuario) {
		/*
		 * createUsuario --> Nombre del procedimiento almacenado
		 */
		jdbcCall.withProcedureName("createUsuario");
		/*
		 * SqlParameterSource (tipo Map) guarda los paramentros necesarios para
		 * el procedimiento
		 */
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("nombre", usuario.getNombre())
				.addValue("apellidos", usuario.getApellidos())
				.addValue("fecha", new Date(usuario.getfNacimiento().getTime()))
				.addValue("email", usuario.getEmail());

		Map<String, Object> out = jdbcCall.execute(in);
		/*
		 * Recogemos el parametro OUT del procedimiento
		 */
		usuario.setCodigo((Integer) out.get("codigo"));
		logger.info("create ejecutado");
		return usuario;
	}

	public Usuario update(Usuario usuario) {
		final String SQL = "UPDATE usuario SET nombre = ?, apellidos = ?, fNacimiento = ?, email = ?  WHERE codigo = ?;";
		jdbctemplate.update(
				SQL,
				new Object[] { usuario.getNombre(), usuario.getApellidos(),
						usuario.getfNacimiento(), usuario.getEmail(),
						usuario.getCodigo() });
		logger.info("update ejecutado");
		return usuario;

	}

	public void delete(int id) {
		final String SQL = "DELETE FROM usuario WHERE codigo = ?;";
		jdbctemplate.update(SQL, new Object[] { id });
		logger.info("delete ejecutado");
	}

}
