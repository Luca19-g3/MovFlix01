package datos;

import java.util.List;
import modelo.Usuario;

public interface IUsuarioDao {
	public void altaUsuario(Usuario usuario);
	public List<Usuario> listarUsuario();
	public boolean modificarUsuario(Usuario usuario, int id);
	public boolean bajaUsuario(int id);
	public Usuario obtenerUsuario(int id);
}
