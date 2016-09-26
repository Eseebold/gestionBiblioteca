package com.ipartek.formacion.dao.persistence;

import java.util.ArrayList;
import java.util.List;

public class Libro {

	private int codLibro;
	private String titulo;
	private String autor;
	private List<Ejemplar> ejemplares;
	private String isbn;

	public Libro() {
		super();
		setCodLibro(-1);
		setTitulo("");
		setAutor("");
		setIsbn("");
		setEjemplares(new ArrayList<Ejemplar>());
	}

	public void addEjemplar(Ejemplar ejemplar) {
		this.ejemplares.add(ejemplar);
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	/**
	 * @return the codLibro
	 */
	public int getCodLibro() {
		return codLibro;
	}

	/**
	 * @param codLibro
	 *            the codLibro to set
	 */
	public void setCodLibro(int codLibro) {
		this.codLibro = codLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
