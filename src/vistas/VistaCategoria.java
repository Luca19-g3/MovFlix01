package vistas;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import control.MovieFlix;
import modelo.Categoria;

public class VistaCategoria {
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona");
		}
	}

	/**
	 * 
	 * Metodo para controlar la forma de mostrar el listado de Usuarios
	 * 
	 * @param List<Usuario> listado de todas las usuarios
	 * @return void
	 * 
	 */
	public static void mostrarListaCategorias(List<Categoria> categorias) {
		logger.debug("Ejecutando metodo mostrarListaCategorias en la clase VistaUsuario");
		StringBuilder listado = new StringBuilder();

		listado.append("**********************\nListado de categorias:\n");
		for (Categoria c : categorias) {
			listado.append(c.getIdcategoria() + " . " + c.getNombre() + "\n");

		}
		System.out.println(listado);
	}

}
