package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.dao.persistence.Usuario;

public class EjemplarMapper implements RowMapper<Ejemplar> {
	private Usuario usuario;

	@Override
	public Ejemplar mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.usuario = new Usuario();
		// TODO recoger parametros de ejemplar, libro y usuario
		Ejemplar ejemplar = null;
		ejemplar = new Ejemplar(usuario);
		return ejemplar;
	}

}
