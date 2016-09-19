package com.ipartek.formacion.dao.persistence;

import java.util.Date;

/**
 * 
 * @author Turbo
 *
 */
public class Usuario {

	private int codigo;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private String email;

	public Usuario() {
		super();
		setCodigo(0);
		setNombre("");
		setApellidos("");
		setfNacimiento(new Date());
		setEmail("");

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
