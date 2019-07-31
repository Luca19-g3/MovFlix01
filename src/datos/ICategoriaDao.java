package datos;

import java.util.List;

import modelo.Categoria;

public interface ICategoriaDao {
	public void altaCategoria(Categoria c);
	public boolean modificarCategoria(Categoria c, int id);
	public boolean bajaCategoria(int i);
	public Categoria obtenerCategoria(int id);
	public List<Categoria> listarCategoria();
}
