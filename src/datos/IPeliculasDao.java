package datos;

import java.util.List;
import modelo.Pelicula;

public interface IPeliculasDao {
	public  void altaPelicula(Pelicula p);
	public List<Pelicula> obtenerPeliculas();
	public List<Pelicula> obtenerPeliculas(String flitro);
	public List<Pelicula> obtenerPeliculas(String filtro, int nresultados);
	public void modificarPelicula(Pelicula p, int id);
	public boolean bajaPelicula(int id);
	public Pelicula obtenerPelicula(int id);

	
}
