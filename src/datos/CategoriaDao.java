package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;
import modelo.Categoria;
import utilidades.Conexion;

public class CategoriaDao implements ICategoriaDao {

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
	
	/**
	 * Da de alta a nuevas categorias
	 * 
	 * @param Categoria
	 */

	@Override
	public void altaCategoria(Categoria c) {
		logger.debug("Ejecutando metodo altaCategoria() en la clase CategoriaDao");
		String sql = "INSERT INTO Categorias (Nombre) values('" + c.getNombre() + "')";

		try {

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Añadido correctamente");

		} catch (SQLException ex) {
			logger.error("Error" + ex);
		}

	}

	/**
	 * Metodo para modificar las categorias
	 * 
	 * @param Pelicula , id
	 * @return void
	 */
	@Override
	public void modificarCategoria(Categoria c, int id) {

		logger.debug("Ejecutando metodo modificarCategoria() en la clase CategoriaDao");
		try {
			String sql = "UPDATE Categorias SET Nombre= '" + c.getNombre() + "' WHERE idCategorias=" + id;

			st = con.getConnection().createStatement();

			int i = st.executeUpdate(sql);
			logger.info(sql);
			logger.info("Modificado correctamente");

		} catch (SQLException ex) {
			logger.error("Error" + ex);
		}
	}

	/**
	 * baja la categoria con la id correspondiente
	 * 
	 * @param id
	 * @return boolean
	 */
	@Override
	public boolean bajaCategoria(int id) {
		logger.debug("Ejecutando metodo bajaCategoria() en la clase CategoriaDao");
		try {
			st = con.getConnection().createStatement();
			int i = st.executeUpdate("DELETE FROM Categorias WHERE idCategorias =" + id);
			System.out.println(i);

			return true;
		} catch (SQLException e) {
			logger.error("No Permit");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Categoria> listarCategoria() {

		return null;
	}

	@Override
	public List<Categoria> listarCategoria(String criterio) {

		return null;
	}

	@Override
	public List<Categoria> listarCategoria(String criterio, int nresultados) {

		return null;
	}

	@Override
	public void noVistas() {

	}

}
