package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	
	public void iniciarAplicacion() {
		
		logger.info("Inicio de la aplicacion----");
		boolean seguir = true;
		do {
			//
		} while (seguir);
		logger.info("Fin de la aplicacion----");


	}

	/**
	 * @param: none
	 * @return: void en esta parte se creará un objeto de la interfaz IServicios
	 */
	Servicios servicio = new Servicios();

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
				break;

			case 3:
				logger.debug("Ha elegido la opcion 3");
				break;

			case 4:
				logger.debug("Ha elegido la opcion 4");
				break;

			case 5:
				logger.debug("Ha elegido la opcion 5");
				servicio.altaUsuarios();
				break;

			case 6:
				logger.debug("Ha elegido la opcion 6");
				break;

			case 7:
				logger.debug("Ha elegido la opcion 7");
				break;

			case 8:
				logger.debug("Ha elegido la opcion 8");
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
