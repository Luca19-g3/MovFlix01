/**
 * Clase ICategoriaDao
 * Interfaz que contiene los metodos que contiene la Clase CategoriaDao
 *@author grupo3
 *@version 1.0
 * fecha 31/07/2019
 * 
 */

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
