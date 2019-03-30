package NetPiLight;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Joshua Alexander
 */
public class NetPiLight_Client extends javax.swing.JFrame {

    private static Socket s;
    private static DataInputStream dataIn;
    private static DataOutputStream dataOut;

    public NetPiLight_Client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        rainbowBtn = new javax.swing.JButton();
        clearLogBtn = new javax.swing.JButton();
        clearLedBtn = new javax.swing.JButton();
        pulseBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        colorComboBox = new javax.swing.JComboBox<>();
        solidBtn = new javax.swing.JButton();
        blinkBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bounceBtn = new javax.swing.JButton();
        seqBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Net Pi Light - Client by Josh Alexander");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Log:");

        rainbowBtn.setText("Rainbow");
        rainbowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rainbowBtnActionPerformed(evt);
            }
        });

        clearLogBtn.setText("Clear Log");
        clearLogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLogBtnActionPerformed(evt);
            }
        });

        clearLedBtn.setText("Clear LEDs");
        clearLedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLedBtnActionPerformed(evt);
            }
        });

        pulseBtn.setText("Pulse");
        pulseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulseBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Functions");

        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Green", "Blue", "Yellow", "Purple", "White", "Cyan", "Magenta", "Pink" }));

        solidBtn.setText("Solid");
        solidBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solidBtnActionPerformed(evt);
            }
        });

        blinkBtn.setText("Blink");
        blinkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blinkBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Custom Effect");

        bounceBtn.setText("RGB Bounce");
        bounceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bounceBtnActionPerformed(evt);
            }
        });

        seqBtn.setText("Sequence");
        seqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seqBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Rainbow Fade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(rainbowBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bounceBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pulseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(colorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearLedBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(seqBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blinkBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(solidBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(clearLogBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearLogBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rainbowBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bounceBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(solidBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blinkBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seqBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearLedBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearLogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLogBtnActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_clearLogBtnActionPerformed

    private void clearLedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLedBtnActionPerformed
        try {
            dataOut.writeUTF("clear");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_clearLedBtnActionPerformed

    private void pulseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulseBtnActionPerformed
        String color;

        try {
            color = colorComboBox.getSelectedItem().toString().toLowerCase();

            
            dataOut.writeUTF("pulse-".concat(color));
        } catch (Exception e) {

        }
    }//GEN-LAST:event_pulseBtnActionPerformed

    private void rainbowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rainbowBtnActionPerformed
        try {
            dataOut.writeUTF("rainbow");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_rainbowBtnActionPerformed

    private void bounceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bounceBtnActionPerformed
        try {
            dataOut.writeUTF("rgb-bounce");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_bounceBtnActionPerformed

    private void solidBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solidBtnActionPerformed
        String color;

        try {
            color = colorComboBox.getSelectedItem().toString().toLowerCase();

            dataOut.writeUTF("solid-".concat(color));
        } catch (Exception e) {

        }

    }//GEN-LAST:event_solidBtnActionPerformed

    private void blinkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blinkBtnActionPerformed
        String color;

        try {
            color = colorComboBox.getSelectedItem().toString().toLowerCase();

            dataOut.writeUTF("blink-".concat(color));
        } catch (Exception e) {

        }
    }//GEN-LAST:event_blinkBtnActionPerformed

    private void seqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seqBtnActionPerformed
        String color;

        try {
            color = colorComboBox.getSelectedItem().toString().toLowerCase();

            dataOut.writeUTF("seq-".concat(color));
        } catch (Exception e) {

        }
    }//GEN-LAST:event_seqBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            dataOut.writeUTF("rainbow-fade");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NetPiLight_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NetPiLight_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NetPiLight_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NetPiLight_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NetPiLight_Client().setVisible(true);
            }
        });

        try {
            s = new Socket("192.168.137.40", 9001);
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());
            String msgIn = "";

            while (!msgIn.equals("exit")) {
                msgIn = dataIn.readUTF();
                jTextArea1.append(msgIn + "\n");
            }
        } catch (Exception e) {

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blinkBtn;
    private javax.swing.JButton bounceBtn;
    private javax.swing.JButton clearLedBtn;
    private javax.swing.JButton clearLogBtn;
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton pulseBtn;
    private javax.swing.JButton rainbowBtn;
    private javax.swing.JButton seqBtn;
    private javax.swing.JButton solidBtn;
    // End of variables declaration//GEN-END:variables
}
