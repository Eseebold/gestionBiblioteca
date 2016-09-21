package com.ipartek.formacion.dao.persistence;


/**
 * 
 * @author Turbo
 *
 */
public class Libro {

	private int codigo;
	private String titulo;
	private String autor;
	private String isbn;

	public Libro() {
		super();
		setCodigo(0);
		setTitulo("");
		setAutor("");
		setIsbn("");

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
