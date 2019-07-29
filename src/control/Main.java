package control;

import datos.PeliculaDao;
import 	datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;
public class Main {

	public static void main(String[] args) {
		//PeliculaDao.altaPelicula(new Pelicula ("Torrente 6", 2020, "3"));
		UsuarioDao.altaUsuario(new Usuario("perico","22/13/1999","madrid"));
		
	}
}