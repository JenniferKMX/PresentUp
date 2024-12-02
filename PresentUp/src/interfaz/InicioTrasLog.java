package interfaz;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author DAM2
 */
public class InicioTrasLog extends javax.swing.JFrame {

    public InicioTrasLog() {
        initComponents();
        cambiarColorDeFondo();
        cargarFuentePersonalizada();
        configurarTeclaF1();
        configurarTeclaEnter(); 
        jButton1.addActionListener(e -> abrirInicioTrasLog());
        jButton2.addActionListener(e -> abrirInicio());
        jButton4.addActionListener(e -> abrirVerPlantillas());
        jButton5.addActionListener(e -> abrirPlantilla1(e));
        jButton6.addActionListener(e -> abrirPlantilla2(e));
        jButton7.addActionListener(e -> abrirPlantilla3(e));
        jButton8.addActionListener(e -> abrirPlantilla4(e));
    }

    private void configurarTeclaEnter() {
        configurarAccionBoton(jButton2, "clicSaberMas", this::abrirInicio);    
        configurarAccionBoton(jButton4, "clicSaberMas", this::abrirVerPlantillas);    
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

private void cargarFuentePersonalizada() {
        try {
            // Ruta al archivo de la fuente en tu proyecto
           // String rutaFuente = "src/Fuente/ContrailOne-Regular.ttf";  // Ajusta la ruta según tu proyecto
            Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Fuente/ContrailOne-Regular.ttf"));
            
            // Registrar la fuente en el sistema (opcional)
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuentePersonalizada);

            agregarMenuLateral(fuentePersonalizada);

            // Aplicar la fuente personalizada a los componentes
            aplicarFuentePersonalizada(fuentePersonalizada);

        } catch (IOException | FontFormatException e) {  
            e.printStackTrace();
        }
    }

    private void aplicarFuentePersonalizada(Font fuentePersonalizada) {
        // Aplica la fuente a todos los botones
        //jButton1.setFont(fuentePersonalizada); //LOGO
        jButton2.setFont(fuentePersonalizada);// Salir 
        jButton3.setFont(fuentePersonalizada);// Btn Menu
        jButton4.setFont(fuentePersonalizada);// Guardar
        jButton5.setFont(fuentePersonalizada);// +

        // Aplica la fuente a todos los JLabel
       /*  jLabel1.setFont(fuentePersonalizada);//Titulo 
        jLabel2.setFont(fuentePersonalizada);//Subtitulo Seccion1
        jLabel3.setFont(fuentePersonalizada);//Editar Mi Cuenta 
            
        // Aplica la fuente a los JTextField
        jTextField4.setFont(fuentePersonalizada);// Texto Email
        jTextField5.setFont(fuentePersonalizada);// Texto Contraseña
        jTextField6.setFont(fuentePersonalizada);// Texto Nombre 
        jTextField7.setFont(fuentePersonalizada);// Texto Apellido
        jTextField8.setFont(fuentePersonalizada);// Texto Telefono

        //Aplicar la fuente a los elemento del Menu */

        aplicarTamanosDeFuentes(fuentePersonalizada);
    }

    private void aplicarTamanosDeFuentes(Font fuenteBase) {
        // Definir diferentes tamaños de fuente
        Font titulos = fuenteBase.deriveFont(70f); // Tamaño de los Titulos
        Font subtitulo = fuenteBase.deriveFont(36f); // Tamaño de los Subtitulos
        Font otrosSubtitulos = fuenteBase.deriveFont(26f); // Tamaño de otros Subtitulos
        //Font textoPlano = fuenteBase.deriveFont(14f);  // Tamaño de los textos planos
        Font textoBotones = fuenteBase.deriveFont(18f);  // Tamaño de los botones 
 

        // Aplica la fuente personalizada a cada botón con diferentes tamaños
        jButton2.setFont(textoBotones);
        jButton3.setFont(textoBotones);
        jButton4.setFont(textoBotones);
        jButton5.setFont(textoBotones);
        

        // Aplica la fuente a los JLabel
        //jLabel1.setFont(titulos);
        //jLabel2.setFont(subtitulo);   
       // jLabel3.setFont(otrosSubtitulos);  
       
        // Aplica la fuente a los JTextField
        //jTextField4.setFont(textoBotones);
       // jTextField5.setFont(textoBotones);
        //jTextField6.setFont(textoBotones);
       // jTextField7.setFont(textoBotones);
       // jTextField8.setFont(textoBotones);

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

    private void cambiarColorDeFondo() {
        // Crear un color personalizado usando valores RGB
        Color colorPersonalizado = new Color(184, 198, 230); // Color RGB [184, 198, 230]

        // Cambiar el color de fondo del JFrame
        getContentPane().setBackground(colorPersonalizado);
    }

    private void agregarMenuLateral(Font fuentePersonalizada) {
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
    
        // Agregar un ActionListener al botón jButton3 para mostrar el menú cuando se
        // hace clic
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el menú desplegable justo debajo del botón jButton3
                popupMenu.show(jButton3, jButton3.getWidth(), jButton3.getHeight());
            }
        });
    
        // Configurar la tecla ENTER para que también muestre el menú
        jButton3.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "mostrarMenu");
        jButton3.getActionMap().put("mostrarMenu", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(jButton3, jButton3.getWidth(), jButton3.getHeight());
            }
        });
    
        // Configurar las acciones de los elementos del menú
        nuevoProyecto.addActionListener(e -> abrirNombreNuevoPoryecto());
        // Falta mis proyectos
        plantillas.addActionListener(e -> abrirVPlantillas());
        miCuenta.addActionListener(e -> abrirPantallaMiCuenta());
        // Falta Ayuda
    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jMenuItem1.setText("Nuevo Proyecto");

        jMenuItem2.setText("Mis Proyectos");

        jMenuItem3.setText("Plantillas");

        jMenuItem4.setText("Mi Cuenta");

        jMenuItem5.setText("Ayuda");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jButton1.setName("logoButton"); // NOI18N

        jButton2.setText("Salir");
        jButton2.setName("salirButton"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Menú");
        jButton3.setName("menuButton"); // NOI18N

        jButton4.setText("Ver Todas");
        jButton4.setName("todasButton"); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla1.png"))); // NOI18N
        jButton5.setName("p1Button"); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla2.png"))); // NOI18N
        jButton6.setName("p2Button"); // NOI18N

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla3.png"))); // NOI18N
        jButton7.setName("p3Button"); // NOI18N

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla 4.png"))); // NOI18N
        jButton8.setName("p4Button"); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(184, 198, 230));
        jTextField1.setForeground(new java.awt.Color(6, 21, 45));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("PresentUp");
        jTextField1.setToolTipText("");
        jTextField1.setAlignmentX(733.4F);
        jTextField1.setAlignmentY(31.0F);
        jTextField1.setBorder(null);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(241, 241, 241)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        226, Short.MAX_VALUE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 525,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(208, 208, 208)
                                                .addComponent(jButton2)
                                                .addGap(35, 35, 35)
                                                .addComponent(jButton3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton7)
                                                        .addComponent(jButton5))
                                                .addGap(131, 131, 131)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton6)
                                                        .addComponent(jButton8))
                                                .addGap(135, 135, 135)))
                                .addGap(23, 23, 23))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(56, 56, 56)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton2)
                                                                        .addComponent(jButton3))
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton7)
                                        .addComponent(jButton8))
                                .addGap(78, 78, 78)
                                .addComponent(jButton4)
                                .addGap(142, 142, 142)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(InicioTrasLog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioTrasLog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioTrasLog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioTrasLog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioTrasLog().setVisible(true);
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
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
