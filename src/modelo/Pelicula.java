package modelo;

import utilidades.Datos;

public class Pelicula {

	private int id_pelicula;
	private String nombre;
	private int anho_estreno;
	private String categoria;

	public Pelicula() {
		super();
	}

	public Pelicula(int id_pelicula, String nombre, int año_estreno, String categoria) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.anho_estreno = año_estreno;
		this.categoria = categoria;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño_estreno() {
		return anho_estreno;
	}

	public void setAño_estreno(int año_estreno) {
		this.anho_estreno = año_estreno;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * este metodo pide nombre, categoria y año de estreno para crear objetos de la
	 * clase pelicula
	 * 
	 * @param none 
	 * @return void
	 * 
	 */

	public void crearPelicula() {
		try {

			this.nombre = Datos.recogeString("Introduce el nombre de la pelicula: ");
			this.anho_estreno = Datos.recogeInt("Introduce el año de estreno: ");
			this.categoria = Datos.recogeString("Introduzca la categoria de la pelicula: ");

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", nombre=" + nombre + ", año_estreno=" + anho_estreno
				+ ", categoria=" + categoria + "]";
	}

}
