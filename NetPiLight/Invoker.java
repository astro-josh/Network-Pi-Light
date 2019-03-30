package NetPiLight;

import NetPiLight.Commands.*;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
    private final Color PURPLE = new Color(128, 0, 128);

    public Invoker() {
        //b = new Blinkt();
    }

    public void start() {
        try {
            ss = new ServerSocket(9001); // The port to use.
            s = ss.accept(); // Accepts the connection on specified port.
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());
            Server.taAppend("Incoming Connection from: " + s.getRemoteSocketAddress() + "\n");
            dataOut.writeUTF("Server: Connected");

            msgIn = "";
            b = null;
            while (!msgIn.equals("exit")) {
                msgIn = dataIn.readUTF();

                switch (msgIn) {
                    case "rainbow":
                        Server.taAppend("Running Rainbow\n");
                        dataOut.writeUTF("Server: Running Rainbow");
                        cmd = new Rainbow(b);
                        cmd.execute();
                        break;
                    case "rainbow-fade":
                        Server.taAppend("Running Rainbow Fade\n");
                        cmd = new RainbowFade(b);
                        cmd.execute();
                        break;
                    case "rgb-bounce":
                        Server.taAppend("Running RGB Bounce\n");
                        cmd = new RGBBounce(b);
                        cmd.execute();
                        break;
                    case "pulse-white":
                        Server.taAppend("Running White Pulse\n");
                        cmd = new PulseColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "pulse-purple":
                        Server.taAppend("Running Purple Pulse\n");
                        cmd = new PulseColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "pulse-red":
                        Server.taAppend("Running Red Pulse\n");
                        cmd = new PulseColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "pulse-blue":
                        Server.taAppend("Running Blue Pulse\n");
                        cmd = new PulseColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "pulse-green":
                        Server.taAppend("Running Green Pulse\n");
                        cmd = new PulseColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "pulse-yellow":
                        Server.taAppend("Running Yellow Pulse\n");
                        cmd = new PulseColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "pulse-cyan":
                        Server.taAppend("Running Cyan Pulse\n");
                        cmd = new PulseColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "pulse-magenta":
                        Server.taAppend("Running Magenta Pulse\n");
                        cmd = new PulseColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "pulse-pink":
                        Server.taAppend("Running Pink Pulse\n");
                        cmd = new PulseColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "blink-cyan":
                        Server.taAppend("Running Blink Cyan\n");
                        cmd = new BlinkColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "blink-magenta":
                        Server.taAppend("Running Blink Magenta\n");
                        cmd = new BlinkColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "blink-pink":
                        Server.taAppend("Running Blink Pink\n");
                        cmd = new BlinkColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "blink-red":
                        Server.taAppend("Running Blink Red\n");
                        cmd = new BlinkColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "blink-green":
                        Server.taAppend("Running Blink Green\n");
                        cmd = new BlinkColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "blink-blue":
                        Server.taAppend("Running Blink Blue\n");
                        cmd = new BlinkColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "blink-yellow":
                        Server.taAppend("Running Blink Yellow\n");
                        cmd = new BlinkColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "blink-purple":
                        Server.taAppend("Running Blink Purple\n");
                        cmd = new BlinkColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "blink-white":
                        Server.taAppend("Running Blink White\n");
                        cmd = new PulseColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "solid-red":
                        Server.taAppend("Running Solid Red\n");
                        cmd = new SolidColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "solid-cyan":
                        Server.taAppend("Running Solid Cyan\n");
                        cmd = new SolidColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "solid-magenta":
                        Server.taAppend("Running Solid Magenta\n");
                        cmd = new SolidColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "solid-pink":
                        Server.taAppend("Running Solid Pink\n");
                        cmd = new SolidColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "solid-green":
                        Server.taAppend("Running Solid Green\n");
                        cmd = new SolidColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "solid-blue":
                        Server.taAppend("Running Solid Blue\n");
                        cmd = new SolidColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "solid-yellow":
                        Server.taAppend("Running Solid Yellow\n");
                        cmd = new SolidColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "solid-purple":
                        Server.taAppend("Running Solid Purple\n");
                        cmd = new SolidColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "solid-white":
                        Server.taAppend("Running Solid White\n");
                        cmd = new SolidColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "seq-red":
                        Server.taAppend("Running Sequence Red\n");
                        cmd = new SequenceColor(b, Color.red);
                        cmd.execute();
                        break;
                    case "seq-green":
                        Server.taAppend("Running Sequence Green\n");
                        cmd = new SequenceColor(b, Color.green);
                        cmd.execute();
                        break;
                    case "seq-blue":
                        Server.taAppend("Running Sequence Blue\n");
                        cmd = new SequenceColor(b, Color.blue);
                        cmd.execute();
                        break;
                    case "seq-yellow":
                        Server.taAppend("Running Sequence Yellow\n");
                        cmd = new SequenceColor(b, Color.yellow);
                        cmd.execute();
                        break;
                    case "seq-white":
                        Server.taAppend("Running Sequence White\n");
                        cmd = new SequenceColor(b, Color.white);
                        cmd.execute();
                        break;
                    case "seq-purple":
                        Server.taAppend("Running Sequence Purple\n");
                        cmd = new SequenceColor(b, PURPLE);
                        cmd.execute();
                        break;
                    case "seq-cyan":
                        Server.taAppend("Running Sequence Cyan\n");
                        cmd = new SequenceColor(b, Color.cyan);
                        cmd.execute();
                        break;
                    case "seq-magenta":
                        Server.taAppend("Running Sequence Magenta\n");
                        cmd = new SequenceColor(b, Color.magenta);
                        cmd.execute();
                        break;
                    case "seq-pink":
                        Server.taAppend("Running Sequence Pink\n");
                        cmd = new SequenceColor(b, Color.pink);
                        cmd.execute();
                        break;
                    case "clear":
                        Server.taAppend("Clearing LEDs\n");
                        b.setOff();
                        break;
                    default:
                        Server.taAppend("Command Not Recognized.\n");
                        break;
                }

            }
        } catch (IOException e) {

        }
    }
}
