package datos;

import java.util.List;

import modelo.Pelicula;

public interface IPeliculasDao {
	
	

	public  void altaPelicula(Pelicula p);
	public List<Pelicula> listarPelicula() ;
	public void modificarPelicula(Pelicula p, int id);
	public boolean bajaPelicula(int id);
}
