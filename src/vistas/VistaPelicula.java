package vistas;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import modelo.Pelicula;

public class VistaPelicula {
	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}
  
  /**
	 * 
	 * Metodo para controlar la forma de mostrar el listado de películas
	 * @param List<Pelicula> listado de todas las películas 
	 * @return void
	 */
	
	public static void mostrarListaPeliculas(List<Pelicula> peliculas, String mensaje) {
		logger.debug("Ejecutando metodo mostrarListaPeliculas() en la clase VistaPelicula");
		StringBuilder listado = new StringBuilder();
		
		listado.append("**********************\n"+mensaje+":\n");
		for(Pelicula p:peliculas) {
			listado.append("Id: " + p.getId_pelicula() + " | Nombre: " + p.getNombre() + " | Anho de estreno: " + p.getAnho_estreno() + " | Categoria: " + p.getCategoria() + "\n");
			
		}
		System.out.println(listado);
	

	} 
	/* Metodo para controlar la forma de mostrar el listado de películas mas visitas
	 * @param List<Pelicula> listado de todas las películas 
	 * @return void
	 */
	
	public static void mostrarPeliculasMasVistas(List<String> peliculas) {
		logger.debug("Ejecutando metodo mostrarPeliculasMasVistas(List<String> peliculas)");
		StringBuilder listado = new StringBuilder();
		
		listado.append("**********************\nListado de todas las peliculas mas vistas:\n");
		for(String p:peliculas) {

		listado.append(p+"\n");
		
		}
		System.out.println(listado);

	}	
	/* Metodo para controlar la forma de mostrar el listado de películas mas valoradas
	 * @param List<Pelicula> listado de todas las películas 
	 * @return void
	 */
	public static void mostrarPeliculasMasValoradas(List<String> peliculas) {
		logger.debug("Ejecutando metodo mostrarPeliculasMasValoradas(List<String> peliculas)");
		StringBuilder listado = new StringBuilder();
		
		listado.append("**********************\nListado de todas las peliculas mas valoradas:\n");
		for(String p:peliculas) {

		listado.append(p+"\n");
		
		}
		System.out.println(listado);

	}
	
}


