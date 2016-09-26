package com.ipartek.formacion.dao.persistence;

public class Ejemplar extends Libro {
	private int codEjemplar;
	private Usuario usuario;
	private String editorial;
	private int nPaginas;

	public Ejemplar(Usuario usuario) {
		super();
		setUsuario(usuario);
		setEditorial("");
		setnPaginas(0);
	}

	/**
	 * @return the nPaginas
	 */
	public int getnPaginas() {
		return nPaginas;
	}

	/**
	 * @param nPaginas
	 *            the nPaginas to set
	 */
	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the codEjemplar
	 */
	public int getCodEjemplar() {
		return codEjemplar;
	}

	/**
	 * @param codEjemplar
	 *            the codEjemplar to set
	 */
	public void setCodEjemplar(int codEjemplar) {
		this.codEjemplar = codEjemplar;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}