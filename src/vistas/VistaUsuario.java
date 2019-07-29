package vistas;

import java.util.List;

import modelo.Pelicula;
import modelo.Usuario;

public class VistaUsuario {

	/**
	 * 
	 *Metodo para controlar la forma de mostrar el listado de Usuarios
	 * 
	 * @param List<Usuario> listado de todas las usuarios
	 * @return void
	 * 
	 */
	public static void mostrarListaUsuarios(List<Usuario> usuarios) {
		StringBuilder listado1 = new StringBuilder();

		listado1.append("**********************\nListado de todas las peliculas:\n");
		for (Usuario u : usuarios) {
			listado1.append(
					"Id: " + u.getId_usuario() + " | Nombre: " + u.getNombre_completo() + " | fecha de nacimiento: "
							+ u.getFecha_nacimiento() + " | ciudad de residencia: " + u.getCiudad_residencia() + "\n");

		}
		System.out.println(listado1);
	}
}
