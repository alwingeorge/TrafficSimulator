import java.awt.Color;

public class Vehicle {

    // Attributes...
    private int x; // x-axis of object
    private int y; // y-axis of object
    private int width; // width in pixels
    private int height; // height in pixels
    private int velocity; // velocity of object
    private int roadNumber; // number of road on vehicle (0,1,2,3)
    private Color color; // color of object.

    /**
     * Constructor to setup files.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param roadNumber
     * @param color
     */
    public Vehicle(int x, int y, int width, int height, int roadNumber, Color color) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.roadNumber = roadNumber;
        this.velocity = 1;

    }
}