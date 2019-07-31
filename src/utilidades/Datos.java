package utilidades;

import java.util.Scanner;

public class Datos {

	public Datos() {

	}

	/**
	 * @param
	 * @return String
	 * @throws Exception Estos metodos se utilizan para la lectura y recogida de
	 *                   datos.
	 */
	@SuppressWarnings("resource")
	public static String recogeString() throws Exception {
		String dato = new Scanner(System.in).nextLine();
		return dato;
	}

	/**
	 * @param String mensaje que se muestra al pedir los datos
	 * @return String
	 * @throws Exception Estos metodos se utilizan para la lectura y recogida de
	 *                   datos.
	 */
	public static String recogeString(String msg) throws Exception {
		System.out.println(msg);
		return recogeString();
	}

	/**
	 * @param
	 * @return Int
	 * @throws Exception Estos metodos se utilizan para la lectura y recogida de
	 *                   datos.
	 */
	@SuppressWarnings("resource")
	public static int recogeInt() throws Exception {
		int dato = new Scanner(System.in).nextInt();
		return dato;
	}

	/**
	 * @param String mensaje que se muestra al pedir los datos
	 * @return Int
	 * @throws Exception Estos metodos se utilizan para la lectura y recogida de
	 *                   datos.
	 */
	public static int recogeInt(String msg) throws Exception {
		System.out.println(msg);
		return recogeInt();
	}

	/**
	 * @param
	 * @return double
	 * @throws Exception Estos metodos se utilizan para la lectura y recogida de
	 *                   datos.
	 */
	@SuppressWarnings("resource")
	public static double recogeDouble() throws Exception {
		double dato = new Scanner(System.in).nextDouble();
		return dato;
	}

	/**
	 * @param String mensaje que se muestra al pedir los datos
	 * @return Double
	 * @throws Exception Estos metodos se utilizan para la lectura y recogida de
	 *                   datos.
	 */
	public static double recogeDouble(String msg) throws Exception {
		System.out.println(msg);
		return recogeDouble();
	}

}
