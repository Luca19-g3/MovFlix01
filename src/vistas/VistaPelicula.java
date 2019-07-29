package vistas;

import java.util.List;

import modelo.Pelicula;

public class VistaPelicula {
  
  /**
	 * 
	 * Metodo para controlar la forma de mostrar el listado de películas
	 * @param List<Pelicula> listado de todas las películas 
	 * @return void
	 */
	
	public static void mostrarListaPeliculas(List<Pelicula> peliculas) {
		StringBuilder listado = new StringBuilder();
		
		listado.append("**********************\nListado de todas las peliculas:\n");
		for(Pelicula p:peliculas) {
			listado.append("Id: " + p.getId_pelicula() + " | Nombre: " + p.getNombre() + " | Anho de estreno: " + p.getAnho_estreno() + " | Categoria: " + p.getCategoria() + "\n");
			
		}
		System.out.println(listado);
	}
}
