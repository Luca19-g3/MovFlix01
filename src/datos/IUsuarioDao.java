package datos;

import java.util.List;
import modelo.Usuario;

public interface IUsuarioDao {
	public void altaUsuario(Usuario usuario);
	public List<Usuario> listarUsuario();
	public void modificarUsuario(Usuario usuario, int id);
	public void bajaUsuario(int id);
	public Usuario obtenerUsuario(int id);
}
