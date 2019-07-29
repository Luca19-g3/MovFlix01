package control;

import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

public class Main {

	public static void main(String[] args) {
		PeliculaDao d =new PeliculaDao();

<<<<<<< HEAD
		PeliculaDao pd =  new PeliculaDao();
		UsuarioDao ud = new UsuarioDao();
		
ud.bajaUsuario(7);

VistaUsuario.mostrarListaUsuarios(ud.listarUsuario());
=======
		d.bajaPelicula(1);
		//PeliculaDao.modificarPelicula(new Pelicula("La sota de oros", 2020, "2"),30);

		//VistaPelicula.mostrarListaPeliculas(PeliculaDao.listarPelicula());
>>>>>>> 279ff0cd60a53c66b67c96684c6853a70229241e

		
	}
}
