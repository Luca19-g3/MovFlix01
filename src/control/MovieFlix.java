package control;

import servicios.Servicios;
import utilidades.Datos;

public class MovieFlix {
	
	/**
	 * Método para iniciar la aplicación
	 * @param: none
	 * @return: void 
	 */
	public void iniciarAplicacion() {
		boolean seguir = true;
		do {
		//
		} while (seguir);
		System.out.println("---Fin de la sesion---");
	}

	Servicios servicio = new Servicios();
	
	/**
	 * Método que gestiona la elección de opciones del menú del usuario
	 * @param: none
	 * @return: boolean
	 */
	public boolean seleccionarOpcion() {
		boolean continuar = true;

		try {
			switch (Datos.recogeInt()) {
			case 1:
				servicio.altaPelicula();

				break;
			case 2:
				
				break;

			case 3:

				break;

			case 4:

				break;

			case 5:
				servicio.altaUsuarios();
				break;

			case 6:

				break;

			case 7:

				break;

			case 8:

				break;

			case 0:

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
