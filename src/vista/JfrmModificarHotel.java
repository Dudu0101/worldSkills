/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author javam2019
 */
public class JfrmModificarHotel extends javax.swing.JFrame {

    /**
     * Creates new form JfrmAddHotel
     */
    public JfrmModificarHotel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRbtnGrpCategoria = new javax.swing.ButtonGroup();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jRbtnCat1Mod = new javax.swing.JRadioButton();
        jRbtnCat2Mod = new javax.swing.JRadioButton();
        jRbtnCat3Mod = new javax.swing.JRadioButton();
        jRbtnCat4Mod = new javax.swing.JRadioButton();
        jRbtnCat5Mod = new javax.swing.JRadioButton();
        jBtnCancelarMod = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jTxtDireccionMod = new javax.swing.JTextField();
        jTxtNombreMod = new javax.swing.JTextField();
        jTxtCorreoMod = new javax.swing.JTextField();
        jTxtTelefonoMod = new javax.swing.JTextField();
        jCmbCiudadesMod = new javax.swing.JComboBox<>();
        jCmbxPaiseMod = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Modificar Hotel");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Correo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Ciudad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("País:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Categoría - Estrellas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 420, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 10, 50));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 260, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 10, 50));

        jRbtnGrpCategoria.add(jRbtnCat1Mod);
        jRbtnCat1Mod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnCat1Mod.setText("1");
        getContentPane().add(jRbtnCat1Mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jRbtnGrpCategoria.add(jRbtnCat2Mod);
        jRbtnCat2Mod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnCat2Mod.setText("2");
        getContentPane().add(jRbtnCat2Mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        jRbtnGrpCategoria.add(jRbtnCat3Mod);
        jRbtnCat3Mod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnCat3Mod.setText("3");
        getContentPane().add(jRbtnCat3Mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jRbtnGrpCategoria.add(jRbtnCat4Mod);
        jRbtnCat4Mod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnCat4Mod.setText("4");
        getContentPane().add(jRbtnCat4Mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jRbtnGrpCategoria.add(jRbtnCat5Mod);
        jRbtnCat5Mod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRbtnCat5Mod.setText("5");
        getContentPane().add(jRbtnCat5Mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        jBtnCancelarMod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jBtnCancelarMod.setText("Cancelar");
        getContentPane().add(jBtnCancelarMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        jBtnModificar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jBtnModificar.setText("Guardar");
        getContentPane().add(jBtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        jTxtDireccionMod.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        getContentPane().add(jTxtDireccionMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 310, -1));

        jTxtNombreMod.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        getContentPane().add(jTxtNombreMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 310, -1));

        jTxtCorreoMod.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        getContentPane().add(jTxtCorreoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 310, -1));

        jTxtTelefonoMod.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        getContentPane().add(jTxtTelefonoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 310, -1));

        jCmbCiudadesMod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jCmbCiudadesMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCmbCiudadesMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 310, -1));

        jCmbxPaiseMod.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jCmbxPaiseMod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCmbxPaiseMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 310, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 470, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JfrmModificarHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmModificarHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmModificarHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmModificarHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmModificarHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnCancelarMod;
    public javax.swing.JButton jBtnModificar;
    public javax.swing.JComboBox<String> jCmbCiudadesMod;
    public javax.swing.JComboBox<String> jCmbxPaiseMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JRadioButton jRbtnCat1Mod;
    public javax.swing.JRadioButton jRbtnCat2Mod;
    public javax.swing.JRadioButton jRbtnCat3Mod;
    public javax.swing.JRadioButton jRbtnCat4Mod;
    public javax.swing.JRadioButton jRbtnCat5Mod;
    private javax.swing.ButtonGroup jRbtnGrpCategoria;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public javax.swing.JTextField jTxtCorreoMod;
    public javax.swing.JTextField jTxtDireccionMod;
    public javax.swing.JTextField jTxtNombreMod;
    public javax.swing.JTextField jTxtTelefonoMod;
    // End of variables declaration//GEN-END:variables
}
