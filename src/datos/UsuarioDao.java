package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
