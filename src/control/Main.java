package control;

import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;

public class Main {

	public static void main(String[] args) {
		
		PeliculaDao.listarPelicula();
		UsuarioDao.listarUsuario();
		
	}
}
