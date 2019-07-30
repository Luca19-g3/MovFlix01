package datos;

import java.util.List;
import modelo.Pelicula;

public interface IPeliculasDao {
	public  void altaPelicula(Pelicula p);
	public List<Pelicula> obtenerPeliculas();
<<<<<<< HEAD
	public List<Pelicula> obtenerPeliculasPorCategoria(int id);
=======
	public List<Pelicula> obtenerPeliculas(String filtro);
>>>>>>> a675eed0e4ff991e5dcf7358d6ab3043d78d111b
	public List<Pelicula> obtenerPeliculas(String filtro, int nresultados);
	public boolean modificarPelicula(Pelicula p, int id);
	public boolean bajaPelicula(int id);
	public Pelicula obtenerPelicula(int id);
	public List<String> obtenerPeliculasMasValoradas(int limite);
	
}
