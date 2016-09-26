package com.ipartek.formacion.controller.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Ejemplar;

public class EjemplarValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioValidator.class);

	public boolean supports(Class<?> argumento) {
		return Ejemplar.class.equals(argumento);
	}

	public void validate(Object obj, Errors errors) {
		// ########## Metodo para ver si los siguientes campos estan o no vacios
		ValidationUtils.rejectIfEmpty(errors, "editorial", "editorialRequest", "¿Quien lo ha editado?");
		ValidationUtils.rejectIfEmpty(errors, "paginas", "paginasRequest", "paginas no puede estar vacio");

		Ejemplar eje = (Ejemplar) obj;

		// ########## Metodo para ver si el codigo es 1 o superior
		if (eje.getCodLibro() < 0) {
			errors.rejectValue("codigo", "codigoNulo", new Object[] { "'codigo'" }, "No puede ser ese valor");
		}



	}
}
