package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Conexion;

public class UsuarioDao {
	
	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Conexion con = new Conexion();
	

	  /**
	 * Metodo que obtiene todas los usuarios guardadas en la base de datos.
	 * 
	 * @param none
	 * @return List<Usuario> | null
	 * */

	public static List<Usuario> listarUsuario() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Usuarios");

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
			return usuarios;
			
		} catch (SQLException ex) {
			System.out.println("Error!" + ex.getMessage());
			return null;
		}
	}

}
