package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JTextArea;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joshua Alexander
 */
public class ServerTest {

    private final int PORT = 9001;
    private Socket s;
    private Server server;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private final ExecutorService pool = Executors.newFixedThreadPool(5);

    public ServerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        pool.shutdown();
    }

    /**
     * Test of start method, of class Server.
     *
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testStart() throws IOException, InterruptedException {
        String actualMessage;
        JTextArea serverTextArea = new JTextArea();
        server = new Server(new Blinkt(true), PORT, serverTextArea);

        pool.execute(() -> {
            server.start();
        });

        s = new Socket("127.0.0.1", PORT);
        dataIn = new DataInputStream(s.getInputStream());
        dataOut = new DataOutputStream(s.getOutputStream());

        actualMessage = dataIn.readUTF();
        Assert.assertEquals("Server: Connected", actualMessage);
        serverTextArea.setText("");
        
        dataOut.writeUTF("pulse-red");
        Thread.sleep(1000);
        System.out.print(serverTextArea.getText());
        s.close();
    }
    
    /**
     * Test of sending commands, of class Server.
     */
    @Test
    public void testValidCommands() {
        // array of commands, array of responses from commands in jtextarea
    }

    /**
     * Test of finalize method, of class Server.
     */
    @Test
    public void testInvalidCommands() {
        // test an unknow command
    }

}
