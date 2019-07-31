package modelo;

import utilidades.Datos;

public class Categoria {
	private int idcategoria;
	private String nombre;

	public Categoria() {
		super();
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Categoria(int idcategoria, String nombre) {
		super();
		this.idcategoria = idcategoria;
		this.nombre = nombre;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que pide los datos al usuario y se los pasa a la categoria
	 * 
	 * @param none
	 * @return void
	 */
	public void crearCategoria() {
		try {
			this.nombre = Datos.recogeString("Digite el nombre de la categoria");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", nombre=" + nombre + "]";
	}
}
