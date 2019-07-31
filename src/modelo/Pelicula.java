/**
 * Clase Pelicula
 * Clase modelo para gestionar las Peliculas
 *@author grupo3
 *@version 1.0
 * fecha 31/07/2019
 * 
 */
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

	public Pelicula(int id_pelicula, String nombre, int anho_estreno, String categoria) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.anho_estreno = anho_estreno;
		this.categoria = categoria;
	}

	public Pelicula(String nombre, int anho_estreno, String categoria) {
		super();
		this.nombre = nombre;
		this.anho_estreno = anho_estreno;
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

	public int getAnho_estreno() {
		return anho_estreno;
	}

	public void setAnho_estreno(int anho_estreno) {
		this.anho_estreno = anho_estreno;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Metodo que pide los datos al usuario y se los pasa a la Pelicula
	 * 
	 * @param none
	 * @return void
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
		return "Pelicula [id_pelicula=" + id_pelicula + ", nombre=" + nombre + ", anho_estreno=" + anho_estreno
				+ ", categoria=" + categoria + "]";
	}

}
