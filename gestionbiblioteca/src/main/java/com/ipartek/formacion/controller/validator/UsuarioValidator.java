package com.ipartek.formacion.controller.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ipartek.formacion.dao.persistence.Usuario;

public class UsuarioValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioValidator.class);

	public boolean supports(Class<?> argumento) {
		return Usuario.class.equals(argumento);
	}

	public void validate(Object obj, Errors errors) {
		// ########## Metodo para ver si los siguientes campos estan o no vacios
		ValidationUtils.rejectIfEmpty(errors, "codejemplar", "codigoRequest", "En caso de que no tenga ningun ejemplar, escriba 0");
		ValidationUtils.rejectIfEmpty(errors, "nombre", "nombreRequest", "�El usuario carece de nombre? �Podria bautizarte como Poncho?");
		ValidationUtils.rejectIfEmpty(errors, "apellidos", "apellidosRequest", "Apellidos no puede estar vacio");
		ValidationUtils.rejectIfEmpty(errors, "fnacimiento", "fnacimientoRequerida", "Fecha de nacimiento requerida");
		ValidationUtils.rejectIfEmpty(errors, "email", "emailRequeridos", "Email requerido");

		Usuario usu = (Usuario) obj;

		// ########## Metodo para ver si el codigo es 1 o superior
		if (usu.getCodigo() < 0) {
			errors.rejectValue("codigo", "codigoNulo", new Object[] { "'codigo'" }, "No puede ser ese valor");
		}

		// ########## Metodo para ver si la fecha introducida no es del futuro
		Calendar fIntroducida = new GregorianCalendar();
		Calendar fActual = new GregorianCalendar();
		fIntroducida.setTime(usu.getFnacimiento());
		fActual.setTime(new Date());

		fIntroducida.set(Calendar.HOUR, 0);
		fIntroducida.set(Calendar.HOUR_OF_DAY, 0);
		fIntroducida.set(Calendar.MINUTE, 0);
		fIntroducida.set(Calendar.SECOND, 0);
		fIntroducida.set(Calendar.MILLISECOND, 0);

		fActual.set(Calendar.HOUR, 0);
		fActual.set(Calendar.HOUR_OF_DAY, 0);
		fActual.set(Calendar.MINUTE, 0);
		fActual.set(Calendar.SECOND, 0);
		fActual.set(Calendar.MILLISECOND, 0);

		if (fIntroducida.compareTo(fActual) >= 0) {
			errors.rejectValue("fnacimiento", "fechaInvalida", new Object[] { "'fnacimiento'" }, "La fecha debe ser anterior al dia de hoy");
		}
		// ########## Metodo para ver si el email tiene formato valido
		if (!usu.getEmail().matches("[0-9a-zA-Z\\.]+@[a-zA-Z]+.[a-zA-Z]{1,3}")) {
			errors.rejectValue("email", "emailInvalido", new Object[] { "'email'" }, "El email tiene un formato no valido");
		}

	}
}
