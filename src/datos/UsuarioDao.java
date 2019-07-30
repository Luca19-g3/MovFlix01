package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import modelo.Pelicula;
import utilidades.Conexion;
import modelo.Usuario;

public class UsuarioDao implements IUsuarioDao {

	static Statement st = null;
	static ResultSet rs = null;
	static Conexion con = new Conexion();

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
		logger.debug("Ejecutando metodo altaUsuario() en la clase UsuarioDao");
		String sql = "INSERT INTO Usuarios (Nombre,Fecha_nacimiento,CiudadResidencia) values('" + u.getNombre_completo()
				+ "','" + u.getFecha_nacimiento() + "','" + u.getCiudad_residencia() + "')";

		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Añadido correctamente");

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
		logger.debug("Ejecutando metodo listarUsuario() en la clase UsuarioDao");
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Usuarios");

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

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

	public void bajaUsuario(int id) {

		logger.debug("Ejecutando metodo bajaUsuario() en la clase UsuarioDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Usuarios WHERE idUsuarios =" + id);

			logger.info("Eliminado correctamente");

		} catch (SQLException e) {
			logger.error("Error");
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que modifica usuarios en la base de datos dado su id.
	 * 
	 * @param int id del usuario
	 * @return void
	 */
	public void modificarUsuario(Usuario us, int id) {
		logger.debug("Ejecutando metodo modificarUsuario() en la clase UsuarioDao");
		try {
			String sql = "UPDATE Usuarios SET Nombre= '" + us.getNombre_completo() + "',Fecha_nacimiento= '"
					+ us.getFecha_nacimiento() + "', CiudadResidencia='"+us.getCiudad_residencia()+"' WHERE idUsuarios=" + id;

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Modificado correctamente");

		} catch (SQLException ex) {
			logger.error("Error" + ex);
		}
	}


}
