/**
 * Clase IPeliculasDao
 *Interfaz que contiene los metodos para la clase PeliculasDao
 *@author grupo3
 *@version 1.0
 * fecha 31/07/2019
 * 
 */
package datos;

import java.util.List;
import modelo.Pelicula;

public interface IPeliculasDao {
	public void altaPelicula(Pelicula p);

	public List<Pelicula> obtenerPeliculas();

	public boolean modificarPelicula(Pelicula p, int id);

	public boolean bajaPelicula(int id);

	public Pelicula obtenerPelicula(int id);

	public List<Pelicula> obtenerPeliculasPorCategoria(int id);

	public List<String> obtenerPeliculasMasVistas(int limite);

	public List<String> obtenerPeliculasMasValoradas(int limite);

}
