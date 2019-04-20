package NetPiLight.Commands;

import NetPiLight.Blinkt;
import NetPiLight.Graphics.ColourMatrixDemo;
import NetPiLight.Command;
import java.io.IOException;

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
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (InterruptedException ex) {

        }
    }
}
