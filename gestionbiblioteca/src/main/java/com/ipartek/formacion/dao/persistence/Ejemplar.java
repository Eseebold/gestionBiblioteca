package com.ipartek.formacion.dao.persistence;

/**
 * 
 * @author Turbo
 *
 */
public class Ejemplar {

	private int codigo;
	private String titulo;
	private String editorial;
	private int paginas;

	public Ejemplar() {
		super();
		setCodigo(0);
		setEditorial("");
		setPaginas(0);

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
