package servicios;

import modelo.Pelicula;

//1.17. Crear la clase Servicios en el paquete servicios con el m�todo public boolean altaPelicula() [PDS]

public class Servicios {

	public Servicios() {
		
	}
	
	public void altaPelicula () {
		Pelicula pel = new Pelicula();
		pel.crearPelicula();
		
	}

}
