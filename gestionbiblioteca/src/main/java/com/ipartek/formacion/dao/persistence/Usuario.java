	package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 * 
 * @author Turbo
 *
 */
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Min(value = 1)
	private int codigo;
	@NotNull
	private String codejemplar;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@NotNull
	@Past
	private Date fnacimiento;
	private String email;

	public Usuario() {
		super();
		setCodigo(0);
		setNombre("");
		setApellidos("");
		setFnacimiento(new Date());
		setEmail("");

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCodejemplar() {
		return codejemplar;
	}

	public void setCodejemplar(String string) {
		this.codejemplar = string;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
