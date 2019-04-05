package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import NetPiLight.Command;
import java.awt.Color;

/**
 *
 * @author Joshua Alexander
 */
public class BlinkColor implements Command, Runnable {

    private final Blinkt blinkt;
    private final int rgb, red, green, blue;

    public BlinkColor(Blinkt b, Color c) {
        blinkt = b;
        rgb = c.getRGB();
        red = rgb >> 16 & 0xFF;
        green = rgb >> 8 & 0xFF;
        blue = rgb & 0XFF;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            blinkt.set(0, red, green, blue, BRIGHTNESS);
            blinkt.set(1, red, green, blue, BRIGHTNESS);
            blinkt.set(2, red, green, blue, BRIGHTNESS);
            blinkt.set(3, red, green, blue, BRIGHTNESS);
            blinkt.set(4, red, green, blue, BRIGHTNESS);
            blinkt.set(5, red, green, blue, BRIGHTNESS);
            blinkt.set(6, red, green, blue, BRIGHTNESS);
            blinkt.set(7, red, green, blue, BRIGHTNESS);
            blinkt.show();
            try {
                Thread.sleep(200);
                blinkt.setOff();
                Thread.sleep(200);
            } catch (InterruptedException ex) {

            }
        }
        blinkt.setOff();

    }

}
