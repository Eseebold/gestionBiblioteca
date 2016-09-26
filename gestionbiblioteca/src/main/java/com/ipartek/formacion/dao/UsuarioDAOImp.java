package com.ipartek.formacion.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.UsuarioDAO;
import com.ipartek.formacion.dao.mappers.UsuarioMapper;
import com.ipartek.formacion.dao.persistence.Usuario;

@Repository("usuarioDAOImp")
public class UsuarioDAOImp implements UsuarioDAO {

	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	@SuppressWarnings("unused")
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAll() {
		final String SQL = "";
		List<Usuario> usuarios = null;
		usuarios = (List<Usuario>) jdbcCall.withProcedureName(SQL).returningResultSet("lista", new UsuarioMapper())
				.execute().get("lista");
		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		final String SQL = "";
		Usuario usuario = null;
		SqlParameterSource in = new MapSqlParameterSource().addValue("pid", id);
		usuario = (Usuario) jdbcCall.withProcedureName(SQL).returningResultSet("usuario", new UsuarioMapper())
				.execute(in).get("usuario");
		return usuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> find(Usuario usuario) {
		final String SQL = "";
		SqlParameterSource in = new MapSqlParameterSource().addValue("pid", usuario.getCodUsuario())
				.addValue("palledidos", usuario.getApellidos()).addValue("pnombre", usuario.getNombre())
				.addValue("pemail", usuario.getEmail()).addValue("puserid", usuario.getUserId());

		List<Usuario> usuarios = null;
		usuarios = (List<Usuario>) jdbcCall.withProcedureName(SQL).returningResultSet("lista", new UsuarioMapper())
				.execute(in).get("lista");
		return usuarios;
	}

	@Override
	public Usuario update(Usuario usuario) {
		final String SQL = "";
		SqlParameterSource in = new MapSqlParameterSource().addValue("pid", usuario.getCodUsuario())
				.addValue("palledidos", usuario.getApellidos()).addValue("pnombre", usuario.getNombre())
				.addValue("pemail", usuario.getEmail()).addValue("puserid", usuario.getUserId())
				.addValue("ppassword", usuario.getPassword());
		jdbcCall.withProcedureName(SQL).execute(in);

		return usuario;
	}

	@Override
	public Usuario create(Usuario usuario) {
		final String SQL = "";
		SqlParameterSource in = new MapSqlParameterSource().addValue("pid", usuario.getCodUsuario())
				.addValue("palledidos", usuario.getApellidos()).addValue("pnombre", usuario.getNombre())
				.addValue("pemail", usuario.getEmail()).addValue("puserid", usuario.getUserId())
				.addValue("ppassword", usuario.getPassword());
		Map<String, Object> out = jdbcCall.withProcedureName(SQL).execute(in);
		usuario.setCodUsuario((Integer) out.get("pcodigo"));
		return usuario;
	}

	@Override
	public void delete(int id) {
		final String SQL = "";
		SqlParameterSource in = new MapSqlParameterSource().addValue("pid", id);
		jdbcCall.withProcedureName(SQL).execute(in);
	}

	@Autowired
	@Override
	public void setDataSource(DataSource datasource) {
		this.dataSource = datasource;
		this.jdbcCall = new SimpleJdbcCall(datasource);
		this.jdbcTemplate = new JdbcTemplate(datasource);

	}

}
