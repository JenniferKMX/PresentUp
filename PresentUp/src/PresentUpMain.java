import controladores.ControladorProyecto;
import interfaz.NombreNuevoPoryecto;
import javax.swing.SwingUtilities;

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
    }
}
