package datos;

import java.util.List;

import modelo.Pelicula;
import modelo.Usuario;

public interface IUsuarioDao {
	public void altaUsuario(Usuario usuario);

	public List<Usuario> listarUsuario();

	public boolean bajaUsuario(int id);

	public boolean modificarUsuario(Usuario usuario, int id);

	public Usuario obtenerUsuario(int id);

	public List<Pelicula> obtenerPeliculasVistas(int id);

	public List<Pelicula> obtenerPeliculasNoVistas(int id);
}
