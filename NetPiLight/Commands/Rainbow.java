package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.ColourMatrixDemo;
import NetPiLight.Command;
import java.io.IOException;

/**
 *
 * @author Joshua Alexander
 */
public class Rainbow implements Command {
    private final Blinkt blinkt;
    
    public Rainbow(Blinkt b) {
        blinkt = b;
    }

    @Override
    public String execute() {
        try {
            ColourMatrixDemo.run(this.blinkt);
        } catch (InterruptedException | IOException ex) {

        }
        
        return "Running Rainbow.";
    }
    
}
