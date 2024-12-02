package datos;

public class Proyecto {

    private static int contadorId = 0;
    public int id;
    public String nombre;

    public Proyecto() {
    }

    public Proyecto(String nombre) {
        this.id = ++contadorId;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
