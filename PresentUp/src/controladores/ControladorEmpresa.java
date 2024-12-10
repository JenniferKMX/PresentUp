package controladores;

import java.awt.event.ActionListener;

import interfaz.DatosBasicos;
import datos.Empresa;
import java.awt.event.ActionEvent;

public class ControladorEmpresa {
    private DatosBasicos datos;

    public ControladorEmpresa(DatosBasicos datos) {
        this.datos = datos;
        // Agregar listener al botón de guardar
        this.datos.getSiguiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEmpresa();
            }
        });
    }

    private void guardarEmpresa() {

        String nombreEmpresa = datos.getNombreEmpresa();
        if (nombreEmpresa == null || nombreEmpresa.trim().isEmpty() || nombreEmpresa.equals("Nombre*")) {
            System.out.println("Por favor, introduce un nombre para la empresa.");
            return;
        }
        String slogan = datos.getEslogan();
        if (slogan == null || slogan.trim().isEmpty() || slogan.equals("Nombre*")) {
            System.out.println("Por favor, introduce un slogan.");
            return;
        }
        String quienesSomos = datos.getQuienesSomos();

        Empresa empresa = new Empresa(nombreEmpresa, slogan, quienesSomos);
        System.out.println("Se ha guardado la empresa: Nombre = " + empresa.getNomEmpresa());
    }
}
