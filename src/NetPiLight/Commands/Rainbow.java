package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.ColourMatrixDemo;
import NetPiLight.Command;
import java.io.IOException;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Joshua Alexander
 */
public class Rainbow implements Command, Runnable {

    private final Blinkt blinkt;

    public Rainbow(Blinkt b) {
        blinkt = b;
    }

    @Override
    public void run() {
        try {
            ColourMatrixDemo.run(this.blinkt);
        } catch (InterruptedException | IOException ex) {

        }
    }

}
