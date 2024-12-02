package interfaz;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Color;

/**
 *
 * @author DAM2
 */
public class AniadirFund extends javax.swing.JFrame {

    /**
     * Creates new form aniadirFund
     */
    public AniadirFund() {
        initComponents();
        cambiarColorDeFondo();
        cargarFuentePersonalizada();
        configurarTeclaF1();
        configurarTeclaEnter();
        jButton1.addActionListener(e -> abrirInicioTrasLog());
        jButton2.addActionListener(e -> volverDatosBasicos());
        jButton5.addActionListener(e -> guardarFundadores());
    }

    private void configurarTeclaEnter() {
        // Asocia la tecla ENTER a la acción de los botones
        configurarAccionBoton(jButton2, "clicSaberMas", this::volverDatosBasicos);    
        //configurarAccionBoton(jButton3, "clicSaberMas", this::abrirInicioTrasLog);  Botones de subir imagen
        //configurarAccionBoton(jButton4, "clicSaberMas", this::abrirInicioTrasLog);  Botones de subir imagen
        configurarAccionBoton(jButton5, "clicSaberMas", this::guardarFundadores);
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
        // jButton1.setFont(fuentePersonalizada); LOGO
        jButton2.setFont(fuentePersonalizada);// Boton Atras
        jButton3.setFont(fuentePersonalizada);// Boton Subir Imagen Der
        jButton4.setFont(fuentePersonalizada);// Boton Subir Imagen Izq
        jButton5.setFont(fuentePersonalizada);// Boton Guardar

        // Aplica la fuente a todos los JLabel
        jLabel1.setFont(fuentePersonalizada);// Titulo
        jLabel2.setFont(fuentePersonalizada);// Subtitulo
        jLabel3.setFont(fuentePersonalizada);// Label Equipo Fundador
        jLabel4.setFont(fuentePersonalizada);// Label Fundador 2
        jLabel5.setFont(fuentePersonalizada);// Label Fundador 3
        jLabel6.setFont(fuentePersonalizada);// Numero de pag

        // Aplica la fuente a los JTextField
        jTextField1.setFont(fuentePersonalizada);// Texto Cargo F2
        jTextField2.setFont(fuentePersonalizada);// Texto Cargo F3
        jTextField5.setFont(fuentePersonalizada);// Texto Nombre F2
        jTextField6.setFont(fuentePersonalizada);// Texto Breve biografia F2
        jTextField7.setFont(fuentePersonalizada);// Texto Breve biografia F3
        jTextField8.setFont(fuentePersonalizada);// texto Nombre F3

        aplicarTamanosDeFuentes(fuentePersonalizada);
    }

    private void aplicarTamanosDeFuentes(Font fuenteBase) {
        // Definir diferentes tamaños de fuente
        Font titulos = fuenteBase.deriveFont(70f); // Tamaño de los Titulos
        Font subtitulo = fuenteBase.deriveFont(36f); // Tamaño de los Subtitulos
        Font textoPlano = fuenteBase.deriveFont(25f); // Tamaño de los textos planos
        Font textoBotones = fuenteBase.deriveFont(18f); // Tamaño de los botones
        // Font textoMenu = fuenteBase.deriveFont(20f); // Tamaño del menu

        // Aplica la fuente personalizada a cada botón con diferentes tamaños
        jButton1.setFont(textoBotones); // LOGO
        jButton2.setFont(textoBotones); // Tamaño 30 para este botón
        jButton3.setFont(textoBotones); // Tamaño 30 para este botón
        jButton4.setFont(textoBotones); // Tamaño 30 para este botón
        jButton5.setFont(textoBotones); // Tamaño 30 para este botón

        // Aplica la fuente a los JTextField
        jLabel1.setFont(titulos); // Titulo (PresentUp)
        jLabel2.setFont(subtitulo); // Subtitulo (¿Ya Tienes Cuenta?
        jLabel3.setFont(textoPlano);
        jLabel4.setFont(textoPlano);
        jLabel5.setFont(textoPlano);
        jLabel6.setFont(textoBotones);// esta label tiene el mismo tamaño de letra que los botones

        jTextField1.setFont(textoPlano);
        jTextField2.setFont(textoPlano);
        jTextField5.setFont(textoPlano);
        jTextField6.setFont(textoPlano);
        jTextField7.setFont(textoPlano);
        jTextField8.setFont(textoPlano);

    }

    private void abrirInicioTrasLog() {
        new InicioTrasLog().setVisible(true);
        this.dispose(); // Asume que Inicio.java crea un nuevo objeto Inicio
    }

    private void volverDatosBasicos() {
        new DatosBasicos().setVisible(true);
        this.dispose(); // Asume que Inicio.java crea un nuevo objeto Inicio
    }

    private void guardarFundadores() {
        new DatosBasicos().setVisible(true);
        this.dispose(); // Asume que Inicio.java crea un nuevo objeto Inicio
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        jLabel1.setText("PresentUp");

        jLabel2.setText("Sección 1: Datos básicos");

        jLabel3.setText("Equipo fundador:");

        jLabel4.setText("Fundador 2");

        jTextField1.setText("Cargo *");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField6.setText("Breve biografía *");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton3.setText("Subir imagen");

        jTextField5.setText("Nombre *");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField2.setText("Cargo *");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField7.setText("Breve biografía *");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton4.setText("Subir imagen");

        jTextField8.setText("Nombre *");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel5.setText("Fundador 3");

        jButton2.setText("Atrás");

        jButton5.setText("Guardar");

        jLabel6.setText("1 de 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4)
                                        .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5)
                                        .addComponent(jButton4))
                                .addGap(221, 221, 221))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel6))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                layout.createSequentialGroup()
                                                        .addGap(139, 139, 139)
                                                        .addComponent(jLabel3)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(362, 362, 362)
                                                                                .addComponent(jLabel1))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(325, 325, 325)
                                                                                .addComponent(jLabel2))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton2)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        819, Short.MAX_VALUE)
                                                                .addComponent(jButton5)))))
                                .addGap(91, 91, 91)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(27, 27, 27)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButton4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(jLabel2))
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel3)
                                                .addGap(66, 66, 66)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButton3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(82, 82, 82)));

        pack();
    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AniadirFund.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AniadirFund.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AniadirFund.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AniadirFund.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AniadirFund().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration

     // nombre fundador:
    public JTextField getNombreFundador2() {
        return jTextField5;
    }

    // cargo fundador:
    public JTextField getCargoFundador2() {
        return jTextField1;
    }

    // cargo fundador:
    public JTextField getBiografia2() {
        return jTextField6;
    }

     // nombre fundador:
     public JTextField getNombreFundador3() {
        return jTextField8;
    }

    // cargo fundador:
    public JTextField getCargoFundador3() {
        return jTextField2;
    }

    // cargo fundador:
    public JTextField getBiografia3() {
        return jTextField7;
    }

    public JButton guardar() {
        return jButton5;
    }


}
