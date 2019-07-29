package vistas;

public class VistaPelicula {
  
  /**
	 * 
	 * Método para controlar la forma de mostrar el listado de películas
	 * @param List<Pelicula> listado de todas las películas 
	 * @return void
	 * 
	 */
	public static void mostrarListaPeliculas(List<Pelicula> peliculas) {
		StringBuilder listado = new StringBuilder();
		
		listado.append("**********************\nListado de todas las películas:\n");
		for(Pelicula p:peliculas) {
			listado.append("Id: " + p.getId_pelicula() + " | Nombre: " + p.getNombre() + " | Año de estreno: " + p.getAño_estreno() + " | Categoría: " + p.getCategoria() + "\n");
			
		}
		System.out.println(listado);
	}
}
