package datos;

public class Financiacion {

    private float eurosSolicitados;
    private String usoFondos;
    private String proyeccionIngresos;
    private String proyeccionGastos;

    public float getEurosSolicitados() {
        return this.eurosSolicitados;
    }

    public String getUsoFondos() {
        return this.usoFondos;
    }

    public String getProyeccionIngresos() {
        return this.proyeccionIngresos;
    }

    public String getProyeccionGastos() {
        return this.proyeccionGastos;
    }

    public void setEurosSolicitados(float eurosSolicitados) {
        this.eurosSolicitados = eurosSolicitados;
    }

    public void setUsoFondos(String usoFondos) {
        this.usoFondos = usoFondos;
    }

    public void setProyeccionIngresos(String proyeccionIngresos) {
        this.proyeccionIngresos = proyeccionIngresos;
    }

    public void setProyeccionGastos(String proyeccionGastos) {
        this.proyeccionGastos = proyeccionGastos;
    }

}