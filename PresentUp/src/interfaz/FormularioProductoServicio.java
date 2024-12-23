package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DAM2
 */
public class FormularioProductoServicio extends javax.swing.JFrame {

        /**
         * Creates new form FormularioProdServ
         */
        public FormularioProductoServicio() {
                setTitle("Fotrmulario producto / servicio");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(800, 600);
                setLocationRelativeTo(null);
                initComponents();
                cambiarColorDeFondo();
                configurarTeclaF1();
                configurarTeclaEnter();
                cargarFuentePersonalizada();
                jButton1.addActionListener(e -> abrirInicioTrasLog());
                jButton2.addActionListener(e -> abrirDatosBasicos());
                //jButton3.addActionListener(e -> abrirDatosFinanc());
        }

        private void configurarTeclaEnter() {
                configurarAccionBoton(jButton2, "clicSaberMas", this::abrirDatosBasicos);
                configurarAccionBoton(jButton3, "clicSaberMas", this::abrirDatosFinanc);
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

        private void abrirInicioTrasLog() {
                new InicioTrasLog().setVisible(true); // Asume que Inicio.java crea un nuevo objeto Inicio
                this.dispose();
        }

        private void abrirDatosBasicos() {
                new DatosBasicos().setVisible(true); // Asume que Inicio.java crea un nuevo objeto Inicio
                this.dispose();
        }

        private void abrirDatosFinanc() {
                new FormularioFinanciacion().setVisible(true); // Asume que Inicio.java crea un nuevo objeto Inicio
                this.dispose();
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
                JLabel1.setFont(fuentePersonalizada);// Titulo

                aplicarTamanosDeFuentes(fuentePersonalizada);
        }

        private void aplicarTamanosDeFuentes(Font fuenteBase) {
                // Definir diferentes tamaños de fuente
                Font titulos = fuenteBase.deriveFont(60f); // Tamaño de los Titulos
                Font subtitulo = fuenteBase.deriveFont(30f); // Tamaño de los Subtitulos
                Font otrosSubtitulos = fuenteBase.deriveFont(20f); // Tamaño de otros Subtitulos
                Font textoPlano = fuenteBase.deriveFont(14f); // Tamaño de los textos planos
                Font textoBotones = fuenteBase.deriveFont(18f); // Tamaño de los botones

                // Aplica la fuente personalizada a cada botón con diferentes tamaños

                // Aplica la fuente a los JTextField
                JLabel1.setFont(subtitulo);

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
                JLabel1 = new javax.swing.JLabel();
                JLabel2 = new javax.swing.JLabel();
                JLabel3 = new javax.swing.JLabel();
                JLabel4 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTextArea2 = new javax.swing.JTextArea();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                JLabel5 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N
                jButton1.setText("jButton1");

                JLabel1.setText("PresentUp");
                JLabel1.setBorder(null);

                JLabel2.setText("Sección 2: Información sobre el Producto o Servicio");
                JLabel2.setBorder(null);

                JLabel3.setText("Descripción detallada:");
                JLabel3.setBorder(null);

                JLabel4.setText("Público objetivo:");
                JLabel4.setBorder(null);

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane1.setViewportView(jTextArea1);

                jTextArea2.setColumns(20);
                jTextArea2.setRows(5);
                jScrollPane2.setViewportView(jTextArea2);

                jButton2.setText("Atras");

                jButton3.setText("Siguiente");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                JLabel5.setText("2 de 3");
                JLabel5.setBorder(null);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(341, 341, 341)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(JLabel3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                295,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(244, 244, 244)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(JLabel4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                282,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(83, 83, 83)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jButton1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                150,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(453, 453,
                                                                                                                                                                                453)
                                                                                                                                                                .addComponent(JLabel1,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(360, 360,
                                                                                                                                                                                360)
                                                                                                                                                                .addComponent(JLabel2,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                429,
                                                                                                                                                Short.MAX_VALUE))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jButton2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                115,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jButton3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                121,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(80, 80, 80))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(JLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                48,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(54, 54, 54)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(53, 53, 53)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(JLabel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                127,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(JLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(JLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(JLabel4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(37, 37, 37)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                263,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane1))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                178,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jButton3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                38,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(JLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void JLabel2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_JLabel2ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_JLabel2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                // Validar que los campos obligatorios no estén vacíos
                String producto = jTextArea1.getText().trim();
                String publicoObjetivo = jTextArea2.getText().trim();
                
                // Mensaje de error si algún campo obligatorio está vacío
                if (producto.isEmpty() || publicoObjetivo.isEmpty()) {
                        JOptionPane.showMessageDialog(this, 
                        "Por favor, completa todos los campos obligatorios marcados con '*'.", 
                        "Error: Campos Vacíos", 
                        JOptionPane.ERROR_MESSAGE);
                        
                        // Cambiar el borde de los campos vacíos a rojo
                        if (producto.isEmpty()) {
                        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                        } else {
                        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
                        }

                        if (publicoObjetivo.isEmpty()) {
                        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                        } else {
                        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
                        }


                } else {
                        // Ejemplo: abrir otra ventana
                        abrirDatosFinanc();
                }
        }

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
                        java.util.logging.Logger.getLogger(FormularioProductoServicio.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(FormularioProductoServicio.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(FormularioProductoServicio.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(FormularioProductoServicio.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new FormularioProductoServicio().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JTextArea jTextArea2;
        private javax.swing.JLabel JLabel1;
        private javax.swing.JLabel JLabel2;
        private javax.swing.JLabel JLabel3;
        private javax.swing.JLabel JLabel4;
        private javax.swing.JLabel JLabel5;
        // End of variables declaration//GEN-END:variables

        // descripcion producto o servicio
        public String getDescripcion() {
                return jTextArea1.getText();
        }

        // cargo publico objetivo:
        public String getPublicoObjetivo() {
                return jTextArea2.getText();
        }

        // botón siguiente (guardado de esta parte del formulario)
        public JButton getSiguiente() {
                return jButton3;
        }
}
