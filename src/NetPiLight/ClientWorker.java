package NetPiLight;

import NetPiLight.Commands.*;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua Alexander
 */
class ClientWorker implements Runnable {

    private Runnable cmd;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Future future;
    private final Socket client;
    private final JTextArea textArea;
    private final Blinkt blinkt;
    private final Color PURPLE = new Color(128, 0, 128);
    private final ExecutorService pool = Executors.newSingleThreadExecutor();

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
            System.out.println(ex);
            ex.printStackTrace();
            System.exit(-1);
        }

        while (!client.isClosed()) {
            try {
                if (dataIn.available() > 0) {
                    String msg = dataIn.readUTF();
                    textArea.append("Client: " + msg + "\n");
                    invoke(msg);
                }
            } catch (IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
                break;
            }
        }
    }

    private void invoke(String msgIn) throws IOException {
        if (future != null && !future.isDone()) {
            future.cancel(true);
            //Thread.currentThread().interrupt();
            System.out.println("interrupt");
        }

        switch (msgIn) {
            case "rainbow":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Rainbow\n");
                });
                dataOut.writeUTF("Server: Running Rainbow");
                cmd = new Rainbow(blinkt);
                break;
            case "rainbow-fade":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Rainbow Fade\n");
                });
                dataOut.writeUTF("Server: Running Rainbow Fade");
                cmd = new RainbowFade(blinkt);
                break;
            case "rgb-bounce":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running RGB Bounce\n");
                });
                dataOut.writeUTF("Server: Running RGB Bounce");
                cmd = new RGBBounce(blinkt);
                break;
            case "pulse-white":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse White\n");
                });
                dataOut.writeUTF("Server: Running Pulse White");
                cmd = new PulseColor(blinkt, Color.white);
                break;
            case "pulse-purple":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Purple\n");
                });
                dataOut.writeUTF("Server: Running Pulse Purple");
                cmd = new PulseColor(blinkt, PURPLE);
                break;
            case "pulse-red":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Red\n");
                });
                dataOut.writeUTF("Server: Running Pulse Red");
                cmd = new PulseColor(blinkt, Color.red);
                break;
            case "pulse-blue":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Blue\n");
                });
                dataOut.writeUTF("Server: Running Pusle Blue");
                cmd = new PulseColor(blinkt, Color.blue);
                break;
            case "pulse-green":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Green\n");
                });
                dataOut.writeUTF("Server: Running Pulse Green");
                cmd = new PulseColor(blinkt, Color.green);
                break;
            case "pulse-yellow":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Yellow\n");
                });
                dataOut.writeUTF("Server: Running Pulse Yellow");
                cmd = new PulseColor(blinkt, Color.yellow);
                break;
            case "pulse-cyan":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Cyan\n");
                });
                dataOut.writeUTF("Server: Running Pulse Cyan");
                cmd = new PulseColor(blinkt, Color.cyan);
                break;
            case "pulse-magenta":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Magenta\n");
                });
                dataOut.writeUTF("Server: Running Pulse Magenta");
                cmd = new PulseColor(blinkt, Color.magenta);
                break;
            case "pulse-pink":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Pulse Pink\n");
                });
                dataOut.writeUTF("Server: Running Pulse Pink");
                cmd = new PulseColor(blinkt, Color.pink);
                break;
            case "blink-cyan":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Cyan\n");
                });
                dataOut.writeUTF("Server: Running Blink Cyan");
                cmd = new BlinkColor(blinkt, Color.cyan);
                break;
            case "blink-magenta":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Magenta\n");
                });
                dataOut.writeUTF("Server: Running Blink Magenta");
                cmd = new BlinkColor(blinkt, Color.magenta);
                break;
            case "blink-pink":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Pink\n");
                });
                dataOut.writeUTF("Server: Running Blink Pink");
                cmd = new BlinkColor(blinkt, Color.pink);
                break;
            case "blink-red":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Red\n");
                });
                dataOut.writeUTF("Server: Running Blink Red");
                cmd = new BlinkColor(blinkt, Color.red);
                break;
            case "blink-green":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Green\n");
                });
                dataOut.writeUTF("Server: Running Blink Green");
                cmd = new BlinkColor(blinkt, Color.green);
                break;
            case "blink-blue":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Blue\n");
                });
                dataOut.writeUTF("Server: Running Blink Blue");
                cmd = new BlinkColor(blinkt, Color.blue);
                break;
            case "blink-yellow":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Yellow\n");
                });
                dataOut.writeUTF("Server: Running Blink Yellow");
                cmd = new BlinkColor(blinkt, Color.yellow);
                break;
            case "blink-purple":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink Purple\n");
                });
                dataOut.writeUTF("Server: Running Blink Purple");
                cmd = new BlinkColor(blinkt, PURPLE);
                break;
            case "blink-white":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Blink White\n");
                });
                dataOut.writeUTF("Server: Running Blink White");
                cmd = new PulseColor(blinkt, Color.white);
                break;
            case "solid-red":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Red\n");
                });
                dataOut.writeUTF("Server: Running Solid Red");
                cmd = new SolidColor(blinkt, Color.red);
                break;
            case "solid-cyan":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Cyan\n");
                });
                dataOut.writeUTF("Server: Running Solid Cyan");
                cmd = new SolidColor(blinkt, Color.cyan);
                break;
            case "solid-magenta":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Magenta\n");
                });
                dataOut.writeUTF("Server: Running Solid Magenta");
                cmd = new SolidColor(blinkt, Color.magenta);
                break;
            case "solid-pink":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Pink\n");
                });
                dataOut.writeUTF("Server: Running Solid Pink");
                cmd = new SolidColor(blinkt, Color.pink);
                break;
            case "solid-green":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Green\n");
                });
                dataOut.writeUTF("Server: Running Solid Green");
                cmd = new SolidColor(blinkt, Color.green);
                break;
            case "solid-blue":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Blue\n");
                });
                dataOut.writeUTF("Server: Running Solid Blue");
                cmd = new SolidColor(blinkt, Color.blue);
                break;
            case "solid-yellow":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Yellow\n");
                });
                dataOut.writeUTF("Server: Running Solid Yellow");
                cmd = new SolidColor(blinkt, Color.yellow);
                break;
            case "solid-purple":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid Purple\n");
                });
                dataOut.writeUTF("Server: Running Solid Purple");
                cmd = new SolidColor(blinkt, PURPLE);
                break;
            case "solid-white":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Solid White\n");
                });
                dataOut.writeUTF("Server: Running Solid White");
                cmd = new SolidColor(blinkt, Color.white);
                break;
            case "seq-red":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Red\n");
                });
                dataOut.writeUTF("Server: Running Sequence Red");
                cmd = new SequenceColor(blinkt, Color.red);
                break;
            case "seq-green":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Green\n");
                });
                dataOut.writeUTF("Server: Running Sequence Green");
                cmd = new SequenceColor(blinkt, Color.green);
                break;
            case "seq-blue":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Blue\n");
                });
                dataOut.writeUTF("Server: Running Sequence Blue");
                cmd = new SequenceColor(blinkt, Color.blue);
                break;
            case "seq-yellow":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Yellow\n");
                });
                dataOut.writeUTF("Server: Running Sequence Yellow");
                cmd = new SequenceColor(blinkt, Color.yellow);
                break;
            case "seq-white":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence White\n");
                });
                dataOut.writeUTF("Server: Running Sequence White");
                cmd = new SequenceColor(blinkt, Color.white);
                break;
            case "seq-purple":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Purple\n");
                });
                dataOut.writeUTF("Server: Running Sequence Purple");
                cmd = new SequenceColor(blinkt, PURPLE);
                break;
            case "seq-cyan":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Cyan\n");
                });
                dataOut.writeUTF("Server: Running Sequence Cyan");
                cmd = new SequenceColor(blinkt, Color.cyan);
                break;
            case "seq-magenta":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Magenta\n");
                });
                dataOut.writeUTF("Server: Running Sequence Magenta");
                cmd = new SequenceColor(blinkt, Color.magenta);
                break;
            case "seq-pink":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Running Sequence Pink\n");
                });
                dataOut.writeUTF("Server: Running Sequence Pink");
                cmd = new SequenceColor(blinkt, Color.pink);
                break;
            case "clear":
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Clearing LEDs\n");
                });
                dataOut.writeUTF("Server: Clearing LEDs");
                blinkt.setOff();
                break;
            default:
                java.awt.EventQueue.invokeLater(() -> {
                    textArea.append("Command Not Recognized.\n");
                });
                dataOut.writeUTF("Server: Command Not Recognized");
                break;
        }
        if (cmd != null) {
            future = pool.submit(cmd);
        }
    }
}
