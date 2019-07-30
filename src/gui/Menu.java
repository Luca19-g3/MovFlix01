package gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;

public class Menu {
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
	 * Imprime las diferentes opciones del menu
	 * 
	 * @param none
	 * @return void
	 */

	public static void mostrarMenu() {
		logger.trace("Ejecutando menu");
		System.out.println(" ");
		System.out.println(" MovieFlix ");
		System.out.println(" ");
		System.out.println("************************************************");
		System.out.println("1. Alta pelicula");
		System.out.println("2. Modificar pelicula");
		System.out.println("3. Baja pelicula");
		System.out.println("4. Listar peliculas");
		System.out.println("5. Alta usuario");
		System.out.println("6. Modificar Usuario");
		System.out.println("7. Baja Usuario");
		System.out.println("8. Listar Usuarios");

	}
}
