package control;

import datos.CategoriaDao;
import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Categoria;
import modelo.Pelicula;
import modelo.Usuario;
import servicios.Servicios;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

public class Main {

	public static void main(String[] args) {

		Servicios s = new Servicios();
		//s.modificarUsuario();
		s.modificarCategoria();
	}
}
