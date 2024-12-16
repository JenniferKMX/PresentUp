package interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author Administrador
 */
public class EditarMiCuenta extends javax.swing.JFrame {

        /**
         * Creates new form EditarMiCuenta
         */
        public EditarMiCuenta() {
                initComponents();
                cambiarColorDeFondo();
                cargarFuentePersonalizada();
                configurarTeclaEnter();
                configurarTeclaF1();
                jButton1.addActionListener(e -> abrirInicioTrasLog());
                jButton4.addActionListener(e -> abrirPantallaMiCuenta());
                jButton2.addActionListener(e -> abrirInicio());
        }

        private void configurarTeclaEnter() {
                configurarAccionBoton(jButton2, "clicSaberMas", this::abrirInicio);
                configurarAccionBoton(jButton4, "clicSaberMas", this::abrirPantallaMiCuenta);
                // configurarAccionBoton(jButton5, "clicSaberMas", this::abrirFormProduct);
                // boton +
        }

        private void configurarAccionBoton(javax.swing.JButton boton, String actionKey, Runnable accion) {
                // Asocia la tecla ENTER al botón especificado
                boton.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), actionKey);
                boton.getActionMap().put(actionKey, new AbstractAction() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                                accion.run(); // Ejecuta la acción asociada al botón
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
                jLabel1.setFont(fuentePersonalizada);// Titulo

                // Aplicar la fuente a los elemento del Menu

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

                // Aplica la fuente a los JLabel
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
                jButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Mostrar el menú desplegable justo debajo del botón jButton3
                                popupMenu.show(jButton3, jButton3.getWidth(), jButton3.getHeight());
                        }
                });

                // Configurar la tecla ENTER para que también muestre el menú
                jButton3.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                                "mostrarMenu");
                jButton3.getActionMap().put("mostrarMenu", new AbstractAction() {
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
                jLabel1 = new javax.swing.JLabel();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jPanel1 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jTextField4 = new javax.swing.JTextField();
                jTextField5 = new javax.swing.JTextField();
                jTextField6 = new javax.swing.JTextField();
                jTextField7 = new javax.swing.JTextField();
                jTextField8 = new javax.swing.JTextField();
                jButton4 = new javax.swing.JButton();
                jButton5 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
                jButton1.setText("jButton1");

                jLabel1.setText("PresentUp");

                jButton2.setText("Salir");

                jButton3.setText("btn Menú");

                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EjemploPerfilCuenta.png"))); // NOI18N
                jLabel2.setText("jLabel2");

                jLabel3.setText("Editar Mi Cuenta ");

                jTextField4.setText("xxxxxx@xxxxxxx.com");

                jTextField5.setText("*****************");

                jTextField6.setText("Nombre");

                jTextField7.setText("Apellido1 Apellido2 ");

                jTextField8.setText("(+34) 000 00 00 00 ");

                jButton4.setText("Guardar");

                jButton5.setText("+");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(111, 111, 111)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField4)
                                                                                .addComponent(jTextField5))
                                                                .addGap(192, 192, 192)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField7)
                                                                                .addComponent(jTextField6)
                                                                                .addComponent(jTextField8))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                352,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                232,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton5)
                                                                .addGap(44, 44, 44))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(80, 80, 80)
                                                                                                .addComponent(jLabel3))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(473, 473, 473)
                                                                                                .addComponent(jButton4)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(jLabel3)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(52, 52, 52)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextField4)
                                                                                                                .addComponent(jTextField6))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jTextField5)
                                                                                                                .addComponent(jTextField7))
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(jTextField8))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(40, 40, 40)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jButton5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                43,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                214,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                20,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButton4)
                                                                .addGap(68, 68, 68)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addComponent(jButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                163,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(497, 497, 497)
                                                                                                .addComponent(jLabel1)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                38,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jPanel1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jButton2))
                                                                                                                .addGap(85, 85, 85)
                                                                                                                .addComponent(jButton3)
                                                                                                                .addGap(75, 75, 75)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(42, 42, 42)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jButton2)
                                                                                                                                .addComponent(jButton3))
                                                                                                                .addComponent(jButton1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                146,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(17, 17, 17))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(81, 81, 81)
                                                                                                .addComponent(jLabel1)
                                                                                                .addGap(43, 43, 43)))
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(117, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(EditarMiCuenta.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(EditarMiCuenta.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(EditarMiCuenta.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(EditarMiCuenta.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new EditarMiCuenta().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JTextField jTextField4;
        private javax.swing.JTextField jTextField5;
        private javax.swing.JTextField jTextField6;
        private javax.swing.JTextField jTextField7;
        private javax.swing.JTextField jTextField8;
        private javax.swing.JPanel jPanel1;
        // End of variables declaration//GEN-END:variables
}
