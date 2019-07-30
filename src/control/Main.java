package control;

import java.util.List;

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


		//MovieFlix mo = new MovieFlix();
		//mo.iniciarAplicacion();
		 Servicios s =  new Servicios();
		 s.obtenerPeliculasFilPorCategoria();
		 

	}
}