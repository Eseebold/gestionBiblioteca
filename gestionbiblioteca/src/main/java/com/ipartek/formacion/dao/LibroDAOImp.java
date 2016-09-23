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
		List<Libro> libros = null;
		this.jdbcCall = new SimpleJdbcCall(dataSource).
				withProcedureName("getAllLibro").
				returningResultSet("libros", new LibroMapper());
		SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = jdbcCall.execute(in);
		libros = (List) out.get("libros");

		return libros;
	}

	@Override
	public Libro getById(int codigo) {
		Libro libro = new Libro();
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getByIdLibro");
		libro.setCodigo(codigo);
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", libro.getCodigo());
		Map<String, Object> out = jdbcCall.execute(in);
		libro.setTitulo((String) out.get("titulo"));
		libro.setAutor((String) out.get("autor"));
		libro.setIsbn((String) out.get("isbn"));

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

	public Libro update(Libro libro) {
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("updateLibro");
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", libro.getCodigo()).addValue("titulo", libro.getTitulo()).addValue("autor", libro.getAutor()).addValue("isbn", libro.getIsbn());
		Map<String, Object> out = jdbcCall.execute(in);
		return libro;
	}

	@Override
	public void delete(int codigo) {
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("deleteLibro");
		SqlParameterSource in = new MapSqlParameterSource().addValue("codigo", codigo);
		Map<String, Object> out = jdbcCall.execute(in);

	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

}
