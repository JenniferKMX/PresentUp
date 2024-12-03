package interfaz;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.*;
import javax.swing.*;

public class ElegirPlantilla extends JFrame {
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8;
    private JLabel jLabel1;

    public ElegirPlantilla() {
        // Configuración de la ventana
        setTitle("Elegir Plantilla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Inicializar componentes
        jLabel1 = new JLabel("Paso 1: elige la plantilla que más se adecúe a tus necesidades");
        jLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jButton1 = new JButton(new ImageIcon(getClass().getResource("/img/Plantilla1.png")));
        jButton2 = new JButton(new ImageIcon(getClass().getResource("/img/Plantilla2.png")));
        jButton3 = new JButton(new ImageIcon(getClass().getResource("/img/Plantilla3.png")));
        jButton4 = new JButton(new ImageIcon(getClass().getResource("/img/Plantilla 4.png")));
        jButton5 = new JButton(new ImageIcon(getClass().getResource("/img/plantilla5.png")));
        jButton6 = new JButton(new ImageIcon(getClass().getResource("/img/plantilla6.png")));
        jButton7 = new JButton(new ImageIcon(getClass().getResource("/img/Logo.png"))); // Ajusta si es una plantilla
        jButton8 = new JButton("Seleccionar");
        jButton8.addActionListener(e -> abrirInicio());

        // Crear contenedor para las plantillas
        JPanel panelPlantillas = new JPanel(new GridLayout(2, 3, 10, 10));
        panelPlantillas.add(jButton1);
        panelPlantillas.add(jButton2);
        panelPlantillas.add(jButton3);
        panelPlantillas.add(jButton4);
        panelPlantillas.add(jButton5);
        panelPlantillas.add(jButton6);

        // Diseño general
        setLayout(new BorderLayout(10, 10));
        add(jLabel1, BorderLayout.NORTH);        // Texto superior
        add(panelPlantillas, BorderLayout.CENTER); // Panel con las plantillas
        add(jButton8, BorderLayout.SOUTH);       // Botón "Seleccionar"
    }

    private void abrirInicio() {
        new DatosBasicos().setVisible(true); // Asume que Inicio.java crea un nuevo objeto Inicio
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElegirPlantilla().setVisible(true));
    }
}

