package PiLight;

import Jimbo.Boards.com.pimoroni.Blinkt;
import java.util.Random;

/**
 *
 * @author Joshua Alexander
 */
public class RainbowFade implements Command {
    private final Blinkt b;
    
    public RainbowFade(Blinkt b) {
        this.b = b;
    }

    @Override
    public String execute() {
        int r, g, bl;
        
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            r = rand.nextInt(128);
            g = rand.nextInt(128);
            bl = rand.nextInt(128);

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
        
        return "Running Rainbow Fade";
    }

}
