package NetPiLight;

import NetPiLight.Commands.*;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;
import Jimbo.Boards.com.pimoroni.Blinkt;

/**
 *
 * @author Joshua Alexander
 */
public class Invoker {

    private static Socket s;
    private static ServerSocket ss;
    private static DataInputStream dataIn;
    private static DataOutputStream dataOut;
    private static Blinkt b;
    private String msgIn;
    private Command cmd;
    private final JTextArea jta;
    private final Color PURPLE = new Color(128, 0, 128);

    public Invoker(JTextArea jta) {
        this.jta = jta;
        b = new Blinkt();
    }

    public void start() {
        try {
            ss = new ServerSocket(9001); // The port to use.
            s = ss.accept(); // Accepts the connection on specified port.
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());

            jta.append("Incoming Connection from: " + s.getRemoteSocketAddress() + "\n");

            msgIn = "";
            
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
                        cmd = new RGBBounce(b);
                        cmd.execute();
                        break;
                    case "pulse-white":
                        this.jta.append("Running White Pulse\n");
                        cmd = new PulseColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "pulse-purple":
                        this.jta.append("Running Purple Pulse\n");
                        cmd = new PulseColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "pulse-red":
                        this.jta.append("Running Red Pulse\n");
                        cmd = new PulseColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "pulse-blue":
                        this.jta.append("Running Blue Pulse\n");
                        cmd = new PulseColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "pulse-green":
                        this.jta.append("Running Green Pulse\n");
                        cmd = new PulseColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "pulse-yellow":
                        this.jta.append("Running Yellow Pulse\n");
                        cmd = new PulseColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "pulse-cyan":
                        this.jta.append("Running Cyan Pulse\n");
                        cmd = new PulseColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "pulse-magenta":
                        this.jta.append("Running Magenta Pulse\n");
                        cmd = new PulseColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "pulse-pink":
                        this.jta.append("Running Pink Pulse\n");
                        cmd = new PulseColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "blink-cyan":
                        this.jta.append("Running Blink Cyan\n");
                        cmd = new BlinkColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "blink-magenta":
                        this.jta.append("Running Blink Magenta\n");
                        cmd = new BlinkColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "blink-pink":
                        this.jta.append("Running Blink Pink\n");
                        cmd = new BlinkColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "blink-red":
                        this.jta.append("Running Blink Red\n");
                        cmd = new BlinkColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "blink-green":
                        this.jta.append("Running Blink Green\n");
                        cmd = new BlinkColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "blink-blue":
                        this.jta.append("Running Blink Blue\n");
                        cmd = new BlinkColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "blink-yellow":
                        this.jta.append("Running Blink Yellow\n");
                        cmd = new BlinkColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "blink-purple":
                        this.jta.append("Running Blink Purple\n");
                        cmd = new BlinkColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "blink-white":
                        this.jta.append("Running Blink White\n");
                        cmd = new PulseColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "solid-red":
                        this.jta.append("Running Solid Red\n");
                        cmd = new SolidColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "solid-cyan":
                        this.jta.append("Running Solid Cyan\n");
                        cmd = new SolidColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "solid-magenta":
                        this.jta.append("Running Solid Magenta\n");
                        cmd = new SolidColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "solid-pink":
                        this.jta.append("Running Solid Pink\n");
                        cmd = new SolidColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "solid-green":
                        this.jta.append("Running Solid Green\n");
                        cmd = new SolidColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "solid-blue":
                        this.jta.append("Running Solid Blue\n");
                        cmd = new SolidColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "solid-yellow":
                        this.jta.append("Running Solid Yellow\n");
                        cmd = new SolidColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "solid-purple":
                        this.jta.append("Running Solid Purple\n");
                        cmd = new SolidColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "solid-white":
                        this.jta.append("Running Solid White\n");
                        cmd = new SolidColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "seq-red":
                        this.jta.append("Running Sequence Red\n");
                        cmd = new SequenceColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "seq-green":
                        this.jta.append("Running Sequence Green\n");
                        cmd = new SequenceColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "seq-blue":
                        this.jta.append("Running Sequence Blue\n");
                        cmd = new SequenceColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "seq-yellow":
                        this.jta.append("Running Sequence Yellow\n");
                        cmd = new SequenceColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "seq-white":
                        this.jta.append("Running Sequence White\n");
                        cmd = new SequenceColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "seq-purple":
                        this.jta.append("Running Sequence Purple\n");
                        cmd = new SequenceColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "seq-cyan":
                        this.jta.append("Running Sequence Cyan\n");
                        cmd = new SequenceColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "seq-magenta":
                        this.jta.append("Running Sequence Magenta\n");
                        cmd = new SequenceColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "seq-pink":
                        this.jta.append("Running Sequence Pink\n");
                        cmd = new SequenceColor(b, Color.pink);
                        cmd.execute();
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

        }
    }
}
