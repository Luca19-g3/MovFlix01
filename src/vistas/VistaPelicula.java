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
	
	public static void mostrarListaPeliculas(List<Pelicula> peliculas) {
		logger.debug("Ejecutando metodo mostrarListaPeliculas() en la clase VistaPelicula");
		StringBuilder listado = new StringBuilder();
		
		listado.append("**********************\nListado de todas las peliculas:\n");
		for(Pelicula p:peliculas) {
			listado.append("Id: " + p.getId_pelicula() + " | Nombre: " + p.getNombre() + " | Anho de estreno: " + p.getAnho_estreno() + " | Categoria: " + p.getCategoria() + "\n");
			
		}
		System.out.println(listado);
	
	}
	
}
