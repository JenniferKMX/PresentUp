package datos;

public class ProductoServicio extends Proyecto {

    private String descripcion;
    private String publico;

    public ProductoServicio() {
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
