import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.Colour;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Jimbo.Graphics.ColourMatrixDemo;
import Jimbo.Graphics.Point;
import java.util.Random;

/**
 *
 * @author Joshua Alexander
 */
public class NetPiLight_Server extends javax.swing.JFrame {
    
    static ServerSocket ss;
    static Socket s;
    static DataInputStream dataIn;
    static DataOutputStream dataOut;
    static Blinkt b = new Blinkt();
    
    public NetPiLight_Server() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        clearLogBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Net Pi Light - Server by Josh Alexander");

        jLabel1.setText("Log:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        clearLogBtn.setText("Clear Log");
        clearLogBtn.setToolTipText("");
        clearLogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearLogBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearLogBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearLogBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearLogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearLogBtnActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_clearLogBtnActionPerformed

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
            java.util.logging.Logger.getLogger(NetPiLight_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NetPiLight_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NetPiLight_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NetPiLight_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NetPiLight_Server().setVisible(true);
            }
        });
        
        String msgIn = "";
        String msgOut = "";
        
        try {
            ss = new ServerSocket(9001); // The port to use.
            s = ss.accept(); // Accepts the cnnection on specified port.
            jTextArea1.append("Incoming Connection from: " + s.getRemoteSocketAddress() + "\n");
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());
            
            msgOut = "Connected to Server: " + s.getLocalSocketAddress();
            dataOut.writeUTF(msgOut);
            
            while(!msgIn.equals("exit")) {
                msgIn = dataIn.readUTF();
                
                switch (msgIn) {
                    case "rainbow":
                        jTextArea1.append("Running Rainbow\n");
                        msgOut = ">> Rainbow Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        ColourMatrixDemo.run(b);
                        
                        break;
                    case "rainbow-fade":
                        jTextArea1.append("Running Rainbow Fade\n");
                        msgOut = ">> Rainbow Fade Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        int r, g, bl;
                        Random rand = new Random();
                        
                        for (int i = 0; i < 5; i++) {
                            r = rand.nextInt(128);
                            g = rand.nextInt(128);
                            bl = rand.nextInt(128);
                            
                            for (int j = 0; j < 32; j++) {
                                b.set(0, r, g, bl, j);
                                b.set(1, r, g, bl, j);
                                b.set(2, r, g, bl, j);
                                b.set(3, r, g, bl, j);
                                b.set(4, r, g, bl, j);
                                b.set(5, r, g, bl, j);
                                b.set(6, r, g, bl, j);
                                b.set(7, r, g, bl, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, r, g, bl, k);
                                b.set(1, r, g, bl, k);
                                b.set(2, r, g, bl, k);
                                b.set(3, r, g, bl, k);
                                b.set(4, r, g, bl, k);
                                b.set(5, r, g, bl, k);
                                b.set(6, r, g, bl, k);
                                b.set(7, r, g, bl, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "rgb-bounce":
                        jTextArea1.append("Running RGB Bounce\n");
                        msgOut = ">> RGB Bounce Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        int phase = 0;
                        final double max_distance = 8;
                        
                        for (int i = 0; i < 4; i++) {
                            for(int j = 0, k = 7; j < 8 && k >= 0; j++, k--) {
                                double fraction = j / max_distance;

                                double value1 = 360 * (1 - fraction) + phase;

                                if (value1 > 360)
                                    value1 -= 360;

                                Colour c1 = new Colour (value1);

                                b.setPixel(new Point(j, 0), c1);
                                b.setPixel(new Point(k, 0), c1);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                Thread.sleep(50);
                                phase++;
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-white":
                        jTextArea1.append("Running White Pulse\n");
                        msgOut = ">> White Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 255, 255, 255, j);
                                b.set(1, 255, 255, 255, j);
                                b.set(2, 255, 255, 255, j);
                                b.set(3, 255, 255, 255, j);
                                b.set(4, 255, 255, 255, j);
                                b.set(5, 255, 255, 255, j);
                                b.set(6, 255, 255, 255, j);
                                b.set(7, 255, 255, 255, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 255, 255, 255, k);
                                b.set(1, 255, 255, 255, k);
                                b.set(2, 255, 255, 255, k);
                                b.set(3, 255, 255, 255, k);
                                b.set(4, 255, 255, 255, k);
                                b.set(5, 255, 255, 255, k);
                                b.set(6, 255, 255, 255, k);
                                b.set(7, 255, 255, 255, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-purple":
                        jTextArea1.append("Running Purple Pulse\n");
                        msgOut = ">> Purple Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 128, 0, 128, j);
                                b.set(1, 128, 0, 128, j);
                                b.set(2, 128, 0, 128, j);
                                b.set(3, 128, 0, 128, j);
                                b.set(4, 128, 0, 128, j);
                                b.set(5, 128, 0, 128, j);
                                b.set(6, 128, 0, 128, j);
                                b.set(7, 128, 0, 128, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 128, 0, 128, k);
                                b.set(1, 128, 0, 128, k);
                                b.set(2, 128, 0, 128, k);
                                b.set(3, 128, 0, 128, k);
                                b.set(4, 128, 0, 128, k);
                                b.set(5, 128, 0, 128, k);
                                b.set(6, 128, 0, 128, k);
                                b.set(7, 128, 0, 128, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-red":
                        jTextArea1.append("Running Red Pulse\n");
                        msgOut = ">> Red Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 255, 0, 0, j);
                                b.set(1, 255, 0, 0, j);
                                b.set(2, 255, 0, 0, j);
                                b.set(3, 255, 0, 0, j);
                                b.set(4, 255, 0, 0, j);
                                b.set(5, 255, 0, 0, j);
                                b.set(6, 255, 0, 0, j);
                                b.set(7, 255, 0, 0, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 255, 0, 0, k);
                                b.set(1, 255, 0, 0, k);
                                b.set(2, 255, 0, 0, k);
                                b.set(3, 255, 0, 0, k);
                                b.set(4, 255, 0, 0, k);
                                b.set(5, 255, 0, 0, k);
                                b.set(6, 255, 0, 0, k);
                                b.set(7, 255, 0, 0, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-blue":
                        jTextArea1.append("Running Blue Pulse\n");
                        msgOut = ">> Blue Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 0, 0, 255, j);
                                b.set(1, 0, 0, 255, j);
                                b.set(2, 0, 0, 255, j);
                                b.set(3, 0, 0, 255, j);
                                b.set(4, 0, 0, 255, j);
                                b.set(5, 0, 0, 255, j);
                                b.set(6, 0, 0, 255, j);
                                b.set(7, 0, 0, 255, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 0, 0, 255, k);
                                b.set(1, 0, 0, 255, k);
                                b.set(2, 0, 0, 255, k);
                                b.set(3, 0, 0, 255, k);
                                b.set(4, 0, 0, 255, k);
                                b.set(5, 0, 0, 255, k);
                                b.set(6, 0, 0, 255, k);
                                b.set(7, 0, 0, 255, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-green":
                        jTextArea1.append("Running Green Pulse\n");
                        msgOut = ">> Green Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 0, 255, 0, j);
                                b.set(1, 0, 255, 0, j);
                                b.set(2, 0, 255, 0, j);
                                b.set(3, 0, 255, 0, j);
                                b.set(4, 0, 255, 0, j);
                                b.set(5, 0, 255, 0, j);
                                b.set(6, 0, 255, 0, j);
                                b.set(7, 0, 255, 0, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 0, 255, 0, k);
                                b.set(1, 0, 255, 0, k);
                                b.set(2, 0, 255, 0, k);
                                b.set(3, 0, 255, 0, k);
                                b.set(4, 0, 255, 0, k);
                                b.set(5, 0, 255, 0, k);
                                b.set(6, 0, 255, 0, k);
                                b.set(7, 0, 255, 0, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-yellow":
                        jTextArea1.append("Running Yellow Pulse\n");
                        msgOut = ">> Yellow Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 255, 255, 0, j);
                                b.set(1, 255, 255, 0, j);
                                b.set(2, 255, 255, 0, j);
                                b.set(3, 255, 255, 0, j);
                                b.set(4, 255, 255, 0, j);
                                b.set(5, 255, 255, 0, j);
                                b.set(6, 255, 255, 0, j);
                                b.set(7, 255, 255, 0, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 255, 255, 0, k);
                                b.set(1, 255, 255, 0, k);
                                b.set(2, 255, 255, 0, k);
                                b.set(3, 255, 255, 0, k);
                                b.set(4, 255, 255, 0, k);
                                b.set(5, 255, 255, 0, k);
                                b.set(6, 255, 255, 0, k);
                                b.set(7, 255, 255, 0, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-cyan":
                        jTextArea1.append("Running Cyan Pulse\n");
                        msgOut = ">> Cyan Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 0, 255, 255, j);
                                b.set(1, 0, 255, 255, j);
                                b.set(2, 0, 255, 255, j);
                                b.set(3, 0, 255, 255, j);
                                b.set(4, 0, 255, 255, j);
                                b.set(5, 0, 255, 255, j);
                                b.set(6, 0, 255, 255, j);
                                b.set(7, 0, 255, 255, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 0, 255, 255, k);
                                b.set(1, 0, 255, 255, k);
                                b.set(2, 0, 255, 255, k);
                                b.set(3, 0, 255, 255, k);
                                b.set(4, 0, 255, 255, k);
                                b.set(5, 0, 255, 255, k);
                                b.set(6, 0, 255, 255, k);
                                b.set(7, 0, 255, 255, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-magenta":
                        jTextArea1.append("Running Magenta Pulse\n");
                        msgOut = ">> Magenta Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 255, 0, 255, j);
                                b.set(1, 255, 0, 255, j);
                                b.set(2, 255, 0, 255, j);
                                b.set(3, 255, 0, 255, j);
                                b.set(4, 255, 0, 255, j);
                                b.set(5, 255, 0, 255, j);
                                b.set(6, 255, 0, 255, j);
                                b.set(7, 255, 0, 255, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 255, 0, 255, k);
                                b.set(1, 255, 0, 255, k);
                                b.set(2, 255, 0, 255, k);
                                b.set(3, 255, 0, 255, k);
                                b.set(4, 255, 0, 255, k);
                                b.set(5, 255, 0, 255, k);
                                b.set(6, 255, 0, 255, k);
                                b.set(7, 255, 0, 255, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "pulse-pink":
                        jTextArea1.append("Running Pink Pulse\n");
                        msgOut = ">> Pink Pulse Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 32; j++) {
                                b.set(0, 255, 20, 147, j);
                                b.set(1, 255, 20, 147, j);
                                b.set(2, 255, 20, 147, j);
                                b.set(3, 255, 20, 147, j);
                                b.set(4, 255, 20, 147, j);
                                b.set(5, 255, 20, 147, j);
                                b.set(6, 255, 20, 147, j);
                                b.set(7, 255, 20, 147, j);
                                b.show();
                                Thread.sleep(50);
                            }

                            for (int k = 31; k >= 0; k--) {
                                b.set(0, 255, 20, 147, k);
                                b.set(1, 255, 20, 147, k);
                                b.set(2, 255, 20, 147, k);
                                b.set(3, 255, 20, 147, k);
                                b.set(4, 255, 20, 147, k);
                                b.set(5, 255, 20, 147, k);
                                b.set(6, 255, 20, 147, k);
                                b.set(7, 255, 20, 147, k);
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "blink-cyan":
                        jTextArea1.append("Running Blink Cyan\n");
                        msgOut = ">> Blink Cyan Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 0, 255, 255, 30);
                            b.set(1, 0, 255, 255, 30);
                            b.set(2, 0, 255, 255, 30);
                            b.set(3, 0, 255, 255, 30);
                            b.set(4, 0, 255, 255, 30);
                            b.set(5, 0, 255, 255, 30);
                            b.set(6, 0, 255, 255, 30);
                            b.set(7, 0, 255, 255, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-magenta":
                        jTextArea1.append("Running Blink Magenta\n");
                        msgOut = ">> Blink Magenta Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 255, 0, 255, 30);
                            b.set(1, 255, 0, 255, 30);
                            b.set(2, 255, 0, 255, 30);
                            b.set(3, 255, 0, 255, 30);
                            b.set(4, 255, 0, 255, 30);
                            b.set(5, 255, 0, 255, 30);
                            b.set(6, 255, 0, 255, 30);
                            b.set(7, 255, 0, 255, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-pink":
                        jTextArea1.append("Running Blink Pink\n");
                        msgOut = ">> Blink Pink Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 255, 20, 147, 30);
                            b.set(1, 255, 20, 147, 30);
                            b.set(2, 255, 20, 147, 30);
                            b.set(3, 255, 20, 147, 30);
                            b.set(4, 255, 20, 147, 30);
                            b.set(5, 255, 20, 147, 30);
                            b.set(6, 255, 20, 147, 30);
                            b.set(7, 255, 20, 147, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-red":
                        jTextArea1.append("Running Blink Red\n");
                        msgOut = ">> Blink Red Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 255, 0, 0, 30);
                            b.set(1, 255, 0, 0, 30);
                            b.set(2, 255, 0, 0, 30);
                            b.set(3, 255, 0, 0, 30);
                            b.set(4, 255, 0, 0, 30);
                            b.set(5, 255, 0, 0, 30);
                            b.set(6, 255, 0, 0, 30);
                            b.set(7, 255, 0, 0, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-green":
                        jTextArea1.append("Running Blink Green\n");
                        msgOut = ">> Blink Green Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {    
                            b.set(0, 0, 255, 0, 30);
                            b.set(1, 0, 255, 0, 30);
                            b.set(2, 0, 255, 0, 30);
                            b.set(3, 0, 255, 0, 30);
                            b.set(4, 0, 255, 0, 30);
                            b.set(5, 0, 255, 0, 30);
                            b.set(6, 0, 255, 0, 30);
                            b.set(7, 0, 255, 0, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-blue":
                        jTextArea1.append("Running Blink Blue\n");
                        msgOut = ">> Blink Blue Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 0, 0, 255, 30);
                            b.set(1, 0, 0, 255, 30);
                            b.set(2, 0, 0, 255, 30);
                            b.set(3, 0, 0, 255, 30);
                            b.set(4, 0, 0, 255, 30);
                            b.set(5, 0, 0, 255, 30);
                            b.set(6, 0, 0, 255, 30);
                            b.set(7, 0, 0, 255, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-yellow":
                        jTextArea1.append("Running Blink Yellow\n");
                        msgOut = ">> Blink Yellow Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 255, 255, 0, 30);
                            b.set(1, 255, 255, 0, 30);
                            b.set(2, 255, 255, 0, 30);
                            b.set(3, 255, 255, 0, 30);
                            b.set(4, 255, 255, 0, 30);
                            b.set(5, 255, 255, 0, 30);
                            b.set(6, 255, 255, 0, 30);
                            b.set(7, 255, 255, 0, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-purple":
                        jTextArea1.append("Running Blink Purple\n");
                        msgOut = ">> Blink Purple Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 128, 0, 128, 30);
                            b.set(1, 128, 0, 128, 30);
                            b.set(2, 128, 0, 128, 30);
                            b.set(3, 128, 0, 128, 30);
                            b.set(4, 128, 0, 128, 30);
                            b.set(5, 128, 0, 128, 30);
                            b.set(6, 128, 0, 128, 30);
                            b.set(7, 128, 0, 128, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "blink-white":
                        jTextArea1.append("Running Blink White\n");
                        msgOut = ">> Blink White Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        for (int i = 0; i < 10; i++) {
                            b.set(0, 255, 255, 255, 30);
                            b.set(1, 255, 255, 255, 30);
                            b.set(2, 255, 255, 255, 30);
                            b.set(3, 255, 255, 255, 30);
                            b.set(4, 255, 255, 255, 30);
                            b.set(5, 255, 255, 255, 30);
                            b.set(6, 255, 255, 255, 30);
                            b.set(7, 255, 255, 255, 30);
                            b.show();
                            Thread.sleep(200);
                            b.setOff();
                            Thread.sleep(200);
                        }
                        b.setOff();
                        break;
                    case "solid-red":
                        jTextArea1.append("Running Solid Red\n");
                        msgOut = ">> Solid Red Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 255, 0, 0, 30);
                        b.set(1, 255, 0, 0, 30);
                        b.set(2, 255, 0, 0, 30);
                        b.set(3, 255, 0, 0, 30);
                        b.set(4, 255, 0, 0, 30);
                        b.set(5, 255, 0, 0, 30);
                        b.set(6, 255, 0, 0, 30);
                        b.set(7, 255, 0, 0, 30);
                        b.show();
                        break;
                    case "solid-cyan":
                        jTextArea1.append("Running Solid Cyan\n");
                        msgOut = ">> Solid Cyan Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 0, 255, 255, 30);
                        b.set(1, 0, 255, 255, 30);
                        b.set(2, 0, 255, 255, 30);
                        b.set(3, 0, 255, 255, 30);
                        b.set(4, 0, 255, 255, 30);
                        b.set(5, 0, 255, 255, 30);
                        b.set(6, 0, 255, 255, 30);
                        b.set(7, 0, 255, 255, 30);
                        b.show();
                        break;
                    case "solid-magenta":
                        jTextArea1.append("Running Solid Magenta\n");
                        msgOut = ">> Solid Magenta Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 255, 0, 255, 30);
                        b.set(1, 255, 0, 255, 30);
                        b.set(2, 255, 0, 255, 30);
                        b.set(3, 255, 0, 255, 30);
                        b.set(4, 255, 0, 255, 30);
                        b.set(5, 255, 0, 255, 30);
                        b.set(6, 255, 0, 255, 30);
                        b.set(7, 255, 0, 255, 30);
                        b.show();
                        break;
                    case "solid-pink":
                        jTextArea1.append("Running Solid Pink\n");
                        msgOut = ">> Solid Pink Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 255, 20, 147, 30);
                        b.set(1, 255, 20, 147, 30);
                        b.set(2, 255, 20, 147, 30);
                        b.set(3, 255, 20, 147, 30);
                        b.set(4, 255, 20, 147, 30);
                        b.set(5, 255, 20, 147, 30);
                        b.set(6, 255, 20, 147, 30);
                        b.set(7, 255, 20, 147, 30);
                        b.show();
                        break;
                    case "solid-green":
                        jTextArea1.append("Running Solid Green\n");
                        msgOut = ">> Solid Green Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 0, 255, 0, 30);
                        b.set(1, 0, 255, 0, 30);
                        b.set(2, 0, 255, 0, 30);
                        b.set(3, 0, 255, 0, 30);
                        b.set(4, 0, 255, 0, 30);
                        b.set(5, 0, 255, 0, 30);
                        b.set(6, 0, 255, 0, 30);
                        b.set(7, 0, 255, 0, 30);
                        b.show();    
                        break;
                    case "solid-blue":
                        jTextArea1.append("Running Solid Blue\n");
                        msgOut = ">> Solid Blue Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 0, 0, 255, 30);
                        b.set(1, 0, 0, 255, 30);
                        b.set(2, 0, 0, 255, 30);
                        b.set(3, 0, 0, 255, 30);
                        b.set(4, 0, 0, 255, 30);
                        b.set(5, 0, 0, 255, 30);
                        b.set(6, 0, 0, 255, 30);
                        b.set(7, 0, 0, 255, 30);
                        b.show();
                        break;
                    case "solid-yellow":
                        jTextArea1.append("Running Solid Yellow\n");
                        msgOut = ">> Solid Yellow Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 255, 255, 0, 30);
                        b.set(1, 255, 255, 0, 30);
                        b.set(2, 255, 255, 0, 30);
                        b.set(3, 255, 255, 0, 30);
                        b.set(4, 255, 255, 0, 30);
                        b.set(5, 255, 255, 0, 30);
                        b.set(6, 255, 255, 0, 30);
                        b.set(7, 255, 255, 0, 30);
                        b.show();
                        break;
                    case "solid-purple":
                        jTextArea1.append("Running Solid Purple\n");
                        msgOut = ">> Solid Purple Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 128, 0, 128, 30);
                        b.set(1, 128, 0, 128, 30);
                        b.set(2, 128, 0, 128, 30);
                        b.set(3, 128, 0, 128, 30);
                        b.set(4, 128, 0, 128, 30);
                        b.set(5, 128, 0, 128, 30);
                        b.set(6, 128, 0, 128, 30);
                        b.set(7, 128, 0, 128, 30);
                        b.show();
                        break;
                    case "solid-white":
                        jTextArea1.append("Running Solid White\n");
                        msgOut = ">> Solid White Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.set(0, 255, 255, 255, 30);
                        b.set(1, 255, 255, 255, 30);
                        b.set(2, 255, 255, 255, 30);
                        b.set(3, 255, 255, 255, 30);
                        b.set(4, 255, 255, 255, 30);
                        b.set(5, 255, 255, 255, 30);
                        b.set(6, 255, 255, 255, 30);
                        b.set(7, 255, 255, 255, 30);
                        b.show();
                        break;
                    case "seq-red":
                        jTextArea1.append("Running Sequence Red\n");
                        msgOut = ">> Sequence Red Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 255, 0, 0, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-green":
                        jTextArea1.append("Running Sequence Green\n");
                        msgOut = ">> Sequence Green Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 0, 255, 0, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-blue":
                        jTextArea1.append("Running Sequence Blue\n");
                        msgOut = ">> Sequence Blue Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 0, 0, 255, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-yellow":
                        jTextArea1.append("Running Sequence Yellow\n");
                        msgOut = ">> Sequence Yellow Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 255, 255, 0, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-white":
                        jTextArea1.append("Running Sequence White\n");
                        msgOut = ">> Sequence White Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 255, 255, 255, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-purple":
                        jTextArea1.append("Running Sequence Purple\n");
                        msgOut = ">> Sequence Purple Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 128, 0, 128, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-cyan":
                        jTextArea1.append("Running Sequence Cyan\n");
                        msgOut = ">> Sequence Cyan Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 0, 255, 255, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-magenta":
                        jTextArea1.append("Running Sequence Magenta\n");
                        msgOut = ">> Sequence Magenta Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 255, 0, 255, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-pink":
                        jTextArea1.append("Running Sequence Pink\n");
                        msgOut = ">> Sequence Pink Command Received";
                        dataOut.writeUTF(msgOut);
                            
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set (j, 255, 20, 147, 30);
                                b.show ();
                                Thread.sleep (200);
                                b.setOff();
                                b.show ();
                                Thread.sleep (50);
                            }
                        }
                        b.setOff();
                        break;
                    case "clear":
                        jTextArea1.append("Clearing LEDs\n");
                        msgOut = ">> Clear LEDs Command Received";
                        dataOut.writeUTF(msgOut);
                        
                        b.setOff();
                        break;
                    default:
                        jTextArea1.append("Command Not Recognized.\n");
                        msgOut = "Unknown Command: " + msgIn;
                        dataOut.writeUTF(msgOut);
                        
                        break;    
                }
            } 
        } catch(Exception e) {
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearLogBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
