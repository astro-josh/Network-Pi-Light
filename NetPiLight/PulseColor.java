package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import java.awt.Color;

/**
 *
 * @author Joshua Alexander
 */
public class PulseColor implements Command {

    private final Blinkt b;
    private final int rgb, r, g, bl;

    public PulseColor(Blinkt b, Color c) {
        this.b = b;
        rgb = c.getRGB();
        r = rgb >> 16 & 0xFF;
        g = rgb >> 8 & 0xFF;
        bl = rgb & 0XFF;
    }

    @Override
    public String execute() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 32; j++) {
                b.set(0, r, g, bl, j);
                b.set(1, r, g, bl, j);
                b.set(2, r, g, bl, j);
                b.set(3, r, g, bl, j);
                b.set(4, r, g, bl, j);
                b.set(5, r, g, bl, j);
                b.set(6, r, g, bl, j);
                b.set(7, r, g, bl, j);
                b.show();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }

            for (int k = 31; k >= 0; k--) {
                b.set(0, r, g, bl, k);
                b.set(1, r, g, bl, k);
                b.set(2, r, g, bl, k);
                b.set(3, r, g, bl, k);
                b.set(4, r, g, bl, k);
                b.set(5, r, g, bl, k);
                b.set(6, r, g, bl, k);
                b.set(7, r, g, bl, k);
                b.show();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }
        }
        b.setOff();

        return String.format("Running Pulse Color - R: %s G: %s B: %s", r, g, bl);
    }

}
