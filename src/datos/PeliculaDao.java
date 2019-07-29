package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Pelicula;
import utilidades.Conexion;

public class PeliculaDao {

	static Statement st = null;
	static ResultSet rs = null;
	static Conexion con = new Conexion();

	public static void altaPelicula(Pelicula pelicula) {
		String sql = "INSERT INTO cliente values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAño_estreno()
				+ "','" + pelicula.getCategoria() + "')";

		try {

			st = con.getConnection().createStatement();
			st.execute(sql);

			while (rs.next()) {
				System.out.println("");
			}
		} catch (SQLException ex) {

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
