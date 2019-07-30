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

public class UsuarioDao {

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
	 * @param u
	 */
	public static void altaUsuario(Usuario u) {
		logger.trace("Ejecutando metodo altaUsuario() en la clase UsuarioDao");
		String sql = "INSERT INTO Usuarios (Nombre,Fecha_nacimiento,CiudadResidencia) values('" + u.getNombre_completo()
				+ "','" + u.getFecha_nacimiento() + "','" + u.getCiudad_residencia() + "')";

		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("añadido correctamente");
			// st.execute(sql);

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Metodo que obtiene todas laos usuarios cargados en la base de datos.
	 * 
	 * @param none
	 * @return List<Usuario> | null
	 */

	public static List<Usuario> listarUsuario() {
		logger.trace("Ejecutando metodo listarUsuario() en la clase UsuarioDao");
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Usuarios");

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

			return usuarios;

		} catch (SQLException ex) {
			System.out.println("Error!" + ex.getMessage());
			return null;
		}
	}
	/**
	 * Metodo que elimina usuarios en la base de datos dado su id.
	 * 
	 * @param int id del usuario
	 * @return boolean 
	 */
	
	public void bajaUsuario (int id) {
				
		logger.trace("Ejecutando metodo bajaUsuario() en la clase UsuarioDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Usuarios WHERE idUsuarios ="+id);
			System.out.println(i);
			
			
		} catch (SQLException e) {
			System.out.println("Error");
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
		logger.trace("Ejecutando metodo modificarUsuario() en la clase UsuarioDao");
		try {
			String sql = "UPDATE Usuarios SET Nombre= '" + us.getNombre_completo() + "',Fecha de nacimiento= '" + us.getFecha_nacimiento()
					+ "' WHERE idUsuarios=" + id;
			
			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("añadido correctamente");
		

			System.out.println(sql);


			
		} catch (SQLException ex) {

		}
	}

}
