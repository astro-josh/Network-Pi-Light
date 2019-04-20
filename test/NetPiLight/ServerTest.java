package NetPiLight;

import NetPiLight.Jimbo.Boards.com.pimoroni.Blinkt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Joshua Alexander
 */
public class ServerTest {

    private Socket s;
    private Server server;
    private JTextArea serverTextArea;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private final int PORT = 9001;
    private final ExecutorService pool = Executors.newSingleThreadExecutor();

    public ServerTest() {
    }

    @Before
    public void setUp() throws IOException {
        serverTextArea = new JTextArea();
        server = new Server(new Blinkt(true), PORT, serverTextArea);

        pool.execute(() -> {
            server.start();
        });

        s = new Socket("127.0.0.1", PORT);
        dataIn = new DataInputStream(s.getInputStream());
        dataOut = new DataOutputStream(s.getOutputStream());
    }

    @After
    public void tearDown() throws IOException {
        s.close();
        server.finalize();
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
        System.out.println("\ntestStart");
        String actualMessage;

        actualMessage = dataIn.readUTF();
        Assert.assertEquals("Server: Connected", actualMessage);

        String expected = "Incoming Connection from: /127.0.0.1";
        Thread.sleep(1000);
        boolean isExpected = serverTextArea.getText().contains(expected);

        Assert.assertTrue(isExpected);
    }

    /**
     * Test of sending commands, of class Server.
     *
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testValidCommands() throws IOException, InterruptedException {
        System.out.println("\ntestValidCommands");

        Hashtable hash = new Hashtable();
        hash.put("pulse-red", "Incoming Connection from: /127.0.0.1(.*)\nClient: pulse-red\nRunning Pulse Red\n");
        hash.put("pulse-yellow", "Client: pulse-yellow\nRunning Pulse Yellow\n");
        hash.put("rgb-bounce", "Client: rgb-bounce\nRunning RGB Bounce\n");
        hash.put("blink-blue", "Client: blink-blue\nRunning Blink Blue\n");
        hash.put("solid-white", "Client: solid-white\nRunning Solid White\n");
        hash.put("seq-purple", "Client: seq-purple\nRunning Sequence Purple\n");
        hash.put("rainbow-fade", "Client: rainbow-fade\nRunning Rainbow Fade\n");

        Iterator it = hash.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            serverTextArea.setText("");
            dataOut.writeUTF(pair.getKey().toString());
            Thread.sleep(1000);

            Pattern pattern = Pattern.compile(pair.getValue().toString(), Pattern.DOTALL);
            Matcher matcher = pattern.matcher(serverTextArea.getText());
            boolean matchFound = matcher.matches();
            Assert.assertTrue(matchFound);
        }
    }

    /**
     * Test of finalize method, of class Server.
     *
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testInvalidCommand() throws IOException, InterruptedException {
        System.out.println("\ntestInvalidCommand");
        dataOut.writeUTF("invalid");
        Thread.sleep(1000);
        System.out.println(serverTextArea.getText());
        String expected = "Command Not Recognized.";
        String[] responses = serverTextArea.getText().split("\n");
        Assert.assertEquals(expected, responses[responses.length - 1]);
    }
}
