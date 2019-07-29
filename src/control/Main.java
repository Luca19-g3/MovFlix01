package control;

import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

public class Main {

	public static void main(String[] args) {


PeliculaDao.altaPelicula(new Pelicula("La puta de oros", 2020, "2"));

VistaPelicula.mostrarListaPeliculas(PeliculaDao.listarPelicula());

		
	}
}
