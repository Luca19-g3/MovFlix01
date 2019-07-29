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

public class PeliculaDao implements IPeliculasDao {

	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Conexion con = new Conexion();

	/*
	 * Metodo para dar altas peliculas
	 * @author Jorge
	 * @param  Pelicula
	 * @return void
	 */
	public  void altaPelicula(Pelicula p) {
	
		 String sql = "INSERT INTO Peliculas (Nombre,Ano_estreno,id_Categorias) values('" + p.getNombre() + "','" + p.getAnho_estreno()
		 + "','" + p.getCategoria() + "')";
		 System.out.println(sql);
		
		
		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("añadido correctamente");
			//st.execute(sql);

		
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * MÃ©todo que obtiene todas las pelÃ­culas guardadas en la base de datos.
	 * 
	 * @param none
	 * @return List<Pelicula> | null
	 */

	public List<Pelicula> listarPelicula() {

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
	/*
	 * Metodo para modificar las peliculas
	 * @author Jorge
	 * @param  none
	 * @return void
	 */
	public void modificarPelicula(Pelicula p, int id) {

		try {
			String sql = "UPDATE Peliculas SET Nombre= '" + p.getNombre() + "', Ano_estreno= '" + p.getAnho_estreno()
					+ "' WHERE idPeliculas=" + id;
			
			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			System.out.println("añadido correctamente");
		

			System.out.println(sql);


			
		} catch (SQLException ex) {

		}
		

	}
	public void bajaPelicula(int id){
	
		
					
			
			try {
				st = con.getConnection().createStatement();
				int i = st.executeUpdate("DELETE FROM Peliculas WHERE idPeliculas ="+id);
				System.out.println(i);
				
				
			} catch (SQLException e) {
				System.out.println("Error");
				e.printStackTrace();
			}		
			
		
		
			
	}

}
