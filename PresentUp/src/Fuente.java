import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class Fuente{
    public static void main(String[] args) {
        try {
            // Ruta del archivo de la fuente en tu proyecto
            String rutaFuente = "src/Fuente/ContrailOne-Regular.ttf";  // Asegúrate de que la ruta sea correcta
            Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File(rutaFuente)).deriveFont(70f); // Tamaño de la fuente
            
            // Registrar la fuente en el sistema
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuentePersonalizada);

            // Usar la fuente
            System.out.println("Fuente personalizada cargada exitosamente");
        } catch (IOException | FontFormatException e) {
        }
    }
}