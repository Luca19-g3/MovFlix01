package control;

import datos.CategoriaDao;
import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Categoria;
import modelo.Pelicula;
import modelo.Usuario;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

public class Main {

	public static void main(String[] args) {
		//PeliculaDao d =new PeliculaDao();
		//d.modificarPelicula(new Pelicula("La sota de bastos", 2020, "2"),30);
		//VistaPelicula.mostrarListaPeliculas(d.listarPelicula());
		//PeliculaDao pd =  new PeliculaDao();
		//UsuarioDao ud = new UsuarioDao();
		//ud.modificarUsuario(new Usuario("Manolo", "22/15/2020", "asturias"), 4);
		
		//ud.bajaUsuario(7);
		//VistaUsuario.mostrarListaUsuarios(ud.listarUsuario());
		//d.bajaPelicula(1);
		//PeliculaDao.modificarPelicula(new Pelicula("La sota de oros", 2020, "2"),30);
		//VistaPelicula.mostrarListaPeliculas(PeliculaDao.listarPelicula());
	
		
		//System.out.println( pd.bajaPelicula(2));
		
		CategoriaDao d =new CategoriaDao();
		//d.modificarCategoria(new Categoria("modificada"), 6);
		d.bajaCategoria(5);
		
	}
}
