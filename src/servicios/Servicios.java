package servicios;
import datos.IUsuarioDao;
import datos.PeliculaDao;
import datos.UsuarioDao;
import modelo.Pelicula;
import modelo.Usuario;
import utilidades.Datos;
import vistas.VistaPelicula;
import vistas.VistaUsuario;

//1.17. Crear la clase Servicios en el paquete servicios con el método public boolean altaPelicula() [PDS]

public class Servicios {

	public Servicios() {

	}


	
	public void listarPeliculas() {
		VistaPelicula.mostrarListaPeliculas(PeliculaDao.listarPelicula());
	}

	public void altaUsuario() {
		
		Usuario usu = new Usuario();
		usu.crearUsuario();
	}

	public void listarUsuarios() {
		//VistaUsuario.mostrarListaUsuarios(UsuarioDao.listarUsuario());
	}
	public void altaUsuarios() throws Exception {
		String nombre = Datos.recogeString("escriba el nombre: ");
		String FechaNaci =Datos.recogeString("escriba la fecha de nacimiento: ");
		String ciudad =Datos.recogeString("escriba la ciudad de residencia : ");
		Usuario usu = new Usuario(nombre,FechaNaci,ciudad); //String nombre_completo, String fecha_nacimiento, String ciudad_residencia
		UsuarioDao.altaUsuario(usu);
	}
}
