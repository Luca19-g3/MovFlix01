package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Pelicula;
import utilidades.Conexion;

public class PeliculaDao {

	static Statement st = null;
	static ResultSet rs = null;
	static Conexion con = new Conexion();

	public static void altaPelicula(Pelicula p) {

		try {

			st = con.getConnection().createStatement();
			rs = st.executeQuery("aqui query");

			while (rs.next()) {
//Aqui de momento nose
			}
		} catch (SQLException ex) {

		}
	}

	/*public static void listarPelicula() {
	
		try {
		st = con.getConnection().createStatement();
		rs = st.executeQuery("select * from Peliculas");
		
		while (rs.next()) {
			System.out.print(rs.getString(1) + "-");
			System.out.print(rs.getString(2) + "-");
			System.out.println(rs.getString(3));
			
		}
		}catch (SQLException ex) {
			
		}
	}*/
	
	

}
