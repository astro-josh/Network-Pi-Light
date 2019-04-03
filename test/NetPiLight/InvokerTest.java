package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joshua Alexander
 */
public class InvokerTest {

    private final int PORT = 9002;
    private final String ADDRESS = "127.0.0.1";
    private Socket s;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private JTextArea jta;

    public InvokerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        jta = new JTextArea();
        Invoker invoker = new Invoker(new Blinkt(true), PORT, jta);
        invoker.run();
        
        try {
            s = new Socket(ADDRESS, PORT);
            dataIn = new DataInputStream(s.getInputStream());
            dataOut = new DataOutputStream(s.getOutputStream());
        } catch (IOException ex) {
            fail("Failed to create test socket.");
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class Invoker.
     */
    @Test
    public void testStart() {
        try {
            System.out.println(this.jta.getText());
            assertEquals("Server: Connected", dataIn.readUTF());
        } catch (IOException ex) {
            fail("IO Exception");
        }
    }

    /**
     * Test of blink command.
     */
    @Test
    public void testBlinkCommand() {
        try {
            dataIn.readUTF();
            dataOut.writeUTF("pulse-red");
                        System.out.println(this.jta.getText());
            assertEquals("Server: Connected", dataIn.readUTF());

        } catch (IOException ex) {
            fail("Failed to create test socket.");
        }
    }

}
