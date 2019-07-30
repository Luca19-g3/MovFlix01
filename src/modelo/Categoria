package modelo;
import utilidades.Datos;
public class Categoria {
    private int idcategoria;
    private String nombre;
    public Categoria() {
        super();
    }
    public Categoria(int idcategoria, String nombre) {
        super();
        this.idcategoria = idcategoria;
        this.nombre = nombre;
    }
    public int getIdcategoria() {
        return idcategoria;
    }
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * este metodo pide id categoria y nombre para crear objetos de la
     * clase Categoria
     *
     * @param none
     * @return void
     *
     */
    public void crearCategoria() {
        try {
            this.idcategoria = Datos.recogeInt("Digite el id de la categoría");
            this.nombre = Datos.recogeString("Digite el nombre de la categoría");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Categoria [idcategoria=" + idcategoria + ", nombre=" + nombre + "]";
    }
}
