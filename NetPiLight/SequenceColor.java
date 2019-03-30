package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import java.awt.Color;

/**
 *
 * @author Joshua Alexander
 */
public class SequenceColor implements Command {

    private final Blinkt b;
    private final int rgb, r, g, bl;

    public SequenceColor(Blinkt b, Color c) {
        this.b = b;
        rgb = c.getRGB();
        r = rgb >> 16 & 0xFF;
        g = rgb >> 8 & 0xFF;
        bl = rgb & 0XFF;
    }

    @Override
    public String execute() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; ++j) {
                b.set(j, r, g, bl, 30);
                b.show();
                try {
                    Thread.sleep(200);
                    b.setOff();
                    b.show();
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }
        }
        b.setOff();

        return String.format("Running Solid Color - R: %s G: %s B: %s", r, g, bl);
    }
}
