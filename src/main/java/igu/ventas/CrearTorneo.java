/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package igu.ventas;

import java.awt.event.ActionEvent;

/**
 *
 * @author nicoz
 */
public class CrearTorneo extends javax.swing.JDialog {

    /**
     * Creates new form CrearTorneo
     */
    public CrearTorneo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        bgFormato = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NomTorneo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbSingles = new javax.swing.JRadioButton();
        rbMulti = new javax.swing.JRadioButton();
        Confirmacion = new javax.swing.JButton();
        Crear = new javax.swing.JButton();
        CantEquipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rellene los datos de su torneo a crear");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 370, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Torneo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        NomTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomTorneoActionPerformed(evt);
            }
        });
        jPanel1.add(NomTorneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Juego");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 60, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 220, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad de jugadores");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 220, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Formato");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        bgFormato.add(rbSingles);
        rbSingles.setForeground(new java.awt.Color(255, 255, 255));
        rbSingles.setText("Singels");
        jPanel1.add(rbSingles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        bgFormato.add(rbMulti);
        rbMulti.setForeground(new java.awt.Color(255, 255, 255));
        rbMulti.setText("Partida en equipos");
        rbMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMultiActionPerformed(evt);
            }
        });
        jPanel1.add(rbMulti, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        Confirmacion.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        Confirmacion.setForeground(new java.awt.Color(255, 255, 255));
        Confirmacion.setText("Confirmar Formato");
        Confirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmacionActionPerformed(evt);
            }
        });
        jPanel1.add(Confirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        Crear.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        Crear.setForeground(new java.awt.Color(255, 255, 255));
        Crear.setText("Crear Torneo");
        jPanel1.add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 130, 30));

        CantEquipo.setForeground(new java.awt.Color(255, 255, 255));
        CantEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4" }));
        CantEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(CantEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMultiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMultiActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void NomTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomTorneoActionPerformed

  
    private void ConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmacionActionPerformed
        if(rbSingles.isSelected()){
            CantEquipo.setVisible(true);
        }
    }//GEN-LAST:event_ConfirmacionActionPerformed

    private void CantEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantEquipoActionPerformed



    
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
            java.util.logging.Logger.getLogger(CrearTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearTorneo dialog = new CrearTorneo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CantEquipo;
    private javax.swing.JButton Confirmacion;
    private javax.swing.JButton Crear;
    private javax.swing.JTextField NomTorneo;
    private javax.swing.ButtonGroup bgFormato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JRadioButton rbMulti;
    private javax.swing.JRadioButton rbSingles;
    // End of variables declaration//GEN-END:variables
}
