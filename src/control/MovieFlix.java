package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Menu;
import servicios.Servicios;
import utilidades.Datos;

public class MovieFlix {

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
	 * Metodo para iniciar la aplicación
	 * 
	 * @param: none
	 * @return: void
	 */

	public void iniciarAplicacion() {

		logger.info("Inicio de la aplicacion----");
		boolean seguir = true;
		do {
			Menu.mostrarMenu();
			seguir = this.seleccionarOpcion();
		} while (seguir);

		logger.info("Fin de la aplicacion----");

	}

	Servicios servicio = new Servicios();

	/**
	 * Metodo que gestiona la elección de opciones del menú del usuario
	 * 
	 * @param: none
	 * @return: boolean
	 */
	public boolean seleccionarOpcion() {
		boolean continuar = true;

		try {
			switch (Datos.recogeInt()) {
			case 1:
				logger.debug("Ha elegido la opcion 1");
				servicio.altaPelicula();

				break;
			case 2:
				logger.debug("Ha elegido la opcion 2");
				servicio.modificarUsuario();
				break;

			case 3:
				logger.debug("Ha elegido la opcion 3");
				servicio.bajaPelicula();
				break;

			case 4:
				logger.debug("Ha elegido la opcion 4");
				servicio.listarPeliculas();
				break;

			case 5:
				logger.debug("Ha elegido la opcion 5");
				servicio.altaUsuarios();
				break;

			case 6:
				logger.debug("Ha elegido la opcion 6");
				servicio.modificarUsuario();
				break;

			case 7:
				logger.debug("Ha elegido la opcion 7");
				servicio.bajaUsuario();
				break;
			case 8:
				logger.debug("Ha elegido la opcion 8");
				servicio.listarUsuarios();
				break;

			case 9:
				logger.debug("Ha elegido la opcion 9");
				servicio.altaCategoria();
				break;

			case 10:
				logger.debug("Ha elegido la opcion 10");
				servicio.modificarCategoria();
				break;

			case 11:
				logger.debug("Ha elegido la opcion 11");
				servicio.bajaCategoria();
				break;

			case 12:
				logger.debug("Ha elegido la opcion 12");
				servicio.listarPeliculas();
				break;
			case 13:
				logger.debug("Ha elegido la opcion 13"); 
				servicio.listarPeliculasPeliculasMasValoradas();
				break;
			case 14:
				logger.debug("Ha elegido la opcion 14"); 
				servicio.listarPeliculasPeliculasMasVistas();
				break;
			case 15:
				logger.debug("Ha elegido la opcion 14"); 
				servicio.listarPeliculasVistas();
				break;
			case 16:
				logger.debug("Ha elegido la opcion 16"); 
				servicio.listarPeliculasNoVistas();
				break;
			case 0:
				logger.debug("Ha elegido la opcion: Terminar programa");
				break;
			}
		} catch (Exception e) {
			System.out.println("error: " + e.toString());
		}
		return continuar;
	}

	/*
	 * private boolean salir() throws Exception { String sino =
	 * Datos.recogeString("   ¿Está seguro?(S/N)"); return
	 * (sino.toUpperCase().charAt(0) != 'S');
	 */
}
