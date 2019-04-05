package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua Alexander
 */
public class Server {

    private final ServerSocket server;
    private final JTextArea jta;
    private final Blinkt blinkt;
    private final Color PURPLE = new Color(128, 0, 128);

    public Server(Blinkt blinkt, int port, JTextArea jta) throws IOException {
        this.jta = jta;
        this.blinkt = blinkt;
        this.server = new ServerSocket(port);
    }

    public void start() {
        ClientWorker worker;
        while (true) {
            try {
                worker = new ClientWorker(server.accept(), jta, blinkt);
                Thread t = new Thread(worker);
                t.start();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    protected void finalize() {
        try {
            server.close();
        } catch (IOException ex) {
            System.out.println("Could not close socket");
        }
    }
}
