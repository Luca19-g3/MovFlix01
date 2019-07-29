package control;

import datos.PeliculaDao;
<<<<<<< HEAD
import 	datos.UsuarioDao;
=======
import datos.UsuarioDao;
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7
import modelo.Pelicula;
import modelo.Usuario;
<<<<<<< HEAD
public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		//PeliculaDao.altaPelicula(new Pelicula ("Torrente 6", 2020, "3"));
		UsuarioDao.altaUsuario(new Usuario("perico","22/13/1999","madrid"));
=======
		
		PeliculaDao.listarPelicula();
		UsuarioDao.listarUsuario();
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7
=======

public class Main {

	public static void main(String[] args) {

		PeliculaDao.altaPelicula(new Pelicula ("Torrente 6", 2020, "3"));
		
		for (Pelicula p : PeliculaDao.listarPelicula()) {
			System.out.println(p.toString());
		}

		for (Usuario u : UsuarioDao.listarUsuario()) {
			System.out.println(u.toString());
		}

	

>>>>>>> 931f3085fd7692c79f70b056c206f3b9795e3152
		
	}
}