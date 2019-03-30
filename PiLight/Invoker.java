package PiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.Colour;
import Jimbo.Graphics.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua Alexander
 */
public class Invoker {

    private static ServerSocket ss;
    private static Socket s;
    private static DataInputStream dataIn;
    private static DataOutputStream dataOut;
    private static Blinkt b;
    private String msgIn;
    private Command cmd;
    private JTextArea jta;

    public Invoker(JTextArea jta) {
        b = new Blinkt();
        msgIn = "";
        this.jta = jta;
            
        try {
            ss = new ServerSocket(9001); // The port to use.
            s = ss.accept(); // Accepts the connection on specified port.
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());
            
            jta.append("Incoming Connection from: " + s.getRemoteSocketAddress() + "\n");

            while (!msgIn.equals("exit")) {
                msgIn = dataIn.readUTF();

                switch (msgIn) {
                    case "rainbow":
                        this.jta.append("Running Rainbow\n");
                        //dataOut.writeUTF(msgOut);
                        cmd = new Rainbow(b);
                        cmd.execute();
                        break;
                    case "rainbow-fade":
                        this.jta.append("Running Rainbow Fade\n");
                        cmd = new RainbowFade(b);
                        cmd.execute();
                        break;
                    case "rgb-bounce":
                        this.jta.append("Running RGB Bounce\n");

                        int phase = 0;
                        final double max_distance = 8;

                        for (int i = 0; i < 4; i++) {
                            for (int j = 0, k = 7; j < 8 && k >= 0; j++, k--) {
                                double fraction = j / max_distance;

                                double value1 = 360 * (1 - fraction) + phase;

                                if (value1 > 360) {
                                    value1 -= 360;
                                }

                                Colour c1 = new Colour(value1);

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
                        this.jta.append("Running White Pulse\n");

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
                        this.jta.append("Running Purple Pulse\n");

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
                        this.jta.append("Running Red Pulse\n");

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
                        this.jta.append("Running Blue Pulse\n");

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
                        this.jta.append("Running Green Pulse\n");

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
                        this.jta.append("Running Yellow Pulse\n");

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
                        this.jta.append("Running Cyan Pulse\n");

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
                        this.jta.append("Running Magenta Pulse\n");

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
                        this.jta.append("Running Pink Pulse\n");

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
                        this.jta.append("Running Blink Cyan\n");

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
                        this.jta.append("Running Blink Magenta\n");

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
                        this.jta.append("Running Blink Pink\n");

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
                        this.jta.append("Running Blink Red\n");

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
                        this.jta.append("Running Blink Green\n");

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
                        this.jta.append("Running Blink Blue\n");

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
                        this.jta.append("Running Blink Yellow\n");

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
                        this.jta.append("Running Blink Purple\n");

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
                        this.jta.append("Running Blink White\n");

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
                        this.jta.append("Running Solid Red\n");

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
                        this.jta.append("Running Solid Cyan\n");

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
                        this.jta.append("Running Solid Magenta\n");

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
                        this.jta.append("Running Solid Pink\n");

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
                        this.jta.append("Running Solid Green\n");

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
                        this.jta.append("Running Solid Blue\n");

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
                        this.jta.append("Running Solid Yellow\n");

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
                        this.jta.append("Running Solid Purple\n");

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
                        this.jta.append("Running Solid White\n");

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
                        this.jta.append("Running Sequence Red\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 255, 0, 0, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-green":
                        this.jta.append("Running Sequence Green\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 0, 255, 0, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-blue":
                        this.jta.append("Running Sequence Blue\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 0, 0, 255, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-yellow":
                        this.jta.append("Running Sequence Yellow\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 255, 255, 0, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-white":
                        this.jta.append("Running Sequence White\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 255, 255, 255, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-purple":
                        this.jta.append("Running Sequence Purple\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 128, 0, 128, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-cyan":
                        this.jta.append("Running Sequence Cyan\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 0, 255, 255, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-magenta":
                        this.jta.append("Running Sequence Magenta\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 255, 0, 255, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "seq-pink":
                        this.jta.append("Running Sequence Pink\n");

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 8; ++j) {
                                b.set(j, 255, 20, 147, 30);
                                b.show();
                                Thread.sleep(200);
                                b.setOff();
                                b.show();
                                Thread.sleep(50);
                            }
                        }
                        b.setOff();
                        break;
                    case "clear":
                        this.jta.append("Clearing LEDs\n");

                        b.setOff();
                        break;
                    default:
                        this.jta.append("Command Not Recognized.\n");

                        break;
                }

            }
        } catch (IOException e) {

        } catch (InterruptedException ex) {
            Logger.getLogger(Invoker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
