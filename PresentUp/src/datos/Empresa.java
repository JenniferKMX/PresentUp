package datos;

public class Empresa extends Proyecto {

    private String nombre;
    private String eslogan;
    private String valores;

    public Empresa() {
    }

    public Empresa(String nombre, String eslogan, String valores) {
        this.nombre = nombre;
        this.eslogan = eslogan;
        this.valores = valores;
    }

    public String getNomEmpresa() {
        return this.nombre;
    }

    public String getEslogan() {
        return this.eslogan;
    }

    public String getValores() {
        return this.valores;
    }

    public void setNomEmpresa(String nombre) {
        this.nombre = nombre;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }

}
