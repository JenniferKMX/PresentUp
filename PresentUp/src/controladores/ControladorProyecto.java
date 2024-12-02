package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaz.NombreNuevoPoryecto;
import datos.Proyecto;

public class ControladorProyecto {

    private NombreNuevoPoryecto nombreProyecto;

    public ControladorProyecto(NombreNuevoPoryecto nombre) {
        this.nombreProyecto = nombre;
        this.nombreProyecto.getSiguiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNombreProyecto();
            }
        });
    }

    private void guardarNombreProyecto() {
        String nombre = nombreProyecto.getNombreProyecto();
        if (nombre == null || nombre.trim().isEmpty() || nombre.equals("Nombre*")) {
            System.out.println("Por favor, introduce un nombre válido para el proyecto.");
            return;
        }

        // Crear y mostrar el proyecto
        Proyecto proyecto = new Proyecto(nombre);
        System.out.println("Se ha creado un proyecto: ID = " + proyecto.getId() + ", Nombre = " + proyecto.getNombre());
    }
}
