import javax.swing.SwingUtilities;

import controladores.ControladorEmpresa;
import controladores.ControladorFinanciacion;
import controladores.ControladorFundadores;
import controladores.ControladorProductoServicio;
import controladores.ControladorProyecto;
import interfaz.AniadirFund;
import interfaz.DatosBasicos;
import interfaz.FormularioFinanciacion;
import interfaz.FormularioProductoServicio;
import interfaz.NombreNuevoPoryecto;

public class PresentUpMain {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Crear instancias de las interfaces
            NombreNuevoPoryecto nuevoProyecto = new NombreNuevoPoryecto();
            DatosBasicos datosBasicos = new DatosBasicos();
            AniadirFund aniadirFund = new AniadirFund();
            FormularioProductoServicio productoServicio = new FormularioProductoServicio();
            FormularioFinanciacion financiacion = new FormularioFinanciacion();

            // Enlazar con los controladores
            new ControladorProyecto(nuevoProyecto);
            new ControladorEmpresa(datosBasicos);
            new ControladorFundadores(aniadirFund);
            new ControladorProductoServicio(productoServicio);
            new ControladorFinanciacion(financiacion);

            // Configurar las ventanas
            nuevoProyecto.setTitle("Nuevo Proyecto");
            nuevoProyecto.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            nuevoProyecto.setLocationRelativeTo(null);
            nuevoProyecto.setVisible(true);

            datosBasicos.setTitle("Datos Básicos de la Empresa");
            datosBasicos.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            datosBasicos.setLocationRelativeTo(null);
            datosBasicos.setVisible(true);

            aniadirFund.setTitle("Datos Fundadores");
            aniadirFund.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            aniadirFund.setLocationRelativeTo(null);
            aniadirFund.setVisible(true);

            productoServicio.setTitle("Datos del Producto");
            productoServicio.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            productoServicio.setLocationRelativeTo(null);
            productoServicio.setVisible(true);

            financiacion.setTitle("Datos Sobre la Financiación");
            financiacion.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            financiacion.setLocationRelativeTo(null);
            financiacion.setVisible(true);
        });
    }
}
