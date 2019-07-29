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
<<<<<<< HEAD
		String sql = "INSERT INTO Peliculas (Nombre ,Ano_Estreno ,id_categorias, id_paquetes) values ('"+pelicula.getNombre()+"',"pelicula.getAno_estreno());
		System.out.println(sql);
=======
		
		String sql = "INSERT INTO cliente values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAño_estreno()
				+ "','" + pelicula.getCategoria() + "')";
>>>>>>> 4c68cd8d7b597425804f719852428c4d571ea738

		try {

			st = con.getConnection().createStatement();
			st.executeUpdate(sql);

<<<<<<< HEAD
			ps.setString(2, "Torrente 7");
			ps.setString(3, "2020");
			ps.setInt(4, 1);

			ps.executeUpdate();

		} catch (
=======
<<<<<<< HEAD
		
=======
			while (rs.next()) {
//Aqui de momento nose
			}
>>>>>>> 3260995b15e12e951704b1bc481cf47ae3a6a1c4
		} catch (SQLException ex) {
>>>>>>> 4c68cd8d7b597425804f719852428c4d571ea738

		SQLException ex) {
			System.out.println(ex);
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
