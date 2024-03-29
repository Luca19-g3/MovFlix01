/**
 * Clase PeliculaDAo
 * Clase que contiene los metodos para las peliculas, que interaccionan con la base de datos
 *@author grupo3
 *@version 1.0
 * fecha 31/07/2019
 * 
 */
package datos;

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
import utilidades.Conexion;

public class PeliculaDao implements IPeliculasDao {
	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona");
		}
	}

	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;

	/**
	 * Metodo para dar de alta a nuevas Peliculas
	 * 
	 * @param Pelicula
	 * @return void
	 */
	public void altaPelicula(Pelicula p) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo altaPelicula() en la clase PeliculaDao");
		String sql = "INSERT INTO Peliculas (Nombre,Ano_estreno,id_Categorias) values('" + p.getNombre() + "','"
				+ p.getAnho_estreno() + "','" + p.getCategoria() + "')";
		System.out.println(sql);
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Anadido correctamente");
			con.desconectar();
		} catch (SQLException ex) {
			logger.error("Error" + ex);
		}
	}

	/**
	 * Metodo que obtiene todas las peliculas
	 * 
	 * @param none
	 * @return List<Pelicula> | null
	 */

	public List<Pelicula> obtenerPeliculas() {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerPeliculas() en la clase PeliculaDao");
		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas");

			while (rs.next()) {
				peliculas.add(new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			con.desconectar();
			return peliculas;

		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());

			return null;
		}
	}

	/**
	 * Metodo para modificar las peliculas
	 * 
	 * @param Pelicula , int id
	 * @return boolean
	 */
	public boolean modificarPelicula(Pelicula p, int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo modificarPelicula() en la clase PeliculaDao");
		try {
			String sql = "UPDATE Peliculas SET Nombre= '" + p.getNombre() + "', Ano_estreno= '" + p.getAnho_estreno()
					+ "' WHERE idPeliculas=" + id;

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Modificado correctamente");
			con.desconectar();
			return true;

		} catch (SQLException ex) {
			logger.error("Error" + ex);
			return false;
		}

	}

	/**
	 * Metoda para dar de baja a la pelicula con el id correspondiente
	 * 
	 * @param int id
	 * @return boolean
	 */
	public boolean bajaPelicula(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo bajaPelicula() en la clase PeliculaDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Peliculas WHERE idPeliculas =" + id);
			System.out.println(i);
			con.desconectar();
			return true;
		} catch (SQLException e) {
			logger.error("Error");
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Metodo para obtener una pelicula dado un determinado id
	 * 
	 * @param int id
	 * @return Pelicula | null
	 */
	@Override
	public Pelicula obtenerPelicula(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerPelicula(id) en la clase PeliculaDao");
		Pelicula p = new Pelicula();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas WHERE idPeliculas = " + id);

			while (rs.next()) {
				return new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
			con.desconectar();
			return null;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Metodo para obtener una pelicula filtradas por categoria dado un determinado
	 * id
	 * 
	 * @param int id
	 * @return List<Pelicula> | null
	 */

	@Override
	public List<Pelicula> obtenerPeliculasPorCategoria(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerPeliculasPorCategoria() en la clase PeliculaDao");
		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Peliculas WHERE id_Categorias = " + id);

			while (rs.next()) {

				peliculas.add(new Pelicula(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			con.desconectar();
			return peliculas;

		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());

			return null;
		}

	}

	/**
	 * Metodo que obtiene las peliculas mas vistas.
	 * 
	 * @param int limite
	 * @return List<String> | null
	 */

	public List<String> obtenerPeliculasMasVistas(int limite) {
		Conexion con = new Conexion();

		logger.debug("Ejecutando metodo obtenerPeliculasMasVistas() en la clase PeliculaDao");
		List<String> peliculas = new ArrayList<String>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("	SELECT Nombre, COUNT(*) AS Veces" + " FROM Peliculas P , PeliculasVistas V"
					+ " where P.idPeliculas=V.id_Peliculas" + " group by id_Peliculas" + " ORDER BY Veces DESC"
					+ " LIMIT " + limite);

			while (rs.next()) {

				peliculas.add(rs.getString(1) + " | Visualizaciones: " + String.valueOf(rs.getString(2)));

			}
			con.desconectar();
			return peliculas;

		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());

			return null;
		}

	}

	/**
	 * Metodo que obtiene las peliculas mas valoradas.
	 * 
	 * @param int limite
	 * @return List<String> | null
	 */

	public List<String> obtenerPeliculasMasValoradas(int limite) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerPeliculasMasVistas() en la clase PeliculaDao");
		List<String> peliculas = new ArrayList<String>();

		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT Nombre, TRUNCATE(AVG(Valoraciones),0) AS Valoracion\r\n"
					+ "FROM Peliculas P , PeliculasVistas V\r\n" + "where P.idPeliculas=V.id_Peliculas\r\n"
					+ "group by id_Peliculas\r\n" + "ORDER BY Valoracion DESC LIMIT " + limite + ";");

			while (rs.next()) {

				peliculas.add(rs.getString(1) + " | Valoracion: " + String.valueOf((rs.getString(2))));
			}
			con.desconectar();
			return peliculas;

		} catch (SQLException ex) {

			logger.error("Error " + ex.getMessage());

			return null;
		}
	}

}
