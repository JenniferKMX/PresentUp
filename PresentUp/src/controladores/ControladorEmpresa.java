package controladores;

import java.awt.event.ActionListener;

import interfaz.DatosBasicos;
import datos.Empresa;
import java.awt.event.ActionEvent;

public class ControladorEmpresa {
    private DatosBasicos datos;

    public ControladorEmpresa(DatosBasicos datos){
        this.datos = datos;
        // Agregar listener al botón de guardar
        this.datos.getSiguiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEmpresa();
            }
        });
    }
    private void guardarEmpresa(){

        String nombreEmpresa = datos.getNombreEmpresa().getText();
        String slogan = datos.getEslogan().getText();
        String quienesSomos = datos.getQuienesSomos().getText();

        Empresa empresa = new Empresa(nombreEmpresa, slogan, quienesSomos);
    }
}
