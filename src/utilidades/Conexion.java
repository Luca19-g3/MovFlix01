package utilidades;

import java.sql.*;

public class Conexion {
	String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	Connection connection = null;
	String BD = "empresa1";
	String driverClassName = "com.mysql.cj.jdbc.Driver";
	String driverUrl = "jdbc:mysql:///" + BD;
	String user = "root";
	String password = "root";

	public Conexion() {
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(driverUrl + timeZone, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("No se encuentra el driver");
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
