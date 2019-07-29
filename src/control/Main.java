package control;

import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;

public class Main {

	public static void main(String[] args) {

		PeliculaDao.altaPelicula(new Pelicula ("Torrente 6", 2020, "3"));
		
		for (Pelicula p : PeliculaDao.listarPelicula()) {
			System.out.println(p.toString());
		}

		for (Usuario u : UsuarioDao.listarUsuario()) {
			System.out.println(u.toString());
		}

	

		
	}
}
