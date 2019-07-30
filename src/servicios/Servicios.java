package servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
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
	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private PeliculaDao pd = new PeliculaDao();
	private UsuarioDao ud = new UsuarioDao();

	public Servicios() {

	}
	/**
	 * Lista las peliculas
	 * 
	 * @param none
	 * @return void
	 */
	public void listarPeliculas() {
		logger.debug("Ejecutando metodo listarPeliculas en la clase Servicios");
		VistaPelicula.mostrarListaPeliculas(pd.listarPelicula());
	}
	/**
	 * Da de alta un usuario
	 * 
	 * @param none
	 * @return void
	 */
	public void altaUsuario() {
		logger.debug("Ejecutando metodo altaUsuario en la clase Servicios");
		Usuario usu = new Usuario();
		usu.crearUsuario();
	}

	/**
	 * Da de alta una pelicula
	 * 
	 * @param none
	 * @return void
	 */

	public void altaPelicula() {
		logger.debug("Ejecutando metodo altaPelicula en la clase Servicios");
		Pelicula p = new Pelicula();
		p.crearPelicula();
		pd.altaPelicula(p);
	}
	/**
	 * Lista los usuarios
	 * 
	 * @param none
	 * @return void
	 */
	public void listarUsuarios() {
		logger.debug("Ejecutando metodo listarUsuarios en la clase Servicios");
		VistaUsuario.mostrarListaUsuarios(ud.listarUsuario());
	}
	/**
	 * Da de alta un usuario
	 * 
	 * @param none
	 * @return void
	 */
	public void altaUsuarios() throws Exception {
		logger.debug("Ejecutando metodo altaUsuarios en la clase Servicios");
		Usuario usu = new Usuario();
		usu.crearUsuario();
		ud.altaUsuario(usu);
	}
	public void modificarUsuario() {
		
	}

}
