package PiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.ColourMatrixDemo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joshua Alexander
 */
public class Rainbow implements Command {
    private final Blinkt b;
    
    public Rainbow(Blinkt b) {
        this.b = b;
    }

    @Override
    public String execute() {
        try {
            ColourMatrixDemo.run(this.b);
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Rainbow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Running Rainbow.";
    }
    
}
