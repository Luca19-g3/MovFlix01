package datos;

import java.util.List;

import modelo.Categoria;

public interface ICategoriaDao {
	public void altaCategoria();
	public void modificarCategoria();
	public boolean bajaCategoria();
	public List<Categoria> listarCategoria();
	public List<Categoria> listarCategoria(String criterio);
	public List<Categoria> listarCategoria(String criterio, int nresultados);
	public void noVistas();

}
