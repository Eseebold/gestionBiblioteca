package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Ejemplar;

/**
 * 
 * @author Turbo
 *
 */
public class EjemplarMapper implements RowMapper<Ejemplar> {

	public Ejemplar mapRow(ResultSet rs, int arg1) throws SQLException {
		Ejemplar ejemplar = new Ejemplar();
		ejemplar.setCodigo(rs.getInt("codigo"));
		ejemplar.setEditorial(rs.getString("editorial"));
		ejemplar.setPaginas(rs.getInt("paginas"));
		return ejemplar;

	}

}
