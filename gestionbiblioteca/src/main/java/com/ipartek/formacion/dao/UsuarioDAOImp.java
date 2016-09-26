package com.ipartek.formacion.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

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
@Repository("usuarioDAOImp")
public class UsuarioDAOImp implements UsuarioDAO {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = null;
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("usuarioGetAll").returningResultSet("usuarios", new UsuarioMapper());
		SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = jdbcCall.execute(in);
		usuarios = (List) out.get("usuarios");
		logger.info("getAll ejecutado");
		return usuarios;
	}

	@Override
	public Usuario getById(int codigo) {
		Usuario usuario = new Usuario();
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("usuarioGetById");
		usuario.setCodigo(codigo);
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", usuario.getCodigo());
		Map<String, Object> out = jdbcCall.execute(in);
		usuario.setNombre((String) out.get("nombre"));
		usuario.setApellidos((String) out.get("apellidos"));
		usuario.setFnacimiento((java.util.Date) out.get("fnacimiento"));
		usuario.setEmail((String) out.get("email"));
		usuario.setUsernick((String) out.get("usernick"));
		usuario.setUserpass((String) out.get("userpass"));
		logger.info("getById ejecutado");
		return usuario;
	}

	@Override
	public Usuario create(Usuario usuario) {
		jdbcCall.withProcedureName("usuarioCreate");
		SqlParameterSource in = new MapSqlParameterSource()
			.addValue("nombre", usuario.getNombre())
			.addValue("apellidos", usuario.getApellidos())
			.addValue("fnacimiento", new Date(usuario.getFnacimiento().getTime()))
			.addValue("email", usuario.getEmail())
			.addValue("usernick", usuario.getUsernick())
			.addValue("userpass", usuario.getUserpass());
		Map<String, Object> out = jdbcCall.execute(in);
		usuario.setCodigo((Integer) out.get("codigo"));
		logger.info("create ejecutado");
		return usuario;
	}

	@Override
	public Usuario update(Usuario usuario) {
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("usuarioUpdate");
		SqlParameterSource in = new MapSqlParameterSource().addValue("nombre", usuario.getNombre()).addValue("apellidos", usuario.getApellidos()).addValue("fnacimiento", usuario.getFnacimiento())
				.addValue("email", usuario.getEmail()).addValue("usernick", usuario.getUsernick()).addValue("userpass", usuario.getUserpass());
		Map<String, Object> out = jdbcCall.execute(in);
		logger.info("update ejecutado");
		return usuario;
	}

	@Override
	public void delete(int id) {
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("usuarioDelete");
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", id);
		Map<String, Object> out = jdbcCall.execute(in);
		logger.info("delete ejecutado");

	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

}