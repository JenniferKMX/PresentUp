package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import java.awt.Desktop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DAM2
 */
public class VPlantillas extends javax.swing.JFrame {

    /**
     * Creates new form VPlantillas
     */
    public VPlantillas() {
        initComponents();
        agregarMenuLateral();
        cargarFuentePersonalizada(); // Cargar y aplicar la fuente al JTextField
        cambiarColorDeFondo();
        configurarTeclaF1();
        jButton1.addActionListener(e -> abrirInicioTrasLog());
        jButton3.addActionListener(e -> abrirPlantilla1(e));
        jButton4.addActionListener(e -> abrirPlantilla2(e));
        jButton5.addActionListener(e -> abrirPlantilla3(e));
        jButton6.addActionListener(e -> abrirPlantilla4(e));
    }

    ////esto es lo de ayuda
    private void configurarTeclaF1() { // esto es lo de ayuda
        // Asociar la tecla F1 a una acción específica
        String actionKey = "abrirAyuda";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F1"), actionKey);
        getRootPane().getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirAyuda(); // esto es lo de ayuda
            }
        });
    }

    private void abrirAyuda() { // esto es lo de ayuda
        Ayuda ayuda = new Ayuda();
        ayuda.setVisible(true); // Muestra la ventana
        this.dispose();
    }

    private void abrirPlantilla1(java.awt.event.ActionEvent evt) {
        try {
            // Obtener la ruta del directorio de trabajo actual
            String basePath = System.getProperty("user.dir");

            // Crear el objeto File usando una ruta relativa
            File file = new File(basePath + File.separator + "plantilla1" + File.separator + "inicio.html");

            if (file.exists()) {
                Desktop.getDesktop().browse(file.toURI());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, el archivo no existe");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR, no se puede ejecutar la opción: " + ex.getMessage());
        }
    }

    private void abrirPlantilla2(java.awt.event.ActionEvent evt) {
        try {
            // Obtener la ruta del directorio de trabajo actual
            String basePath = System.getProperty("user.dir");

            // Crear el objeto File usando una ruta relativa
            File file = new File(basePath + File.separator + "plantilla2" + File.separator + "inicio.html");

            if (file.exists()) {
                Desktop.getDesktop().browse(file.toURI());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, el archivo no existe");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR, no se puede ejecutar la opción: " + ex.getMessage());
        }
    }

    private void abrirPlantilla3(java.awt.event.ActionEvent evt) {
        try {
            // Obtener la ruta del directorio de trabajo actual
            String basePath = System.getProperty("user.dir");

            // Crear el objeto File usando una ruta relativa
            File file = new File(basePath + File.separator + "plantilla3" + File.separator + "inicio.html");

            if (file.exists()) {
                Desktop.getDesktop().browse(file.toURI());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, el archivo no existe");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR, no se puede ejecutar la opción: " + ex.getMessage());
        }
    }

    private void abrirPlantilla4(java.awt.event.ActionEvent evt) {
        try {
            // Obtener la ruta del directorio de trabajo actual
            String basePath = System.getProperty("user.dir");

            // Crear el objeto File usando una ruta relativa
            File file = new File(basePath + File.separator + "plantilla4" + File.separator + "inicio.html");

            if (file.exists()) {
                Desktop.getDesktop().browse(file.toURI());
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, el archivo no existe");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR, no se puede ejecutar la opción: " + ex.getMessage());
        }
    }

    private void cargarFuentePersonalizada() {
        try {
            // Ruta al archivo de la fuente en tu proyecto
            String rutaFuente = "src/Fuente/ContrailOne-Regular.ttf"; // Ajusta la ruta según tu proyecto
            Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File(rutaFuente)); // Fuente base sin
                                                                                                  // tamaño

            // Registrar la fuente en el sistema (opcional)
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuentePersonalizada);

            // Aplicar la fuente personalizada a los componentes
            aplicarFuentePersonalizada(fuentePersonalizada);

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    private void aplicarFuentePersonalizada(Font fuentePersonalizada) {
        jButton2.setFont(fuentePersonalizada);

        jTextField1.setFont(fuentePersonalizada);

        aplicarTamanosDeFuentes(fuentePersonalizada);
    }

    private void aplicarTamanosDeFuentes(Font fuenteBase) {
        // Definir diferentes tamaños de fuente
        Font titulos = fuenteBase.deriveFont(70f); // Tamaño de los Titulos
        Font subtitulo = fuenteBase.deriveFont(36f); // Tamaño de los Subtitulos
        Font textoPlano = fuenteBase.deriveFont(27f); // Tamaño de los textos planos
        Font textoBotones = fuenteBase.deriveFont(20f); // Tamaño de los botones
        // Font textoMenu = fuenteBase.deriveFont(20f); // Tamaño del menu
        // Aplica la fuente personalizada a cada botón con diferentes tamaños
        jButton2.setFont(textoBotones); // Tamaño 30 para este botón

        jTextField1.setFont(titulos); // Titulo (PresentUp)

    }

    private void cambiarColorDeFondo() {
        // Crear un color personalizado usando valores RGB
        Color colorPersonalizado = new Color(184, 198, 230); // Color RGB [184, 198, 230]

        // Cambiar el color de fondo del JFrame
        getContentPane().setBackground(colorPersonalizado);
    }

    private void agregarMenuLateral() {
        // Crear el menú desplegable (JPopupMenu)
        JPopupMenu popupMenu = new JPopupMenu();

        // Crear los elementos del menú
        JMenuItem nuevoProyecto = new JMenuItem("Nuevo proyecto");
        JMenuItem misProyectos = new JMenuItem("Mis proyectos");
        JMenuItem plantillas = new JMenuItem("Plantillas");
        JMenuItem miCuenta = new JMenuItem("Mi cuenta");
        JMenuItem ayuda = new JMenuItem("Ayuda");

        // Agregar los elementos al menú desplegable
        popupMenu.add(nuevoProyecto);
        popupMenu.add(misProyectos);
        popupMenu.add(plantillas);
        popupMenu.add(miCuenta);
        popupMenu.add(ayuda);

        // Agregar un ActionListener al botón jButton2 para mostrar el menú cuando se
        // hace clic
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el menú desplegable justo debajo del botón jButton2
                popupMenu.show(jButton2, jButton2.getWidth(), jButton2.getHeight());
            }
        });

        nuevoProyecto.addActionListener(e -> abrirNombreNuevoPoryecto());
        misProyectos.addActionListener(e -> abrirMisPoryectos());
        plantillas.addActionListener(e -> abrirVPlantillas());
        miCuenta.addActionListener(e -> abrirPantallaMiCuenta());
        // Falta Ayuda
    }

    private void abrirInicioTrasLog() {
        new InicioTrasLog().setVisible(true);
        this.dispose();
    }

    private void abrirNombreNuevoPoryecto() {
        new NombreNuevoPoryecto().setVisible(true);
        this.dispose();
    }

    private void abrirVPlantillas() {
        new VPlantillas().setVisible(true);
        this.dispose();
    }

    private void abrirPantallaMiCuenta() {
        new PantallaMiCuenta().setVisible(true);
        this.dispose();
    }

    private void abrirMisPoryectos() {
        new MisProyectos().setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jButton1.setText("jButton1");

        jButton2.setText("btnMenu");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla1.png"))); // NOI18N
        jButton3.setText("jButton3");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla2.png"))); // NOI18N
        jButton4.setText("jButton4");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla3.png"))); // NOI18N
        jButton5.setText("jButton5");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla 4.png"))); // NOI18N
        jButton6.setText("jButton6");

        jTextField1.setBackground(new java.awt.Color(184, 198, 230));
        jTextField1.setText("PresentUp");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                0, Short.MAX_VALUE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                463, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(141, 141, 141)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                0, Short.MAX_VALUE))
                                                .addContainerGap(273, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(545, 545, 545)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(79, 79, 79)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton3)
                                                        .addComponent(jButton4))))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton5)
                                        .addComponent(jButton6))
                                .addContainerGap(93, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPlantillas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPlantillas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
