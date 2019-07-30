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
	 * a�ade un usuario en la base de datos
	 * 
	 * @param u
	 */
	public static void altaUsuario(Usuario u) {
		String sql = "INSERT INTO Usuarios (Nombre,Fecha_nacimiento,CiudadResidencia) values('" + u.getNombre_completo()
				+ "','" + u.getFecha_nacimiento() + "','" + u.getCiudad_residencia() + "')";

		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("a�adido correctamente");
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
	/**
	 * Metodo que elimina usuarios en la base de datos dado su id.
	 * 
	 * @param int id del usuario
	 * @return boolean 
	 */
	
	public boolean bajaUsuario (int id) {
	
		boolean eliminar=false;
				
		
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("DELETE FROM Usuarios WHERE ID="+id);
			
			eliminar=true;
			
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}		
		return eliminar;
	}
	
	/**
	 * Metodo que modifica usuarios en la base de datos dado su id.
	 * 
	 * @param int id del usuario
	 * @return void 
	 */
	public void modificarUsuario(Usuario us, int id) {

		try {
			String sql = "UPDATE Usuarios SET Nombre= '" + us.getNombre_completo() + "',Fecha de nacimiento= '" + us.getFecha_nacimiento()
					+ "' WHERE idUsuarios=" + id;
			
			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("a�adido correctamente");
		

			System.out.println(sql);


			
		} catch (SQLException ex) {

		}
	}

}
