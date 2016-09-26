package com.ipartek.formacion.controller.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Libro;

public class LibroValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioValidator.class);

	public boolean supports(Class<?> argumento) {
		return Libro.class.equals(argumento);
	}

	public void validate(Object obj, Errors errors) {
		// ########## Metodo para ver si los siguientes campos estan o no vacios
		ValidationUtils.rejectIfEmpty(errors, "titulo", "tituloRequest", "inserte requerido");
		ValidationUtils.rejectIfEmpty(errors, "autor", "nombreRequest", "autor requerido");
		ValidationUtils.rejectIfEmpty(errors, "isbn", "isbnRequeridos", "isbn requerido");

		Libro lib = (Libro) obj;

		// ########## Metodo para ver si el codigo es 1 o superior
		if (lib.getCodLibro() < 0) {
			errors.rejectValue("codigo", "codigoNulo", new Object[] { "'codigo'" }, "No puede ser ese valor");
		}



	}
}
