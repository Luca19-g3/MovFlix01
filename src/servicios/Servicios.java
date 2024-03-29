/**
 * Clase Servicios
 * Clase que gestiona las relaciones entre las peticiones del usuario y los resultados
 *@author grupo3
 *@version 1.0
 * fecha 31/07/2019
 * 
 */
package servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import control.MovieFlix;
import datos.CategoriaDao;
import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Categoria;
import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Datos;
import vistas.VistaCategoria;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

public class Servicios {
	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona");
		}
	}

	private PeliculaDao pd = new PeliculaDao();
	private UsuarioDao ud = new UsuarioDao();
	private CategoriaDao cd = new CategoriaDao();

	public Servicios() {

	}

	/**
	 * Metodo que ejecuta al metodo altaPelicula(Pelicula p)
	 * 
	 * @param none
	 * @return void
	 */

	public void altaPelicula() {
		logger.debug("Ejecutando metodo altaPelicula en la clase Servicios");
		VistaCategoria.mostrarListaCategorias(cd.listarCategoria());
		Pelicula p = new Pelicula();
		p.crearPelicula();
		pd.altaPelicula(p);
	}

	/**
	 * Metodo que ejecuta al metodo modificarPelicula(Pelicula p, int id),
	 * comprobando si existe la pelicula, pidiendo el id
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
				VistaCategoria.mostrarListaCategorias(cd.listarCategoria());
				Pelicula pe = new Pelicula();
				pe.crearPelicula();
				if (pd.modificarPelicula(pe, id)) {
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
	 * Metodo que ejecuta al metodo bajaPelicula(int id) comprobando si existe la
	 * pelicula, pidiendo el id
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
	 * Metodo que ejecuta al metodo obtenerPeliculas() y lo imprime con el metodo
	 * mostrarListaPeliculas de la clase VistaPelicula
	 * 
	 * @param none
	 * @return void
	 */
	public void listarPeliculas() {
		logger.debug("Ejecutando metodo listarPeliculas en la clase Servicios");
		VistaPelicula.mostrarListaPeliculas(pd.obtenerPeliculas(), "Listado de las peliculas");
	}

	/**
	 * Metodo que ejecuta al metodo listarCategorias() y lo imprime con el metodo
	 * mostrarListaCategorias de la clase VistaCategoria
	 * 
	 * @param none
	 * @return void
	 */
	public void listarCategorias() {
		logger.debug("Ejecutando metodo listarCategorias en la clase Servicios");
		VistaCategoria.mostrarListaCategorias(cd.listarCategoria());
	}

	/**
	 * Metodo que ejecuta al metodo altaUsuario(Usuario u)
	 * 
	 * @param none
	 * @return void
	 */
	public void altaUsuarios() {
		logger.debug("Ejecutando metodo altaUsuarios() en la clase Servicios");
		Usuario usu = new Usuario();
		usu.crearUsuario();
		ud.altaUsuario(usu);
	}

	/**
	 * Metodo que ejecuta al metodo modificarUsuario(Usuario u, int id), comprobando
	 * si existe el usuario, pidiendo el id
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
				Usuario u = new Usuario();
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
	 * Metodo que ejecuta al metodo bajaUsuario(int id), comprobando si existe el
	 * usuario, pidiendo el id
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

	/**
	 * Metodo que ejecuta al metodo listarUsuario() y lo imprime con el metodo
	 * mostrarListaUsuarios de la clase VistaUsuario
	 * 
	 * @param none
	 * @return void
	 */
	public void listarUsuarios() {
		logger.debug("Ejecutando metodo listarUsuarios en la clase Servicios");
		VistaUsuario.mostrarListaUsuarios(ud.listarUsuario());
	}

	/**
	 * Metodo que ejecuta al metodo altaCategoria(Categoria c)
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
	 * Metodo que ejecuta al metodo modificarCategoria(Categoria c, int id),
	 * comprobando si existe la categoria, pidiendo el id
	 * 
	 * @param none
	 * @return void
	 */
	public void modificarCategoria() {
		logger.debug("Ejecutando metodo modificarCategoria en la clase Servicios");
		int id;
		try {
			VistaCategoria.mostrarListaCategorias(cd.listarCategoria());
			id = Datos.recogeInt("Introduzca el id de la Categoria a modificar");
			if (cd.obtenerCategoria(id) == null) {
				logger.error("La categoria que intenta modificar no existe");
			} else {
				Categoria ca = new Categoria();
				ca.crearCategoria();
				if (cd.modificarCategoria(ca, id)) {
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
	 * Metodo que ejecuta al metodo bajaCategoria(Categoria c, int id), comprobando
	 * si existe la categoria, pidiendo el id
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
	 * Metodo que ejecuta obtenerPeliculasMasValoradas de la clase PeliculaDao
	 * solicitando el numero de resultado e imprimiendolos con el metodo
	 * mostrarPeliculasMasValoradas
	 * 
	 * @param none
	 * @return void
	 */
	public void listarPeliculasMasValoradas() {
		logger.debug("Ejecutando metodo listarPeliculasMasValoradas en la clase Servicios");
		int limite;
		try {
			limite = Datos.recogeInt("Introduce el limite de peliculas que quieres listar");
			VistaPelicula.mostrarPeliculasMasValoradas(pd.obtenerPeliculasMasValoradas(limite));
		} catch (Exception e) {
			logger.error("Este limite no es correcto");
		}

	}

	/**
	 * Metodo que ejecuta obtenerPeliculasMasVistas de la clase PeliculaDao
	 * solicitando el numero de resultado e imprimiendolos con el metodo
	 * mostrarPeliculasMasVistas
	 * 
	 * @param none
	 * @return void
	 */
	public void listarPeliculasMasVistas() {
		logger.debug("Ejecutando metodo listarPeliculasMasVistas en la clase Servicios");
		int limite;
		try {
			limite = Datos.recogeInt("Introduce el limite de peliculas que quieres listar");
			VistaPelicula.mostrarPeliculasMasVistas(pd.obtenerPeliculasMasVistas(limite));
		} catch (Exception e) {
			logger.error("Este limite no es correcto");
		}

	}

	/**
	 * Metodo que ejecuta obtenerPeliculasVistas de la clase PeliculaDao solicitando
	 * el id del usuario e imprimiendolos con el metodo mostrarListaPeliculas
	 * 
	 * @param none
	 * @return void
	 */
	public void listarPeliculasVistas() {
		logger.debug("Ejecutando metodo listarPeliculasVistas en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id del Usuario a consultar");
			if (ud.obtenerUsuario(id) == null) {
				logger.error("El usuario introducido no existe");
			} else {
				VistaPelicula.mostrarListaPeliculas(ud.obtenerPeliculasVistas(id),
						"Listado de peliculas vistas por un cliente");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Excepcion servicios.listarPeliculasVistas. " + e.getMessage());
		}
	}

	/**
	 * Metodo que ejecuta obtenerPeliculasNoVistas de la clase PeliculaDao
	 * solicitando el id del usuario e imprimiendolos con el metodo
	 * mostrarListaPeliculas
	 * 
	 * @param none
	 * @return void
	 */
	public void listarPeliculasNoVistas() {
		logger.debug("Ejecutando metodo listarPeliculasNoVistas en la clase Servicios");
		int id;
		try {
			id = Datos.recogeInt("Introduzca el id del Usuario a consultar");
			if (ud.obtenerUsuario(id) == null) {
				logger.error("El usuario introducido no existe");
			} else {
				VistaPelicula.mostrarListaPeliculas(ud.obtenerPeliculasNoVistas(id),
						"Listado de peliculas no vistas por un cliente");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Excepcion servicios.listarPeliculasNoVistas. " + e.getMessage());
		}
	}

	/**
	 * Metodo que ejecuta obtenerPeliculasFilPorCategoria de la clase PeliculaDao
	 * solicitando el id de la categoria e imprimiendolos con el metodo
	 * mostrarListaPeliculas
	 * 
	 * @param none
	 * @return void
	 */
	public void obtenerPeliculasFilPorCategoria() {
		logger.debug("Ejecutando metodo listar peliculas filtradas por categoria");

		try {
			VistaCategoria.mostrarListaCategorias(cd.listarCategoria());
			VistaPelicula.mostrarListaPeliculas(pd.obtenerPeliculasPorCategoria(Datos.recogeInt("Elija una categoria")),
					"Peliculas filtradas por la categoria");

		} catch (Exception e) {

			e.printStackTrace();
			logger.error("Excepcion servicios.obtenerPeliculasPorCategoria. " + e.getMessage());
		}

	}

}
