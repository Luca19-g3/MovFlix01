package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import utilidades.Conexion;
import modelo.Pelicula;
import modelo.Usuario;

public class UsuarioDao implements IUsuarioDao {

	static Statement st = null;
	static ResultSet rs = null;


	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	/**
	 * añade un usuario en la base de datos
	 * 
	 * @param usuario
	 */
	public void altaUsuario(Usuario u) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo altaUsuario() en la clase UsuarioDao");
		String sql = "INSERT INTO Usuarios (Nombre,Fecha_nacimiento,CiudadResidencia) values('" + u.getNombre_completo()
				+ "','" + u.getFecha_nacimiento() + "','" + u.getCiudad_residencia() + "')";

		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Añadido correctamente");
			con.desconectar();
		} catch (SQLException ex) {
			logger.error("Error" + ex);
		}
	}

	/**
	 * Metodo que obtiene todas laos usuarios cargados en la base de datos.
	 * 
	 * @param none
	 * @return List<Usuario> | null
	 */

	public List<Usuario> listarUsuario() {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo listarUsuario() en la clase UsuarioDao");
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Usuarios");

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			con.desconectar();
			return usuarios;

		} catch (SQLException ex) {
			logger.error("Error" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Metodo que elimina usuarios en la base de datos dado su id.
	 * 
	 * @param int id del usuario
	 * @return boolean
	 */

	public boolean bajaUsuario(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo bajaUsuario() en la clase UsuarioDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Usuarios WHERE idUsuarios =" + id);

			logger.info("Eliminado correctamente");
			con.desconectar();
			return true;
		} catch (SQLException e) {
			logger.error("Error");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo que modifica usuarios en la base de datos dado su id.
	 * 
	 * @param int id del usuario
	 * @return void
	 */
	public boolean modificarUsuario(Usuario us, int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo modificarUsuario() en la clase UsuarioDao");
		try {
			String sql = "UPDATE Usuarios SET Nombre= '" + us.getNombre_completo() + "',Fecha_nacimiento= '"
					+ us.getFecha_nacimiento() + "', CiudadResidencia='" + us.getCiudad_residencia()
					+ "' WHERE idUsuarios=" + id;

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Modificado correctamente");
			con.desconectar();
			return true;
		} catch (SQLException ex) {
			logger.error("Error" + ex);
			return false;
		}
	}

	/**
	 * Obtiene una pelicula dado un determinado id
	 * 
	 * @param int id del usuario
	 * @return Pelicula | null
	 */
	@Override
	public Usuario obtenerUsuario(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerUsuario(id) en la clase UsuarioDao");
		Pelicula p = new Pelicula();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Usuarios WHERE idUsuarios = " + id);

			while (rs.next()) {
				return new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			con.desconectar();
			return null;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}
	/**
	 * Obtiene una lista de las peliculas vistas por el usuarrio dado su id
	 * 
	 * @param int id del usuario
	 * @return List<Pelicula> | null 
	 */
	public List<Pelicula> obtenerPeliculasVistas(int id){
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerPeliculasVistas(id) en la clase UsuarioDao");
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("Select * From Peliculas Where idPeliculas" + 
					" IN(select id_Peliculas FROM PeliculasVistas Where id_usuarios = " + id + ")");

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			con.desconectar();
			return peliculas;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Obtiene una una lista de peliculas vistas dado el id de un usuario
	 * 
	 * @param int id del usuario
	 * @return List<Pelicula> | null 
	 */
	public List<Pelicula> obtenerPeliculasNoVistas(int id){
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerPeliculasNoVistas(id) en la clase UsuarioDao");
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("Select * From Peliculas Where idPeliculas" + 
					" NOT IN(select id_Peliculas FROM PeliculasVistas Where id_usuarios = " + id + ")");

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			con.desconectar();
			return peliculas;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}

}
