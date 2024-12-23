package interfaz;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;

/**
 *
 * @author DAM2
 */
public class FormularioFinanciacion extends javax.swing.JFrame {

        /**
         * Creates new form FormularioFinanciacion
         */
        public FormularioFinanciacion() {
                initComponents();
                cambiarColorDeFondo();
                cargarFuentePersonalizada();
                configurarTeclaF1();
                configurarTeclaEnter();
                jButton2.addActionListener(e -> abrirFormularioProductoServicio());
                //jButton3.addActionListener(e -> abrirProyectoListo());
        }

        private void configurarTeclaEnter() {
                configurarAccionBoton(jButton2, "clicSaberMas", this::abrirFormularioProductoServicio);
                configurarAccionBoton(jButton3, "clicSaberMas", this::abrirProyectoListo);
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

                        // Aplicar la fuente personalizada a los componentes
                        aplicarFuentePersonalizada(fuentePersonalizada);

                } catch (IOException | FontFormatException e) {
                        e.printStackTrace();
                }
        }

        private void aplicarFuentePersonalizada(Font fuentePersonalizada) {
                // Aplica la fuente a todos los botones
                // jButton1.setFont(fuentePersonalizada); //LOGO

                jLabel1.setFont(fuentePersonalizada);// Titulo

                aplicarTamanosDeFuentes(fuentePersonalizada);
        }

        private void aplicarTamanosDeFuentes(Font fuenteBase) {
                // Definir diferentes tamaños de fuente
                Font titulos = fuenteBase.deriveFont(60f); // Tamaño de los Titulos
                Font subtitulo = fuenteBase.deriveFont(36f); // Tamaño de los Subtitulos
                Font otrosSubtitulos = fuenteBase.deriveFont(26f); // Tamaño de otros Subtitulos
                Font textoPlano = fuenteBase.deriveFont(14f); // Tamaño de los textos planos
                Font textoBotones = fuenteBase.deriveFont(18f); // Tamaño de los botones

                // Aplica la fuente a los JTextField
                jLabel1.setFont(subtitulo);

        }

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
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTextArea2 = new javax.swing.JTextArea();
                jLabel7 = new javax.swing.JLabel();
                jScrollPane3 = new javax.swing.JScrollPane();
                jTextArea3 = new javax.swing.JTextArea();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("PresentUp");

                jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

                jLabel2.setText("Sección 3: Información sobre la Financiación");

                jLabel3.setText("Cantidad de financiación solicitada:");

                jLabel4.setText("Uso de los fondos:");

                jTextField1.setText("Euros(€)*");

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jTextArea1.setText("¿En qué se van a emplear?*");
                jScrollPane1.setViewportView(jTextArea1);

                jLabel5.setText("Proyecciones financieras:");

                jLabel6.setText("Ingresos:");

                jTextArea2.setColumns(20);
                jTextArea2.setRows(5);
                jTextArea2.setText("Ingresos proyectados para el próximo año*");
                jTextArea2.setToolTipText("");
                jScrollPane2.setViewportView(jTextArea2);

                jLabel7.setText("Gastos:");

                jTextArea3.setColumns(20);
                jTextArea3.setRows(5);
                jTextArea3.setText("Gastos proyectados para el proximo año");
                jScrollPane3.setViewportView(jTextArea3);

                jButton2.setText("Atrás");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setText("Finalizar");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(jButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                153,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                412,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                786,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(273, 273, 273)))
                                                                .addGap(404, 404, 404))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(242, 242, 242)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jButton2)
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(447, 447, 447)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel7)
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                288,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                .addComponent(jScrollPane3,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                298,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(38, 38, 38))
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                                .addGap(187, 187,
                                                                                                                                                                                187)
                                                                                                                                                                .addComponent(jButton3))))
                                                                                                .addContainerGap(39,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(jTextField1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                196,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jLabel3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                196,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel4)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                .addComponent(jLabel5)
                                                                                                                                                .addGap(252, 252,
                                                                                                                                                                252))
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                layout.createSequentialGroup()
                                                                                                                                                .addComponent(jLabel6)
                                                                                                                                                .addGap(315, 315,
                                                                                                                                                                315)))))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                39,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                140,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2)
                                                                .addGap(67, 67, 67)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(jLabel3))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel6)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(69, 69, 69)
                                                                                                                                .addComponent(jLabel4))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(7, 7, 7)
                                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                100,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jScrollPane1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(57, 57, 57))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel7)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jScrollPane3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                99,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButton2)
                                                                                .addComponent(jButton3))
                                                                .addContainerGap(203, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    // Validar que los campos obligatorios no estén vacíos
    String euros = jTextField1.getText().trim();
    String motivoDinero = jTextArea1.getText().trim();
    String ingresosProyectados = jTextArea2.getText().trim();
    String gastosProyectados = jTextArea3.getText().trim();
    
    // Mensaje de error si algún campo obligatorio está vacío
    if (euros.isEmpty() || motivoDinero.isEmpty() || ingresosProyectados.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Por favor, completa todos los campos obligatorios marcados con '*'.", 
            "Error: Campos Vacíos", 
            JOptionPane.ERROR_MESSAGE);
        
        // Cambiar el borde de los campos vacíos a rojo
        if (euros.isEmpty()) {
            jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

        if (motivoDinero.isEmpty()) {
            jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

        if (ingresosProyectados.isEmpty()) {
            jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

    } else {
        // Si todos los campos están completos, procede a la acción deseada
        JOptionPane.showMessageDialog(this, 
            "Formulario completado correctamente.", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Ejemplo: abrir otra ventana
        abrirProyectoListo();
    }
}


        private void abrirFormularioProductoServicio() {
                new FormularioProductoServicio().setVisible(true); // Asume que Inicio.java crea un nuevo objeto Inicio
                this.dispose();

        }

        private void abrirProyectoListo() {

                new ProyectoListo().setVisible(true); // Asume que Inicio.java crea un nuevo objeto Inicio
                this.dispose();
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
                        java.util.logging.Logger.getLogger(FormularioFinanciacion.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(FormularioFinanciacion.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(FormularioFinanciacion.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(FormularioFinanciacion.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new FormularioFinanciacion().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JTextArea jTextArea2;
        private javax.swing.JTextArea jTextArea3;
        private javax.swing.JTextField jTextField1;
        // End of variables declaration

        public String getEuros() {
                return jTextField1.getText();
        }

        public String getMotivoDinero() {
                return jTextArea1.getText();
        }

        public String getIngresosPoryectados() {
                return jTextArea2.getText();
        }

        public String getGastosPoryectados() {
                return jTextArea3.getText();
        }

        public JButton getFinalizar() {
                return jButton3;

        }

}
