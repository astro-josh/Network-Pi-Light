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
    private final Blinkt b;
    
    public Rainbow(Blinkt b) {
        this.b = b;
    }

    @Override
    public String execute() {
        try {
            ColourMatrixDemo.run(this.b);
        } catch (InterruptedException | IOException ex) {

        }
        
        return "Running Rainbow.";
    }
    
}
