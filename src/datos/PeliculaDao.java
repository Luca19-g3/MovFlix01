package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Conexion;

public class PeliculaDao implements IPeliculasDao {
	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Conexion con = new Conexion();

	/*
	 * Metodo para dar altas peliculas
	 *
	 * 
	 * @param Pelicula
	 * 
	 * @return void
	 */
	public void altaPelicula(Pelicula p) {
		logger.debug("Ejecutando metodo altaPelicula() en la clase PeliculaDao");
		String sql = "INSERT INTO Peliculas (Nombre,Ano_estreno,id_Categorias) values('" + p.getNombre() + "','"
				+ p.getAnho_estreno() + "','" + p.getCategoria() + "')";
		System.out.println(sql);
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Añadido correctamente");
			// st.execute(sql);
		} catch (SQLException ex) {
			logger.error("Error" +ex);
		}
	}

	/**
	 * Metodo que obtiene todas las peliculas guardadas en la base de datos.
	 * 
	 * @param none
	 * @return List<Pelicula> | null
	 */

	public List<Pelicula> obtenerPeliculas() {
		logger.debug("Ejecutando metodo obtenerPeliculas() en la clase PeliculaDao");
		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas");

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}

			return peliculas;

		} catch (SQLException ex) {
			logger.error("Error "+ ex.getMessage());

			return null;
		}
	}

	/**
	 * Metodo para modificar las peliculas
	 * 
	 * @param Pelicula , id
	 * @return void
	 */
	public boolean modificarPelicula(Pelicula p, int id) {
		logger.debug("Ejecutando metodo modificarPelicula() en la clase PeliculaDao");
		try {
			String sql = "UPDATE Peliculas SET Nombre= '" + p.getNombre() + "', Ano_estreno= '" + p.getAnho_estreno()
					+ "' WHERE idPeliculas=" + id;

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Modificado correctamente");
			return true;


		} catch (SQLException ex) {
			logger.error("Error" +ex);
			return false;
		}
		

	}

	/**
	 * baja a la pelicula con la id correspondiente
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean bajaPelicula(int id) {
		logger.debug("Ejecutando metodo bajaPelicula() en la clase PeliculaDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Peliculas WHERE idPeliculas =" + id);
			System.out.println(i);

			return true;
		} catch (SQLException e) {
			logger.error("Error");
			e.printStackTrace();
			return false;
		}

	}

	
	/**
	 * Obtiene una pelicula dado un determinado id
	 * 
	 * @param int id de la pelicula
	 * @return Pelicula | null
	 */
	@Override
	public Pelicula obtenerPelicula(int id) {
		logger.debug("Ejecutando metodo obtenerPelicula(id) en la clase PeliculaDao");
		Pelicula p = new Pelicula();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas WHERE idPeliculas = " + id);
						
			while (rs.next()) {
				return new Pelicula(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
			
			return null;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Pelicula> obtenerPeliculas(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> obtenerPeliculas(String filtro, int nresultados) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Metodo que obtiene las peliculas mas valoradas.
	 * 
	 * @param none
	 * @return List<Pelicula> | null
	 */

	public List<String> obtenerPeliculasMasValoradas() {
		logger.debug("Ejecutando metodo obtenerPeliculasMasValoradas() en la clase PeliculaDao");
		List<String> peliculas = new ArrayList<String>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("	SELECT Nombre, COUNT(*) AS Veces\r\n" + 
					"	FROM Peliculas P , PeliculasVistas V\r\n" + 
					"	where P.idPeliculas=V.id_Peliculas\r\n" + 
					"	group by id_Peliculas\r\n" + 
					"	ORDER BY Veces DESC;");

			while (rs.next()) {
				peliculas.add(rs.getString(1) + " Visualizaciones: " + String.valueOf(rs.getString(2)));
			}

			return peliculas;

		} catch (SQLException ex) {
			logger.error("Error "+ ex.getMessage());

			return null;
		}
	}



	

}
