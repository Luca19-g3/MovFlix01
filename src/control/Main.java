package control;

import datos.PeliculaDao;
<<<<<<< HEAD
import 	datos.UsuarioDao;
=======
import datos.UsuarioDao;
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7
import modelo.Pelicula;
import modelo.Usuario;
public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		//PeliculaDao.altaPelicula(new Pelicula ("Torrente 6", 2020, "3"));
		UsuarioDao.altaUsuario(new Usuario("perico","22/13/1999","madrid"));
=======
		
		PeliculaDao.listarPelicula();
		UsuarioDao.listarUsuario();
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7
		
	}
}