package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import NetPiLight.Command;
import java.awt.Color;

/**
 *
 * @author Joshua Alexander
 */
public class PulseColor implements Command {

    private final Blinkt blinkt;
    private final int rgb, red, green, blue;

    public PulseColor(Blinkt b, Color c) {
        blinkt = b;
        rgb = c.getRGB();
        red = rgb >> 16 & 0xFF;
        green = rgb >> 8 & 0xFF;
        blue = rgb & 0XFF;
    }

    @Override
    public String execute() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 32; j++) {
                blinkt.set(0, red, green, blue, j);
                blinkt.set(1, red, green, blue, j);
                blinkt.set(2, red, green, blue, j);
                blinkt.set(3, red, green, blue, j);
                blinkt.set(4, red, green, blue, j);
                blinkt.set(5, red, green, blue, j);
                blinkt.set(6, red, green, blue, j);
                blinkt.set(7, red, green, blue, j);
                blinkt.show();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }

            for (int k = 31; k >= 0; k--) {
                blinkt.set(0, red, green, blue, k);
                blinkt.set(1, red, green, blue, k);
                blinkt.set(2, red, green, blue, k);
                blinkt.set(3, red, green, blue, k);
                blinkt.set(4, red, green, blue, k);
                blinkt.set(5, red, green, blue, k);
                blinkt.set(6, red, green, blue, k);
                blinkt.set(7, red, green, blue, k);
                blinkt.show();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }
        }
        blinkt.setOff();

        return String.format("Running Pulse Color - R: %s G: %s B: %s", red, green, blue);
    }

}
