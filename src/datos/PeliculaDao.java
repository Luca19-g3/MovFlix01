package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Pelicula;
import utilidades.Conexion;

public class PeliculaDao {

	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Conexion con = new Conexion();

	public static void altaPelicula(Pelicula pelicula) {



		String sql = "INSERT INTO cliente values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAnho_estreno()
				+ "','" + pelicula.getCategoria() + "')";


		try {

			st = con.getConnection().createStatement();
			st.executeUpdate(sql);




		

			while (rs.next()) {
//Aqui de momento nose
			
		}

		} catch (SQLException ex) {



		}
	}


	
	  /**
	 * Método que obtiene todas las películas guardadas en la base de datos.
	 * 
	 * @param none
	 * @return List<Pelicula> | null
	 * */

	public static List<Pelicula> listarPelicula() {
		
		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas");

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			
			return peliculas;
			
		} catch (SQLException ex) {
			System.out.println("Error!" + ex.getMessage());
			return null;
		}
	}
	 

	public static void modificarPelicula() {

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("");

			while (rs.next()) {
				System.out.println("Hola");

			}
		} catch (SQLException ex) {

		}
	}

}
