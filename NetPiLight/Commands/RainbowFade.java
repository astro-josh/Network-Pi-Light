package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import NetPiLight.Command;
import java.util.Random;

/**
 *
 * @author Joshua Alexander
 */
public class RainbowFade implements Command {

    private final Blinkt blinkt;
    private final Random rand;

    public RainbowFade(Blinkt b) {
        blinkt = b;
        rand = new Random();
    }

    @Override
    public String execute() {
        int red, green, blue;

        for (int i = 0; i < 5; i++) {
            red = rand.nextInt(128);
            green = rand.nextInt(128);
            blue = rand.nextInt(128);

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

        return "Running Rainbow Fade";
    }

}
