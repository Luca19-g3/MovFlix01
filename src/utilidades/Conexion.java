package utilidades;

import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MovieFlix;

public class Conexion {

	// Logger
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MovieFlix.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}
	
	Connection connection = null;
	String url = "jdbc:mysql://luca19-3g.czwqwdxylfvc.eu-west-1.rds.amazonaws.com/movieflix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user = "root";
	String password = "rootroot";

	public Conexion() {
		try {

			connection = DriverManager.getConnection(url, user, password);


		} catch (SQLException E) {
			logger.error("Excepcion SQL: " + E.getMessage());
			logger.error("Estado SQL: " + E.getSQLState());
			logger.error("Codigo del Error: " + E.getErrorCode());
			

		} catch (Exception E) {
			logger.error("Otro problema: " + E);

		}
	}
/*
 * Este metodo recupera la conexion con la base de datos
 * @param
 * @return none
 */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
