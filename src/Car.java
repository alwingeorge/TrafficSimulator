import java.awt.Color;

public class Car extends Vehicle {

    /**
     * Constructor.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param roadNumber
     */
    public Car(int x, int y, int width, int height, int roadNumber) {

        super(x, y, width, height, roadNumber, Color.GREEN);

    }

}
