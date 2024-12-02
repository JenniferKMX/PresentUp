package controladores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interfaz.NombreNuevoPoryecto;
import datos.Proyecto;

public class ControladorProyecto {

    private NombreNuevoPoryecto nombreProyecto;

    public ControladorProyecto(NombreNuevoPoryecto nombre) {
        this.nombreProyecto = nombre;
        this.nombreProyecto.getSiguiente().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarNombreProyecto();
            }
        });
    }

    private void guardarNombreProyecto() {
        String nombre = nombreProyecto.getNombreProyecto();
    }

}
