package NetPiLight;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import javax.swing.JTextArea;

/**
 *
 * @author Joshua Alexander
 */
public class Server {

    private final ServerSocket server;
    private final JTextArea jta;
    private final Blinkt blinkt;

    public Server(Blinkt blinkt, int port, JTextArea jta) throws IOException {
        this.jta = jta;
        this.blinkt = blinkt;
        this.server = new ServerSocket(port);
    }

    public void start() {
        ClientWorker worker;
        while (!server.isClosed()) {
            try {
                worker = new ClientWorker(server.accept(), jta, blinkt);
                Thread t = new Thread(worker);
                t.start();
            } catch (SocketException ex) {
                System.out.println("Connection Closed");
            } catch (IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
                break;
            }
        }
    }

    @Override
    protected void finalize() {
        try {
            server.close();
        } catch (IOException ex) {
            System.out.println("Could not close socket");
            ex.printStackTrace();
        }
    }
}
