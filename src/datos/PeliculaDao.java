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
<<<<<<< HEAD
		String sql = "INSERT INTO Peliculas (Nombre ,Ano_Estreno ,id_categorias, id_paquetes) values ('"+pelicula.getNombre()+"',"pelicula.getAno_estreno());
		System.out.println(sql);
		
		String sql = "INSERT INTO cliente values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getA�o_estreno()
=======



<<<<<<< HEAD
		String sql = "INSERT INTO cliente values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAnho_estreno()
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7
=======
		String sql = "INSERT INTO Peliculas values (NULL,'" + pelicula.getNombre() + "','" + pelicula.getAnho_estreno()
>>>>>>> 931f3085fd7692c79f70b056c206f3b9795e3152
				+ "','" + pelicula.getCategoria() + "')";

		try {

			st = con.getConnection().createStatement();
<<<<<<< HEAD
			st.executeUpdate(sql);

<<<<<<< HEAD
			ps.setString(2, "Torrente 7");
			ps.setString(3, "2020");
			ps.setInt(4, 1);
=======
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7


<<<<<<< HEAD
		} catch() {

			while (rs.next()) {
//Aqui de momento nose
			}
=======

		

			while (rs.next()) {
//Aqui de momento nose
			
		}
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7

=======
			int i = st.executeUpdate(sql);
			
			System.out.println(i);
			
		
>>>>>>> 931f3085fd7692c79f70b056c206f3b9795e3152
		} catch (SQLException ex) {


<<<<<<< HEAD
=======

		}
>>>>>>> 04e4098bf2779700c9a74fd94d5b3b77bd3882e7
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
				peliculas.add(new Pelicula(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
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
