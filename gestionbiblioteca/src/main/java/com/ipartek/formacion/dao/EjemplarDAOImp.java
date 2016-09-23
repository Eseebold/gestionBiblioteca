package com.ipartek.formacion.dao;

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

import com.ipartek.formacion.dao.interfaces.EjemplarDAO;
import com.ipartek.formacion.dao.mappers.EjemplarMapper;
import com.ipartek.formacion.dao.mappers.LibroMapper;
import com.ipartek.formacion.dao.persistence.Ejemplar;

/**
 * 
 * @author Turbo
 *
 */
@Repository("ejemplarDAOImp")
public class EjemplarDAOImp implements EjemplarDAO {

	private static final Logger logger = LoggerFactory.getLogger(EjemplarDAOImp.class);

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Ejemplar> getAll() {
		List<Ejemplar> ejemplares = null;
		this.jdbcCall = new SimpleJdbcCall(dataSource).
				withProcedureName("getAllEjemplar").
				returningResultSet("ejemplares", new EjemplarMapper());
		SqlParameterSource in = new MapSqlParameterSource();
		Map<String, Object> out = jdbcCall.execute(in);
		ejemplares = (List) out.get("ejemplares");

		return ejemplares;
	}

	@Override
	public Ejemplar getById(int id) {
		Ejemplar ejemplar = null;
		final String SQL = "SELECT codigo, editorial, paginas FROM ejemplar WHERE codigo = ?;";
		try {
			ejemplar = jdbctemplate.queryForObject(SQL, new Object[] { id }, new EjemplarMapper());
		} catch (EmptyResultDataAccessException e) {
			ejemplar = new Ejemplar();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("GetById ejecutado");
		return ejemplar;
	}

	@Override
	public Ejemplar create(Ejemplar ejemplar) {
		/*
		 * createUsuario --> Nombre del procedimiento almacenado
		 */
		jdbcCall.withProcedureName("createEjemplar");
		/*
		 * SqlParameterSource (tipo Map) guarda los paramentros necesarios para
		 * el procedimiento
		 */
		SqlParameterSource in = new MapSqlParameterSource().addValue("editorial", ejemplar.getEditorial()).addValue("paginas", ejemplar.getPaginas());

		Map<String, Object> out = jdbcCall.execute(in);
		/*
		 * Recogemos el parametro OUT del procedimiento
		 */
		ejemplar.setCodigo((Integer) out.get("codigo"));
		logger.info("create ejecutado");
		return ejemplar;
	}

	@Override
	public Ejemplar update(Ejemplar ejemplar) {
		final String SQL = "UPDATE ejemplar SET editorial = ?, paginas = ?  WHERE codigo = ?;";
		jdbctemplate.update(SQL, new Object[] { ejemplar.getEditorial(), ejemplar.getPaginas() });
		logger.info("update ejecutado");
		return ejemplar;

	}

	@Override
	public void delete(int id) {
		final String SQL = "DELETE FROM ejemplar WHERE codigo = ?;";
		jdbctemplate.update(SQL, new Object[] { id });
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
