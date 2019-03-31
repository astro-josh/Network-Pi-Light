package NetPiLight;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joshua Alexander
 */
public class InvokerTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class Invoker.
     */
    @Test
    public void testStart() {
        int PORT = 9001;
        String address = "127.0.0.1";
        
        System.out.println("testing start");
        Invoker instance = new Invoker();
        instance.start(PORT);
                
        

    }
    
}
