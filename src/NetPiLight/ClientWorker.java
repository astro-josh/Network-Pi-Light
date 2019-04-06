package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import NetPiLight.Commands.*;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua Alexander
 */
class ClientWorker implements Runnable {

    private final Socket client;
    private final JTextArea textArea;
    private final Blinkt blinkt;
    private final Color PURPLE = new Color(128, 0, 128);
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Command cmd;

    ClientWorker(Socket client, JTextArea textArea, Blinkt blinkt) {
        this.client = client;
        this.textArea = textArea;
        this.blinkt = blinkt;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting Client Connection " + client);
            dataIn = new DataInputStream(client.getInputStream());
            dataOut = new DataOutputStream(client.getOutputStream());
            dataOut.writeUTF("Server: Connected");
            textArea.append("Incoming Connection from: " + client.getRemoteSocketAddress() + "\n");
        } catch (IOException ex) {
            System.out.println("I/O failed");
            System.exit(-1);
        }

        while (true) {
            try {
                String msg = dataIn.readUTF();
                textArea.append("Client: " + msg + "\n");
                invoke(msg);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    private void invoke(String msgIn) throws IOException {
        switch (msgIn) {
            case "rainbow":
                textArea.append("Running Rainbow\n");
                dataOut.writeUTF("Server: Running Rainbow");
                cmd = new Rainbow(blinkt);
                cmd.run();
                break;
            case "rainbow-fade":
                textArea.append("Running Rainbow Fade\n");
                cmd = new RainbowFade(blinkt);
                cmd.run();
                break;
            case "rgb-bounce":
                textArea.append("Running RGB Bounce\n");
                cmd = new RGBBounce(blinkt);
                cmd.run();
                break;
            case "pulse-white":
                textArea.append("Running White Pulse\n");
                cmd = new PulseColor(blinkt, Color.white);
                cmd.run();
                break;
            case "pulse-purple":
                textArea.append("Running Purple Pulse\n");
                cmd = new PulseColor(blinkt, PURPLE);
                cmd.run();
                break;
            case "pulse-red":
                textArea.append("Running Red Pulse\n");
                cmd = new PulseColor(blinkt, Color.red);
                cmd.run();
                break;
            case "pulse-blue":
                textArea.append("Running Blue Pulse\n");
                cmd = new PulseColor(blinkt, Color.blue);
                cmd.run();
                break;
            case "pulse-green":
                textArea.append("Running Green Pulse\n");
                cmd = new PulseColor(blinkt, Color.green);
                cmd.run();
                break;
            case "pulse-yellow":
                textArea.append("Running Yellow Pulse\n");
                cmd = new PulseColor(blinkt, Color.yellow);
                cmd.run();
                break;
            case "pulse-cyan":
                textArea.append("Running Cyan Pulse\n");
                cmd = new PulseColor(blinkt, Color.cyan);
                cmd.run();
                break;
            case "pulse-magenta":
                textArea.append("Running Magenta Pulse\n");
                cmd = new PulseColor(blinkt, Color.magenta);
                cmd.run();
                break;
            case "pulse-pink":
                textArea.append("Running Pink Pulse\n");
                cmd = new PulseColor(blinkt, Color.pink);
                cmd.run();
                break;
            case "blink-cyan":
                textArea.append("Running Blink Cyan\n");
                cmd = new BlinkColor(blinkt, Color.cyan);
                cmd.run();
                break;
            case "blink-magenta":
                textArea.append("Running Blink Magenta\n");
                cmd = new BlinkColor(blinkt, Color.magenta);
                cmd.run();
                break;
            case "blink-pink":
                textArea.append("Running Blink Pink\n");
                cmd = new BlinkColor(blinkt, Color.pink);
                cmd.run();
                break;
            case "blink-red":
                textArea.append("Running Blink Red\n");
                cmd = new BlinkColor(blinkt, Color.red);
                cmd.run();
                break;
            case "blink-green":
                textArea.append("Running Blink Green\n");
                cmd = new BlinkColor(blinkt, Color.green);
                cmd.run();
                break;
            case "blink-blue":
                textArea.append("Running Blink Blue\n");
                cmd = new BlinkColor(blinkt, Color.blue);
                cmd.run();
                break;
            case "blink-yellow":
                textArea.append("Running Blink Yellow\n");
                cmd = new BlinkColor(blinkt, Color.yellow);
                cmd.run();
                break;
            case "blink-purple":
                textArea.append("Running Blink Purple\n");
                cmd = new BlinkColor(blinkt, PURPLE);
                cmd.run();
                break;
            case "blink-white":
                textArea.append("Running Blink White\n");
                cmd = new PulseColor(blinkt, Color.white);
                cmd.run();
                break;
            case "solid-red":
                textArea.append("Running Solid Red\n");
                cmd = new SolidColor(blinkt, Color.red);
                cmd.run();
                break;
            case "solid-cyan":
                textArea.append("Running Solid Cyan\n");
                cmd = new SolidColor(blinkt, Color.cyan);
                cmd.run();
                break;
            case "solid-magenta":
                textArea.append("Running Solid Magenta\n");
                cmd = new SolidColor(blinkt, Color.magenta);
                cmd.run();
                break;
            case "solid-pink":
                textArea.append("Running Solid Pink\n");
                cmd = new SolidColor(blinkt, Color.pink);
                cmd.run();
                break;
            case "solid-green":
                textArea.append("Running Solid Green\n");
                cmd = new SolidColor(blinkt, Color.green);
                cmd.run();
                break;
            case "solid-blue":
                textArea.append("Running Solid Blue\n");
                cmd = new SolidColor(blinkt, Color.blue);
                cmd.run();
                break;
            case "solid-yellow":
                textArea.append("Running Solid Yellow\n");
                cmd = new SolidColor(blinkt, Color.yellow);
                cmd.run();
                break;
            case "solid-purple":
                textArea.append("Running Solid Purple\n");
                cmd = new SolidColor(blinkt, PURPLE);
                cmd.run();
                break;
            case "solid-white":
                textArea.append("Running Solid White\n");
                cmd = new SolidColor(blinkt, Color.white);
                cmd.run();
                break;
            case "seq-red":
                textArea.append("Running Sequence Red\n");
                cmd = new SequenceColor(blinkt, Color.red);
                cmd.run();
                break;
            case "seq-green":
                textArea.append("Running Sequence Green\n");
                cmd = new SequenceColor(blinkt, Color.green);
                cmd.run();
                break;
            case "seq-blue":
                textArea.append("Running Sequence Blue\n");
                cmd = new SequenceColor(blinkt, Color.blue);
                cmd.run();
                break;
            case "seq-yellow":
                textArea.append("Running Sequence Yellow\n");
                cmd = new SequenceColor(blinkt, Color.yellow);
                cmd.run();
                break;
            case "seq-white":
                textArea.append("Running Sequence White\n");
                cmd = new SequenceColor(blinkt, Color.white);
                cmd.run();
                break;
            case "seq-purple":
                textArea.append("Running Sequence Purple\n");
                cmd = new SequenceColor(blinkt, PURPLE);
                cmd.run();
                break;
            case "seq-cyan":
                textArea.append("Running Sequence Cyan\n");
                cmd = new SequenceColor(blinkt, Color.cyan);
                cmd.run();
                break;
            case "seq-magenta":
                textArea.append("Running Sequence Magenta\n");
                cmd = new SequenceColor(blinkt, Color.magenta);
                cmd.run();
                break;
            case "seq-pink":
                textArea.append("Running Sequence Pink\n");
                cmd = new SequenceColor(blinkt, Color.pink);
                cmd.run();
                break;
            case "clear":
                textArea.append("Clearing LEDs\n");
                blinkt.setOff();
                break;
            default:
                textArea.append("Command Not Recognized.\n");
                break;
        }
    }

}
