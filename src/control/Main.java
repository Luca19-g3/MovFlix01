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

		d.bajaPelicula(1);
		//PeliculaDao.modificarPelicula(new Pelicula("La sota de oros", 2020, "2"),30);

		//VistaPelicula.mostrarListaPeliculas(PeliculaDao.listarPelicula());

		
	}
}
