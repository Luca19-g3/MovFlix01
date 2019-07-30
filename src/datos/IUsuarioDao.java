package datos;

import java.util.List;
import modelo.Usuario;

public interface IUsuarioDao {
	public boolean altaUsuario(Usuario usuario);
	public List<Usuario> listarUsuario();
	public boolean modificarUsuario(Usuario usuario);
	public boolean bajaUsuario(Usuario usuario);
}
