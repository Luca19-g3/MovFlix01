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
		String sql = "INSERT INTO Peliculas (Nombre ,Ano_Estreno ,id_categorias, id_paquetes) values ('"+pelicula.getNombre()+"',"pelicula.getAno_estreno());
		System.out.println(sql);
		
		String sql = "INSERT INTO cliente values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAño_estreno()
				+ "','" + pelicula.getCategoria() + "')";


		try {

			st = con.getConnection().createStatement();
			st.executeUpdate(sql);

			ps.setString(2, "Torrente 7");
			ps.setString(3, "2020");
			ps.setInt(4, 1);

			ps.executeUpdate();

		} catch() {

			while (rs.next()) {
//Aqui de momento nose
			}

		} catch (SQLException ex) {


	}
	}


	/*
	 * public static void listarPelicula() {
	 * 
	 * try { st = con.getConnection().createStatement(); rs =
	 * st.executeQuery("select * from Peliculas");
	 * 
	 * while (rs.next()) { System.out.print(rs.getString(1) + "-");
	 * System.out.print(rs.getString(2) + "-"); System.out.println(rs.getString(3));
	 * 
	 * } }catch (SQLException ex) {
	 * 
	 * } }
	 */

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
