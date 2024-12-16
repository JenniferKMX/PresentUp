package interfaz;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

/**
 *
 * @author DAM2
 */
public class MisProyectos extends javax.swing.JFrame {

    /**
     * Creates new form misProyectosNB
     */
    public MisProyectos() {
        initComponents();
        cambiarColorDeFondo();
        configurarTeclaF1();
        configurarTeclaEnter();
        jButton1.addActionListener(e -> abrirInicioTrasLog());
        jButton8.addActionListener(e -> abrirInicioTrasLog());
    }

    private void configurarTeclaEnter() { 
        configurarAccionBoton(jButton8, "clicSaberMas", this::abrirInicioTrasLog); 
     }
 
     private void configurarAccionBoton(javax.swing.JButton boton, String actionKey, Runnable accion) {
         // Asocia la tecla ENTER al botón especificado
         boton.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), actionKey);
         boton.getActionMap().put(actionKey, new AbstractAction() {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent e) {
                 accion.run();  // Ejecuta la acción asociada al botón
             }
         });
     }

// //esto es lo de ayuda
    private void configurarTeclaF1() { //esto es lo de ayuda
        // Asociar la tecla F1 a una acción específica
        String actionKey = "abrirAyuda";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F1"), actionKey);
        getRootPane().getActionMap().put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirAyuda(); //esto es lo de ayuda
            }
        });
    }

    private void abrirAyuda() { //esto es lo de ayuda
        Ayuda ayuda = new Ayuda();
        ayuda.setVisible(true);    // Muestra la ventana
        this.dispose(); 
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

        // Agregar un ActionListener al botón jButton para mostrar el menú cuando se
        // hace clic
        jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el menú desplegable justo debajo del botón jButton3
                popupMenu.show(jButton3, jButton3.getWidth(), jButton3.getHeight());
            }
        });

        // Configurar la tecla ENTER para que también muestre el menú
        jButton9.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "mostrarMenu");
        jButton9.getActionMap().put("mostrarMenu", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(jButton3, jButton3.getWidth(), jButton3.getHeight());
            }
        });

        // Configurar las acciones de los elementos del menú
        nuevoProyecto.addActionListener(e -> abrirNombreNuevoPoryecto());
        misProyectos.addActionListener(e -> abrirMisPoryectos());
        plantillas.addActionListener(e -> abrirVPlantillas());
        miCuenta.addActionListener(e -> abrirPantallaMiCuenta());
        ayuda.addActionListener(e -> abrirAyuda());

        // Aplicar la fuente personalizada a los elementos del menú
        nuevoProyecto.setFont(fuentePersonalizada.deriveFont(18f));
        misProyectos.setFont(fuentePersonalizada.deriveFont(18f));
        plantillas.setFont(fuentePersonalizada.deriveFont(18f));
        miCuenta.setFont(fuentePersonalizada.deriveFont(18f));
        ayuda.setFont(fuentePersonalizada.deriveFont(18f));
    }

    private void abrirInicioTrasLog() {
        new InicioTrasLog().setVisible(true);
        this.dispose();
    }

    private void abrirInicio() {
        new Inicio().setVisible(true);
        this.dispose();
    }

    private void abrirVerPlantillas() {
        new VPlantillas().setVisible(true);
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

    

    // private void jButtonHTMLActionPerformed(java.awt.event.ActionEvent evt) {

    // try {
    // Desktop.getDesktop().browse(new URI("RUTAARCHIVOHTML")) ;
    // } catch (Exception ex) {
    // JOptionPane.showMessageDialog(null, "ERROR, no se puede ejecutar la opción");
    // }
    // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton9.setText("Menú"); // Configurar el texto del botón
        // Agregar al layout en el lugar adecuado
        getContentPane().add(jButton9); // Solo si usas un layout básico

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PresentUp");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        jLabel2.setText("Mis Proyectos");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla2.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla3.png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla 4.png"))); // NOI18N

        jButton5.setText("Ver");

        jButton6.setText("Ver");

        jButton7.setText("Ver");

        jButton8.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(239, 239, 239)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addGap(479, 479, 479)
                                                                .addComponent(jButton5)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jButton6))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                layout.createSequentialGroup()
                                                                        .addGap(95, 95, 95)
                                                                        .addComponent(jButton2)
                                                                        .addGap(56, 56, 56)
                                                                        .addComponent(jButton3)))
                                                .addGap(65, 65, 65)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton4)
                                                        .addComponent(jButton7))))
                                .addContainerGap(71, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(605, 605, 605)
                                .addComponent(jButton8)
                                .addGap(122, 122, 122)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jButton8))))
                                .addGap(80, 80, 80)
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2)
                                        .addComponent(jButton4))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5)
                                        .addComponent(jButton6)
                                        .addComponent(jButton7))
                                .addGap(0, 306, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

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
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}
