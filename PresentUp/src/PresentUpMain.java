import javax.swing.SwingUtilities;
import controladores.ControladorProyecto;
import interfaz.NombreNuevoPoryecto;

public class PresentUpMain {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Crear instancia de la interfaz
            NombreNuevoPoryecto nuevoProyecto = new NombreNuevoPoryecto();

            // Enlazar con el controlador
            new ControladorProyecto(nuevoProyecto);

            // Configurar y mostrar la ventana
            nuevoProyecto.setTitle("Nuevo Proyecto");
            nuevoProyecto.setDefaultCloseOperation(NombreNuevoPoryecto.EXIT_ON_CLOSE);
            nuevoProyecto.setLocationRelativeTo(null);
            nuevoProyecto.setVisible(true);
        });

    }
}
