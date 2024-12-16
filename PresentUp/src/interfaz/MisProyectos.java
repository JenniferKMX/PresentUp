package interfaz;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

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
public class MisProyectos extends javax.swing.JFrame {

    /**
     * Creates new form misProyectosNB
     */
    public MisProyectos() {
        initComponents();
        cambiarColorDeFondo();
        configurarTeclaF1();
        configurarTeclaEnter();
        cargarFuentePersonalizada();
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

    private void cargarFuentePersonalizada() {
        try {
            // Ruta al archivo de la fuente en tu proyecto
            // String rutaFuente = "src/Fuente/ContrailOne-Regular.ttf"; // Ajusta la ruta
            // según tu proyecto
            Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/Fuente/ContrailOne-Regular.ttf"));

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
        // jButton1.setFont(fuentePersonalizada); //LOGO

        // Aplica la fuente a todos los JLabel
        /*
         * jLabel1.setFont(fuentePersonalizada);//Titulo
         * jLabel2.setFont(fuentePersonalizada);//Subtitulo Seccion1
         * jLabel3.setFont(fuentePersonalizada);//Editar Mi Cuenta
         * 
         * // Aplica la fuente a los JTextField
         * jTextField4.setFont(fuentePersonalizada);// Texto Email
         * jTextField5.setFont(fuentePersonalizada);// Texto Contraseña
         * jTextField6.setFont(fuentePersonalizada);// Texto Nombre
         * jTextField7.setFont(fuentePersonalizada);// Texto Apellido
         * jTextField8.setFont(fuentePersonalizada);// Texto Telefono
         * 
         * //Aplicar la fuente a los elemento del Menu
         */

        aplicarTamanosDeFuentes(fuentePersonalizada);
    }

    private void aplicarTamanosDeFuentes(Font fuenteBase) {
        // Definir diferentes tamaños de fuente
        Font titulos = fuenteBase.deriveFont(70f); // Tamaño de los Titulos
        Font subtitulo = fuenteBase.deriveFont(36f); // Tamaño de los Subtitulos
        Font otrosSubtitulos = fuenteBase.deriveFont(26f); // Tamaño de otros Subtitulos
        // Font textoPlano = fuenteBase.deriveFont(14f); // Tamaño de los textos planos
        Font textoBotones = fuenteBase.deriveFont(18f); // Tamaño de los botones

        // Aplica la fuente personalizada a cada botón con diferentes tamaños

        jLabel1.setFont(subtitulo);

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
        jButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el menú desplegable justo debajo del botón jButton3
                popupMenu.show(jButton9, jButton9.getWidth(), jButton9.getHeight());
            }
        });

        // Configurar la tecla ENTER para que también muestre el menú
        jButton9.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "mostrarMenu");
        jButton9.getActionMap().put("mostrarMenu", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(jButton3, jButton9.getWidth(), jButton9.getHeight());
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
    private void abrirInicioTrasLog() {
        new InicioTrasLog().setVisible(true);
        this.dispose(); // Asume que Inicio.java crea un nuevo objeto Inicio
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PresentUp");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
        jButton1.setText("jButton1");

        jLabel2.setText("Mis Proyectos");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla2.png"))); // NOI18N
        jButton2.setText("jButton2");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla3.png"))); // NOI18N
        jButton3.setText("jButton3");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plantilla 4.png"))); // NOI18N
        jButton4.setText("jButton4");

        jButton5.setText("Ver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Ver");

        jButton7.setText("Ver");

        jButton8.setText("Salir");

        jButton9.setText("Menú");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(436, 436, 436)
                .addComponent(jButton8)
                .addGap(89, 89, 89)
                .addComponent(jButton9)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton8)
                            .addComponent(jButton9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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

