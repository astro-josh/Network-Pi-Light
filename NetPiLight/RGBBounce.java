package NetPiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import Jimbo.Graphics.Colour;
import Jimbo.Graphics.Point;

/**
 *
 * @author Joshua Alexander
 */
public class RGBBounce implements Command {

    private final Blinkt b;

    public RGBBounce(Blinkt b) {
        this.b = b;
    }

    @Override
    public String execute() {
        int phase = 0;
        final double max_distance = 8;

        for (int i = 0; i < 4; i++) {
            for (int j = 0, k = 7; j < 8 && k >= 0; j++, k--) {
                double fraction = j / max_distance;

                double value1 = 360 * (1 - fraction) + phase;

                if (value1 > 360) {
                    value1 -= 360;
                }

                Colour c1 = new Colour(value1);

                b.setPixel(new Point(j, 0), c1);
                b.setPixel(new Point(k, 0), c1);
                b.show();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {

                }
                b.setOff();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
                phase++;
            }
        }
        b.setOff();
        
        return "Running RGB Bounce";
    }

}
