package servicios;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import datos.CategoriaDao;
import datos.IUsuarioDao;
import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Categoria;
import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Datos;
import vistas.VistaCategoria;
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
	private CategoriaDao cd = new CategoriaDao();

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
		VistaPelicula.mostrarListaPeliculas(pd.obtenerPeliculas());
	}
	
	public void obtenerPeliculasFilPorCategoria() {
		logger.debug("Ejecutando metodo listar peliculas filtradas por categoria");
		
		try {
			VistaCategoria.mostrarListaCategorias(cd.listarCategoria());
			VistaPelicula.mostrarListaPeliculas(pd.obtenerPeliculasPorCategoria(Datos.recogeInt("Elija una categoria")));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error("Excepcion servicios.obtenerPeliculasPorCategoria. " + e.getMessage());
		}
		
		
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
	 * Metodo para dar de baja una pelicula solicitando un id por consola.
	 * 
	 * @param none
	 * @return void
	 */
	public void bajaPelicula() {

		logger.debug("Ejecutando metodo bajaPelicula() en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id de la Pelicula a eliminar");
			if (pd.obtenerPelicula(id) == null) {
				logger.error("La pelicula que intenta eliminar no existe");
			} else {
				if (pd.bajaPelicula(id)) {
					logger.debug("Pelicula eliminada correctamente");

				} else {
					logger.error("Hubo un problema al intentar eliminar la pelicula. La pelicula no ha sido eliminada");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Excepcion servicios.bajaCategoria. " + e.getMessage());
		}
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
		logger.debug("Ejecutando metodo altaUsuarios() en la clase Servicios");
		Usuario usu = new Usuario();
		usu.crearUsuario();
		ud.altaUsuario(usu);
	}

	/**
	 * Da de alta una categoria
	 * 
	 * @param none
	 * @return void
	 */
	public void altaCategoria() {
		logger.debug("Ejecutando metodo altaCategoria() en la clase Servicios");
		Categoria c = new Categoria();
		c.crearCategoria();
		cd.altaCategoria(c);
	}

	/**
	 * Método para modificar el usuario solicitando un id por consola.
	 * 
	 * @param none
	 * @return void
	 */
	public void modificarUsuario() {
		logger.debug("Ejecutando metodo modificarUsuario en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id del usuario a modificar");
			if (ud.obtenerUsuario(id) == null) {
				logger.error("El usuario que intenta eliminar no existe");
			} else {
				Usuario u =  new Usuario();
				u.crearUsuario();
				if (ud.modificarUsuario(u, id)) {
					logger.debug("El usuario ha sido modificado correctamente");
				} else {
					logger.error(
							"Hubo un problema al intentar modificar el usuario. El usuario no ha sido modificado.");
				}
			}
		} catch (Exception e) {
			logger.error("Excepcion servicios.modificarUsuario. " + e.getMessage());
		}
	}
	/**
	 * Método para modificar la categoria solicitando un id por consola.
	 * 
	 * @param none
	 * @return void
	 */
	public void modificarCategoria() {
		logger.debug("Ejecutando metodo modificarCategoria en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id de la Categoria a modificar");
			if (cd.obtenerCategoria(id) == null) {
				logger.error("La categoria que intenta modificar no existe");
			} else {
				Categoria ca =  new Categoria();
				ca.crearCategoria();
				if (cd.modificarCategoria(ca, id))  {
					logger.debug("La categoria ha sido modificado correctamente");
				} else {
					logger.error(
							"Hubo un problema al intentar modificar la categoria. La categoria no ha sido modificada.");
				}
			}
		} catch (Exception e) {
			logger.error("Excepcion servicios.modificarCategoria. " + e.getMessage());
		}

	}
	/**
	 * Método para modificar la Pelicula solicitando un id por consola.
	 * 
	 * @param none
	 * @return void
	 */
	public void modificarPelicula() {
		logger.debug("Ejecutando metodo modificarPelicula en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id de la Pelicula a modificar");
			if (pd.obtenerPelicula(id) == null) {
				logger.error("La Pelicula que intenta modificar no existe");
			} else {
				Pelicula pe =  new Pelicula();
				pe.crearPelicula();
				if (pd.modificarPelicula(pe, id))  {
					logger.debug("La Pelicula ha sido modificada correctamente");
				} else {
					logger.error(
							"Hubo un problema al intentar modificar la Pelicula. La categoria no ha sido modificada.");
				}
			}
		} catch (Exception e) {
			logger.error("Excepcion servicios.modificarCategoria. " + e.getMessage());
		}
		
	}
	
	
	/**
	 * Metodo para dar de baja a una categoria solicitando un id por consola.
	 * 
	 * @param none
	 * @return void
	 */
	public void bajaCategoria() {
		logger.debug("Ejecutando metodo bajaCategoria() en la clase Servicios");
		int id;
		try {

			id = Datos.recogeInt("Introduzca el id de la Categoria a eliminar");
			if (cd.obtenerCategoria(id) == null) {
				logger.error("La categoria que intenta eliminar no existe");
			} else {
				if (cd.bajaCategoria(id)) {
					logger.debug("Categoria eliminada correctamente");

				} else {
					logger.error(
							"Hubo un problema al intentar eliminar la categoria. La categoria no ha sido eliminada");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Excepcion servicios.bajaCategoria. " + e.getMessage());
		}

	}
	/**
	 * Metodo para dar de baja a un usuario solicitando un id por consola.
	 * 
	 * @param none
	 * @return void
	 */
	public void bajaUsuario() {
		logger.debug("Ejecutando metodo bajaUsuario() en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id del Usuario a eliminar");
			if (ud.obtenerUsuario(id) == null) {
				logger.error("El usuario que intenta eliminar no existe");
			} else {
				if (ud.bajaUsuario(id)) {
					logger.debug("Usuario eliminado correctamente");

				} else {
					logger.error("Hubo un problema al intentar eliminar el usuario. El usuario no fue eliminado");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Excepcion servicios.bajaCategoria. " + e.getMessage());
		}

	}

}
