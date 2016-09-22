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

import com.ipartek.formacion.dao.interfaces.LibroDAO;
import com.ipartek.formacion.dao.mappers.LibroMapper;
import com.ipartek.formacion.dao.persistence.Libro;

/**
 * 
 * @author Turbo
 *
 */
@Repository("libroDAOImp")
public class LibroDAOImp implements LibroDAO {

	private static final Logger logger = LoggerFactory.getLogger(LibroDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Libro> getAll() {
		List<Libro> libros = new ArrayList<Libro>();
		final String SQL = "SELECT codigo, titulo, autor, isbn FROM libro WHERE codigo > 0;";
		try {
			libros = jdbctemplate.query(SQL, new LibroMapper());
		} catch (EmptyResultDataAccessException e) {
			libros = new ArrayList<Libro>();
			logger.info("EmptyResultDataAccessException");
		} catch (Exception e) {
			logger.error(e.getMessage() + " Exception");
		}
		logger.info("GetAll ejecutado");
		return libros;
	}

	@Override
	public Libro getById(int id) {
		Libro libro = null;
		final String SQL = "SELECT codigo, titulo, autor, isbn FROM libro WHERE codigo = ?;";
		try {
			libro = jdbctemplate.queryForObject(SQL, new Object[] { id }, new LibroMapper());
		} catch (EmptyResultDataAccessException e) {
			libro = new Libro();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("GetById ejecutado");
		return libro;
	}

	@Override
	public Libro create(Libro libro) {
		/*
		 * createUsuario --> Nombre del procedimiento almacenado
		 */
		jdbcCall.withProcedureName("createLibro");
	
		SqlParameterSource in = new MapSqlParameterSource().addValue("titulo", libro.getTitulo()).addValue("autor", libro.getAutor()).addValue("isbn", libro.getIsbn());
		Map<String, Object> out = jdbcCall.execute(in);
		libro.setCodigo((Integer) out.get("codigo"));
		logger.info("create ejecutado");
		return libro;
	}

	@Override
	public Libro update(Libro libro) {
		final String SQL = "UPDATE libro SET titulo = ?, autor = ?, isbn = ?  WHERE codigo = ?;";
		jdbctemplate.update(SQL, new Object[] { libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.getCodigo() });
		logger.info("update ejecutado");
		return libro;

	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM libro WHERE codigo = ?;";
		jdbctemplate.update(SQL, new Object[] { id });
		logger.info("delete ejecutado en codigo: "+id);
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
}
