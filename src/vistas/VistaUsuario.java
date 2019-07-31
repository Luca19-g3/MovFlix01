package vistas;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import modelo.Pelicula;
import modelo.Usuario;

public class VistaUsuario {
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
	 * Metodo para controlar la forma de mostrar el listado de Usuarios
	 * 
	 * @param List<Usuario> listado de todas las usuarios
	 * @return void
	 * 
	 */
	public static void mostrarListaUsuarios(List<Usuario> usuarios) {
		logger.debug("Ejecutando metodo mostrarListaUsuarios en la clase VistaUsuario");
		StringBuilder listado1 = new StringBuilder();

		listado1.append("**********************\nListado de usuarios:\n");
		for (Usuario u : usuarios) {
			listado1.append(
					"Id: " + u.getId_usuario() + " | Nombre: " + u.getNombre_completo() + " | fecha de nacimiento: "
							+ u.getFecha_nacimiento() + " | ciudad de residencia: " + u.getCiudad_residencia() + "\n");

		}
		System.out.println(listado1);
	}
}
