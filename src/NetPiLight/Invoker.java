package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import NetPiLight.Commands.*;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua Alexander
 */
public class Invoker extends Thread {

    private static Socket s;
    private static ServerSocket ss;
    private static DataInputStream dataIn;
    private static DataOutputStream dataOut;
    private static Blinkt b;
    private String msgIn;
    private Command cmd;
    private final Color PURPLE = new Color(128, 0, 128);
    private final int port;
    private final JTextArea jta;

    public Invoker(int port, JTextArea jta) {
        //b = new Blinkt();
        this.port = port;
        this.jta = jta;
    }
    
    @Override
    public void run() {
        start(port);
    }

    private void start(int port) {
        try {
            ss = new ServerSocket(port); // The port to use.
            s = ss.accept(); // Accepts the connection on specified port.
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());
            jta.append("Incoming Connection from: " + s.getRemoteSocketAddress() + "\n");
            dataOut.writeUTF("Server: Connected");

            msgIn = "";
            b = null;
            while (!msgIn.equals("exit")) {
                msgIn = dataIn.readUTF();

                switch (msgIn) {
                    case "rainbow":
                        jta.append("Running Rainbow\n");
                        dataOut.writeUTF("Server: Running Rainbow");
                        cmd = new Rainbow(b);
                        cmd.execute();
                        break;
                    case "rainbow-fade":
                        jta.append("Running Rainbow Fade\n");
                        cmd = new RainbowFade(b);
                        cmd.execute();
                        break;
                    case "rgb-bounce":
                        jta.append("Running RGB Bounce\n");
                        cmd = new RGBBounce(b);
                        cmd.execute();
                        break;
                    case "pulse-white":
                        jta.append("Running White Pulse\n");
                        cmd = new PulseColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "pulse-purple":
                        jta.append("Running Purple Pulse\n");
                        cmd = new PulseColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "pulse-red":
                        jta.append("Running Red Pulse\n");
                        cmd = new PulseColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "pulse-blue":
                        jta.append("Running Blue Pulse\n");
                        cmd = new PulseColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "pulse-green":
                        jta.append("Running Green Pulse\n");
                        cmd = new PulseColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "pulse-yellow":
                        jta.append("Running Yellow Pulse\n");
                        cmd = new PulseColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "pulse-cyan":
                        jta.append("Running Cyan Pulse\n");
                        cmd = new PulseColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "pulse-magenta":
                        jta.append("Running Magenta Pulse\n");
                        cmd = new PulseColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "pulse-pink":
                        jta.append("Running Pink Pulse\n");
                        cmd = new PulseColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "blink-cyan":
                        jta.append("Running Blink Cyan\n");
                        cmd = new BlinkColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "blink-magenta":
                        jta.append("Running Blink Magenta\n");
                        cmd = new BlinkColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "blink-pink":
                        jta.append("Running Blink Pink\n");
                        cmd = new BlinkColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "blink-red":
                        jta.append("Running Blink Red\n");
                        cmd = new BlinkColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "blink-green":
                        jta.append("Running Blink Green\n");
                        cmd = new BlinkColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "blink-blue":
                        jta.append("Running Blink Blue\n");
                        cmd = new BlinkColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "blink-yellow":
                        jta.append("Running Blink Yellow\n");
                        cmd = new BlinkColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "blink-purple":
                        jta.append("Running Blink Purple\n");
                        cmd = new BlinkColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "blink-white":
                        jta.append("Running Blink White\n");
                        cmd = new PulseColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "solid-red":
                        jta.append("Running Solid Red\n");
                        cmd = new SolidColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "solid-cyan":
                        jta.append("Running Solid Cyan\n");
                        cmd = new SolidColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "solid-magenta":
                        jta.append("Running Solid Magenta\n");
                        cmd = new SolidColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "solid-pink":
                        jta.append("Running Solid Pink\n");
                        cmd = new SolidColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "solid-green":
                        jta.append("Running Solid Green\n");
                        cmd = new SolidColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "solid-blue":
                        jta.append("Running Solid Blue\n");
                        cmd = new SolidColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "solid-yellow":
                        jta.append("Running Solid Yellow\n");
                        cmd = new SolidColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "solid-purple":
                        jta.append("Running Solid Purple\n");
                        cmd = new SolidColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "solid-white":
                        jta.append("Running Solid White\n");
                        cmd = new SolidColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "seq-red":
                        jta.append("Running Sequence Red\n");
                        cmd = new SequenceColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "seq-green":
                        jta.append("Running Sequence Green\n");
                        cmd = new SequenceColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "seq-blue":
                        jta.append("Running Sequence Blue\n");
                        cmd = new SequenceColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "seq-yellow":
                        jta.append("Running Sequence Yellow\n");
                        cmd = new SequenceColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "seq-white":
                        jta.append("Running Sequence White\n");
                        cmd = new SequenceColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "seq-purple":
                        jta.append("Running Sequence Purple\n");
                        cmd = new SequenceColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "seq-cyan":
                        jta.append("Running Sequence Cyan\n");
                        cmd = new SequenceColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "seq-magenta":
                        jta.append("Running Sequence Magenta\n");
                        cmd = new SequenceColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "seq-pink":
                        jta.append("Running Sequence Pink\n");
                        cmd = new SequenceColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "clear":
                        jta.append("Clearing LEDs\n");
                        b.setOff();
                        break;
                    default:
                        jta.append("Command Not Recognized.\n");
                        break;
                }

            }
        } catch (IOException e) {

        }
    }
}
