package datos;

import java.util.List;

import modelo.Categoria;

public interface ICategoriaDao {
	public void altaCategoria(Categoria c);
	public boolean modificarCategoria(Categoria c, int id);
	public boolean bajaCategoria(int i);
	public List<Categoria> listarCategoria();
	public List<Categoria> listarCategoria(String criterio);
	public List<Categoria> listarCategoria(String criterio, int nresultados);
	public void noVistas();

}
