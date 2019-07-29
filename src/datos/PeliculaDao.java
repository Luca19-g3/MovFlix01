package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;
import utilidades.Conexion;

public class PeliculaDao {

	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Conexion con = new Conexion();

	public static void altaPelicula(Pelicula pelicula) {



		String sql = "INSERT INTO Peliculas values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAnho_estreno()
				+ "','" + pelicula.getCategoria() + "')";

		try {

			st = con.getConnection().createStatement();
			int i = st.executeUpdate(sql);
			
			System.out.println(i);
			
		
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
	 

	public static void modificarPelicula(Pelicula p) {

		try {
			String sql = "UPDATE Peliculas SET Nombre= '"+p.getNombre()+"', Ano_estreno= '"+p.getAnho_estreno()+"' WHERE idPeliculas="+p.getId_pelicula();
			ps = con.getConnection().prepareStatement(sql) ;
	st = con.getConnection().createStatement();
			rs = st.executeQuery("");

			while (rs.next()) {

			}
		} catch (SQLException ex) {

		}
	}

}
