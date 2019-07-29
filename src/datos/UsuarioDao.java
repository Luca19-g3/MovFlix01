package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;
import utilidades.Conexion;
import modelo.Usuario;

public class UsuarioDao {

	static Statement st = null;
	static ResultSet rs = null;
	static Conexion con = new Conexion();

	/**
	 * añade un usuario en la base de datos
	 * 
	 * @param u
	 */
	public static void altaUsuario(Usuario u) {
		 String sql = "INSERT INTO Usuarios (Nombre,Fecha_nacimiento,CiudadResidencia) values('" + u.getNombre_completo() + "','" + u.getFecha_nacimiento()
		 + "','" + u.getCiudad_residencia() + "')";

		
		
		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("añadido correctamente");
			//st.execute(sql);

		
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

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas");

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

			return usuarios;

		} catch (SQLException ex) {
			System.out.println("Error!" + ex.getMessage());
			return null;
		}
	}


}
