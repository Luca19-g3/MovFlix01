package servicios;
import datos.IUsuarioDao;
import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Datos;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

//1.17. Crear la clase Servicios en el paquete servicios con el método public boolean altaPelicula() [PDS]

public class Servicios {
	
	private PeliculaDao pd =  new PeliculaDao();
	private UsuarioDao ud = new UsuarioDao();

	public Servicios() {

	}


	
	public void listarPeliculas() {
		VistaPelicula.mostrarListaPeliculas(pd.listarPelicula());
	}

	public void altaUsuario() {
		
		Usuario usu = new Usuario();
		usu.crearUsuario();
	}

	public void listarUsuarios() {
		//VistaUsuario.mostrarListaUsuarios(UsuarioDao.listarUsuario());
	}
	public void altaUsuarios() throws Exception {
		Usuario usu = new Usuario();
		usu.crearUsuario();
		UsuarioDao.altaUsuario(usu);
	}
	

}
