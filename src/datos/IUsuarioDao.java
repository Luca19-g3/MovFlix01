package datos;
import java.util.List;

import modelo.Usuario;

public interface IUsuarioDao {

	public boolean altaUsuario(Usuario usuario);
	public List<Usuario> Listar();
	public boolean modificar(Usuario usuario);
	public boolean baja(Usuario usuario);
	
	
}
