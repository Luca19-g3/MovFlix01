package control;

import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

public class Main {

	public static void main(String[] args) {

 VistaUsuario.mostrarListaUsuarios(UsuarioDao.listarUsuario());

		
	}
}
