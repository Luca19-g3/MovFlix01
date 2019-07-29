package utilidades;

import java.sql.*;


public class Conexion {
/**
 * 
 */
	Connection connection = null;
	String url = "jdbc:mysql://luca19-3g.czwqwdxylfvc.eu-west-1.rds.amazonaws.com/movieflix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user = "root";
	String password = "rootroot";

	public Conexion() {
		try {

			connection = DriverManager.getConnection(url, user, password);


		} catch (SQLException E) {
			System.out.println("Excepcion SQL: " + E.getMessage());
			System.out.println("Estado SQL: " + E.getSQLState());
			System.out.println("Codigo del Error: " + E.getErrorCode());
		} catch (Exception E) {
			System.out.println("Otro problema: " + E);
		}
	}

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
