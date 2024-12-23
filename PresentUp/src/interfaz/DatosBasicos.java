package interfaz;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

/**
 *
 * @author DAM2
 */
public class DatosBasicos extends javax.swing.JFrame {

    /**
     * Creates new form datosBasicosNB
     */
    public DatosBasicos() {
        initComponents();
        cambiarColorDeFondo();
        cargarFuentePersonalizada();
        configurarTeclaF1();
        configurarTeclaEnter();
        jButton1.addActionListener(e -> abrirInicioTrasLog());
        jButton4.addActionListener(e -> abrirAniadirFund());
        //jButton5.addActionListener(e -> abrirFormProduct());
    }

    private void configurarTeclaEnter() {
        configurarAccionBoton(jButton4, "clicSaberMas", this::abrirAniadirFund);
        configurarAccionBoton(jButton5, "clicSaberMas", this::abrirFormProduct);
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
        Font titulos = fuenteBase.deriveFont(70f); // Tamaño de los Titulos
        Font subtitulo = fuenteBase.deriveFont(36f); // Tamaño de los Subtitulos
        Font otrosSubtitulos = fuenteBase.deriveFont(26f); // Tamaño de otros Subtitulos
        Font textoPlano = fuenteBase.deriveFont(14f); // Tamaño de los textos planos
        Font textoBotones = fuenteBase.deriveFont(18f); // Tamaño de los botones
        // Font textoMenu = fuenteBase.deriveFont(20f); // Tamaño del menu

        // Aplica la fuente personalizada a cada botón con diferentes tamaños

        // Aplica la fuente a los JTextField
        jLabel1.setFont(subtitulo);

    }

    private void abrirInicioTrasLog() {
        new InicioTrasLog().setVisible(true);
        this.dispose(); // Asume que Inicio.java crea un nuevo objeto Inicio
    }

    private void abrirAniadirFund() {
        new AniadirFund().setVisible(true);
        this.dispose(); // Asume que Inicio.java crea un nuevo objeto Inicio
    }

    private void abrirFormProduct() {
        new FormularioProductoServicio().setVisible(true);
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.png"))); // NOI18N

        jLabel1.setText("PresentUp");

        jLabel2.setText("Sección 1: Datos básicos");

        jLabel3.setText("Datos de la empresa:");

        jTextField1.setText("Cargo *");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("Eslogan *");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("* Campo obligatorio");

        jButton2.setText("Logo: subir imagen...");

        jLabel5.setText("¿Cuáles son vuestros valores?");

        jTextField3.setText("¿Quiénes somos?");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Datos del equipo fundador:");

        jLabel7.setText("Equipo fundador:");

        jLabel8.setText("Fundador 1:");

        jTextField4.setText("Nombre *");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setText("Nombre *");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setText("Breve biografía *");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton3.setText("Subir imagen");

        jButton4.setText("Añadir más fundadores");

        jButton5.setText("Siguiente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
            }
    });

        jLabel9.setText("1 de 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(362, 362, 362)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(325, 325, 325)
                                                .addComponent(jLabel2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextField2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        150,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jTextField4,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        150,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(34, 34, 34)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(jButton2)))
                                                                .addComponent(jLabel3))
                                                        .addComponent(jTextField3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        194, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jButton4)
                                                                                                .addComponent(jLabel7)
                                                                                                .addComponent(jLabel6))
                                                                                        .addGap(338, 338, 338))
                                                                        .addGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                        .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(jButton5)
                                                                                                .addGroup(layout
                                                                                                        .createSequentialGroup()
                                                                                                        .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(
                                                                                                                        jTextField5,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        150,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(
                                                                                                                        jTextField1,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        150,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(
                                                                                                                        jTextField6,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        150,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGap(56, 56,
                                                                                                                56)
                                                                                                        .addComponent(
                                                                                                                jButton3))
                                                                                                .addComponent(jLabel9))
                                                                                        .addGap(158, 158, 158))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(238, 238, 238)
                                                                .addComponent(jLabel8)
                                                                .addContainerGap()))))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel2))
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3))
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel5))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67,
                                        Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(95, 95, 95)));

        pack();
    }// </editor-fold>


     private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    // Validar que los campos obligatorios no estén vacíos
    String nombreEmpresa = jTextField4.getText().trim();
    String slogan = jTextField2.getText().trim();
    String nombreFundador = jTextField5.getText().trim();
    String cargo = jTextField1.getText().trim();
    String biografia = jTextField6.getText().trim();
    
    // Mensaje de error si algún campo obligatorio está vacío
    if (nombreEmpresa.isEmpty() || slogan.isEmpty() || cargo.isEmpty() || nombreFundador.isEmpty()  || biografia.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Por favor, completa todos los campos obligatorios marcados con '*'.", 
            "Error: Campos Vacíos", 
            JOptionPane.ERROR_MESSAGE);
        
        // Cambiar el borde de los campos vacíos a rojo
        if (nombreEmpresa.isEmpty()) {
            jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

        if (slogan.isEmpty()) {
            jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

        if (nombreFundador.isEmpty()) {
            jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

        if (cargo.isEmpty()) {
            jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

        if (biografia.isEmpty()) {
            jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
        } else {
            jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
        }

    } else {
        // Ejemplo: abrir otra ventana
        abrirFormProduct();
    }
}

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(DatosBasicos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosBasicos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosBasicos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosBasicos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosBasicos().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration


    // nombre de la empresa
    public String getNombreEmpresa() {
        return jTextField4.getText();
    }

    // eslogan de la empresa
    public String getEslogan() {
        return jTextField2.getText();
    }

    // ¿quienes somos?
    public String getQuienesSomos() {
        return jTextField3.getText();
    }

    // nombre fundador:
    public String getNombreFundador() {
        return jTextField5.getText();
    }

    // cargo fundador:
    public String getCargoFundador() {
        return jTextField1.getText();
    }

    // biografía fundador:
    public String getBiografia() {
        return jTextField6.getText();
    }

    // botón siguiente (guardado de esta parte del formulario)
    public JButton getSiguiente() {
        return jButton5;
    }

}
