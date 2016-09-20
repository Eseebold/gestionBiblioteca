package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Usuario;

/**
 * 
 * @author Turbo
 *
 */
public class UsuarioMapper implements RowMapper<Usuario> {

	public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setCodigo(rs.getInt("codigo"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setfNacimiento(rs.getDate("fNacimiento"));
		usuario.setEmail(rs.getString("email"));
		return usuario;

	}

}
