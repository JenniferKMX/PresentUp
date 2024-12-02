package datos;

public class ProductoServicio extends Proyecto {

    private String descripcion;
    private String publico;

    public ProductoServicio() {
    }

    public ProductoServicio(String descripcion, String publico){
        this.descripcion = descripcion;
        this.publico = publico;

    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getPublico() {
        return this.publico;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

}
