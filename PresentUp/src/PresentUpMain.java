import javax.swing.SwingUtilities;

import controladores.ControladorEmpresa;
import controladores.ControladorProyecto;
import interfaz.DatosBasicos;
import interfaz.NombreNuevoPoryecto;

public class PresentUpMain {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Crear instancias de las interfaces
            NombreNuevoPoryecto nuevoProyecto = new NombreNuevoPoryecto();

            // Enlazar con los controladores
            new ControladorProyecto(nuevoProyecto);

            // Configurar las ventanas
            nuevoProyecto.setTitle("Nuevo Proyecto");
            nuevoProyecto.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            nuevoProyecto.setLocationRelativeTo(null);
            nuevoProyecto.setVisible(true);

        });

        SwingUtilities.invokeLater(() -> {
            // Crear instancias de las interfaces
            DatosBasicos datosEmpresa = new DatosBasicos();

            // Enlazar con los controladores
            new ControladorEmpresa(datosEmpresa);

            // Configurar las ventanas
            datosEmpresa.setTitle("Datos básicos");
            datosEmpresa.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            datosEmpresa.setLocationRelativeTo(null);
            datosEmpresa.setVisible(true);

        });

    }
}
