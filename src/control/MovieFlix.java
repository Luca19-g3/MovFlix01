package control;

public class MovieFlix {

	
	public void iniciarAplicacion() {
		boolean seguir = true;
		do {
			//
		}while (seguir);
		System.out.println("---Fin de la sesion---");
		
	}
	/**
	 * @param: none
	 * @return: void
	*en esta parte se crear� un objeto de la interfaz IServicios
	*/
	
	public boolean seleccionarOpcion() {
		boolean continuar = true ;
		
		try {
			switch () {
			case 1:
				
				break;
			case 2: 
				
				break;

			case 3:
				
				break;

			case 4:
				
				break;

			case 5:
				
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

	/*private boolean salir() throws Exception {
		String sino = Datos.recogeString("   �Est� seguro?(S/N)");
		return (sino.toUpperCase().charAt(0) != 'S');
*/
}
