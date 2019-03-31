package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import NetPiLight.Command;
import java.awt.Color;

/**
 *
 * @author Joshua Alexander
 */
public class SequenceColor implements Command {

    private final Blinkt blinkt;
    private final int rgb, red, green, blue;

    public SequenceColor(Blinkt b, Color c) {
        blinkt = b;
        rgb = c.getRGB();
        red = rgb >> 16 & 0xFF;
        green = rgb >> 8 & 0xFF;
        blue = rgb & 0XFF;
    }

    @Override
    public String execute() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; ++j) {
                blinkt.set(j, red, green, blue, BRIGHTNESS);
                blinkt.show();
                try {
                    Thread.sleep(200);
                    blinkt.setOff();
                    blinkt.show();
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }
        }
        blinkt.setOff();

        return String.format("Running Solid Color - R: %s G: %s B: %s", red, green, blue);
    }
}
