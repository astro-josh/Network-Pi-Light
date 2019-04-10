package NetPiLight.Commands;

import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.Colour;
import Jimbo.Graphics.Point;
import NetPiLight.Command;

/**
 *
 * @author Joshua Alexander
 */
public class RGBBounce implements Command, Runnable {

    private final Blinkt blinkt;
    private final double max_distance = 8;

    public RGBBounce(Blinkt b) {
        blinkt = b;
    }

    @Override
    public void run() {
        int phase = 0;
        double fraction, value1;
        Colour c1;
        
        outerloop:
        for (int i = 0; i < 4; i++) {
            for (int j = 0, k = 7; j < 8 && k >= 0; j++, k--) {
                fraction = j / max_distance;
                value1 = 360 * (1 - fraction) + phase;

                value1 %= 360;

                c1 = new Colour(value1);
                blinkt.setPixel(new Point(j, 0), c1);
                blinkt.setPixel(new Point(k, 0), c1);
                blinkt.show();
                
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    blinkt.setOff();
                    break outerloop;
                }
                blinkt.setOff();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    blinkt.setOff();
                    break outerloop;
                }
                phase++;
            }
        }
        blinkt.setOff();

    }
}
