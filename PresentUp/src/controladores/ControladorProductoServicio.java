package controladores;

import java.awt.event.ActionListener;

import interfaz.DatosBasicos;
import interfaz.FormularioProductoServicio;
import datos.Empresa;
import datos.ProductoServicio;

import java.awt.event.ActionEvent;

public class ControladorProductoServicio {
    private FormularioProductoServicio productoServicio;

    public ControladorProductoServicio(FormularioProductoServicio productoServicio){
        this.productoServicio = productoServicio;
        // Agregar listener al botón de guardar
        this.productoServicio.getSiguiente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
    }
    private void guardarProducto(){

        String descripcion = productoServicio.getDescripcion();
        String publico = productoServicio.getPublicoObjetivo();

        ProductoServicio productoServicio = new ProductoServicio(descripcion, publico);
    }
}
