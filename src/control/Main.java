package control;

import datos.PeliculaDao;
import modelo.Pelicula;

public class Main {

	public static void main(String[] args) {
		PeliculaDao.altaPelicula(new Pelicula ("Torrente 6", 2020, "3"));
		
	}
}
