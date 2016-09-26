package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = null;
		user = new Usuario();
		user.setNombre(rs.getString("usuNombre"));
		user.setApellidos(rs.getString("usuApellidos"));
		user.setEmail(rs.getString("usuEmail"));
		user.setCodUsuario(rs.getInt("usuCodigo"));
		user.setFechanacimiento(rs.getDate("usuDate"));
		user.setPassword(rs.getString("usuPassword"));

		return user;
	}

}
