package datos;

import javax.imageio.ImageIO;

public class Fundador extends Proyecto {

    private String nombre;
    private String cargo;
    private String biograf;
    ImageIO imagen;

    public int getId() {
        return super.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCargo() {
        return this.cargo;
    }

    public String getBiograf() {
        return this.biograf;
    }

    public ImageIO getImagen() {
        return this.imagen;
    }

    public void setId() {
        this.id = super.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setBiograf(String biograf) {
        this.biograf = biograf;
    }

    public void setImagen(ImageIO imagen) {
        this.imagen = imagen;
    }

}
