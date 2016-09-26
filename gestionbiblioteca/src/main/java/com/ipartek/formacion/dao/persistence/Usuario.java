package com.ipartek.formacion.dao.persistence;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private int codUsuario;
	private String nombre;
	private String apellidos;
	private Date fechanacimiento;
	private String email;
	private String usernick;
	private String userpass;

	public Usuario() {
		super();

		setFechanacimiento(new Date());
		setEmail("");
		setUserId("");
		setPassword("");
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fNacimiento) {
		this.fechanacimiento = fNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return usernick;
	}

	public void setUserId(String userId) {
		this.usernick = userId;
	}

	public String getPassword() {
		return userpass;
	}

	public void setPassword(String password) {
		this.userpass = password;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the codUsuario
	 */
	public int getCodUsuario() {
		return codUsuario;
	}

	/**
	 * @param codUsuario the codUsuario to set
	 */
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
}
