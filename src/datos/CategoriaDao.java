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
import modelo.Categoria;
import modelo.Pelicula;
import utilidades.Conexion;

public class CategoriaDao implements ICategoriaDao {

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
	 * Metodo para dar de alta a nuevas categorias
	 * 
	 * @param Categoria
	 * @return void
	 */

	@Override
	public void altaCategoria(Categoria c) {
		logger.debug("Ejecutando metodo altaCategoria() en la clase CategoriaDao");
		String sql = "INSERT INTO Categorias (Nombre) values('" + c.getNombre() + "')";
		Conexion con = new Conexion();
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
	 * Metodo para modificar las categorias
	 * 
	 * @param Categoria , id
	 * @return boolean
	 */
	@Override
	public boolean modificarCategoria(Categoria c, int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo modificarCategoria() en la clase CategoriaDao");
		try {
			String sql = "UPDATE Categorias SET Nombre= '" + c.getNombre() + "' WHERE idCategorias=" + id;

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
	 * Metodo para dar de baja a la categoria con la id correspondiente
	 * 
	 * @param id
	 * @return boolean
	 */
	@Override
	public boolean bajaCategoria(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo bajaCategoria() en la clase CategoriaDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Categorias WHERE idCategorias =" + id);
			System.out.println(i);
			con.desconectar();
			return true;
		} catch (SQLException e) {
			logger.error("Error al intentar dar de baja a la categoria. " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Metodo para obtener la categoria con el id correspondiente
	 * 
	 * @param int id
	 * @return Categoria | null
	 */

	public Categoria obtenerCategoria(int id) {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo obtenerCategoria(id) en la clase CategoriaDao");
		Pelicula p = new Pelicula();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Categorias WHERE idCategorias = " + id);

			while (rs.next()) {
				return new Categoria(rs.getInt(1), rs.getString(2));
			}
			con.desconectar();
			return null;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Metodo para obtener un listado de las categorias con el id correspondiente
	 * 
	 * @param none
	 * @return List<Categoria> | null
	 */
	@Override
	public List<Categoria> listarCategoria() {
		Conexion con = new Conexion();
		logger.debug("Ejecutando metodo listar categorias en la clase CategoriaDao");
		List<Categoria> c = new ArrayList<Categoria>();
		try {
			st = con.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM Categorias");

			while (rs.next()) {
				c.add(new Categoria(rs.getInt(1), rs.getString(2)));
			}
			con.desconectar();
			return c;
		} catch (SQLException ex) {
			logger.error("Error " + ex.getMessage());
			return null;
		}
	}
}
