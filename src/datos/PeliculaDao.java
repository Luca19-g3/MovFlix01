package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Conexion;

public class PeliculaDao {

	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Conexion con = new Conexion();

	
	public static void altaPelicula(Pelicula p) {
	
		 String sql = "INSERT INTO Peliculas (Nombre,Ano_estreno,id_Categorias) values('" + p.getNombre() + "','" + p.getAnho_estreno()
		 + "','" + p.getCategoria() + "')";
		 System.out.println(sql);
		
		
		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("a�adido correctamente");
			//st.execute(sql);

		
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Método que obtiene todas las películas guardadas en la base de datos.
	 * 
	 * @param none
	 * @return List<Pelicula> | null
	 */

	public static List<Pelicula> listarPelicula() {

		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas");

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}

			return peliculas;

		} catch (SQLException ex) {
			System.out.println("Error!" + ex.getMessage());
			return null;
		}
	}

	public static void modificarPelicula(Pelicula p) {

		try {
			String sql = "UPDATE Peliculas SET Nombre= '" + p.getNombre() + "', Ano_estreno= '" + p.getAnho_estreno()
					+ "' WHERE idPeliculas=" + p.getId_pelicula();
			ps = con.getConnection().prepareStatement(sql);
			st = con.getConnection().createStatement();
			rs = st.executeQuery("");

			while (rs.next()) {

			}
		} catch (SQLException ex) {

		}
	}

}
