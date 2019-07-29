package modelo;

import utilidades.Datos;

public class Usuario {
	
	private int id_usuario;
	private String nombre_completo;
	private String fecha_nacimiento;
	private String ciudad_residencia;
	
	
	

	public Usuario() {
		super();
	}

	public Usuario(String nombre_completo, String fecha_nacimiento, String ciudad_residencia) {
		super();
		this.nombre_completo = nombre_completo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.ciudad_residencia = ciudad_residencia;
	}

	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Usuario(int id_usuario, String nombre_completo, String fecha_nacimiento, String ciudad_residencia) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_completo = nombre_completo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.ciudad_residencia = ciudad_residencia;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCiudad_residencia() {
		return ciudad_residencia;
	}

	public void setCiudad_residencia(String ciudad_residencia) {
		this.ciudad_residencia = ciudad_residencia;
	}
	
	/**
	 * este metodo pide nombre, fecha de nacimiento y ciudad de residencia para crear objetos de la
	 * clase usuario
	 * 
	 * @param none 
	 * @return void
	 * 
	 */
	
	public void crearUsuario() {
		try {

			this.nombre_completo = Datos.recogeString("Introduzca nombre completo ");
			this.fecha_nacimiento = Datos.recogeString("Introduzca su fecha de nacimiento(dd-mm-aaaa)");
			this.ciudad_residencia = Datos.recogeString("Introduzca su ciudad de residencia");

		} catch (Exception e) {
			e.getStackTrace();
		}
			
		
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre_completo=" + nombre_completo + ", fecha_nacimiento="
				+ fecha_nacimiento + ", ciudad_residencia=" + ciudad_residencia + "]";
	}
	


}
