/**
 * Clase Menu
 * Clase que contiene el menu de la aplicacion
 *@author grupo3
 *@version 1.0
 * fecha 31/07/2019
 * 
 */
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
			System.out.println("Logger no funciona");
		}
	}

	/**
	 * Metodo que imprime las diferentes opciones del menu
	 * 
	 * @param none
	 * @return void
	 */

	public static void mostrarMenu() {
		logger.debug("Ejecutando menu");
		System.out.println(" ");
		System.out.println(" MovieFlix ");
		System.out.println(" ");

		System.out.println("---------------------");
		System.out.println(" GESTION PELICULAS ");
		System.out.println("1. Alta pelicula");
		System.out.println("2. Modificar pelicula");
		System.out.println("3. Baja pelicula");
		System.out.println("4. Listar peliculas");
		System.out.println("---------------------");
		System.out.println("  GESTION USUARIOS ");
		System.out.println("5. Alta usuario");
		System.out.println("6. Modificar Usuario");
		System.out.println("7. Baja Usuario");
		System.out.println("8. Listar Usuarios");
		System.out.println("---------------------");
		System.out.println("  GESTION CATEGORIAS");
		System.out.println("9. Alta categoria");
		System.out.println("10. Modificar categoria");
		System.out.println("11. Baja categoria");
		System.out.println("12. Listar categorias");
		System.out.println("---------------------");
		System.out.println(" GESTION APLICACION ");
		System.out.println("13. Mostrar peliculas mas valoradas");
		System.out.println("14. Mostrar peliculas mas vistas");
		System.out.println("15. Mostrar peliculas vistas por un usuario");
		System.out.println("16. Mostrar peliculas no vistas por un usuario");
		System.out.println("17. Mostrar peliculas filtradas por categorias");
		System.out.println("0. -----Terminar sesion----");
		System.out.println("Digite la opcion que desea emplear segun la numeracion:");
	}

}
