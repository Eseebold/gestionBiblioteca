package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Libro;

/**
 * 
 * @author Turbo
 *
 */
public class LibroMapper implements RowMapper<Libro> {

	public Libro mapRow(ResultSet rs, int arg1) throws SQLException {
		Libro libro = new Libro();
		libro.setCodigo(rs.getInt("codigo"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAutor(rs.getString("autor"));
		libro.setIsbn(rs.getString("isbn"));
		libro.setDisponibles(rs.getInt("disponibles"));
		return libro;

	}

}
