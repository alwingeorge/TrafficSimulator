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

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Set new values of x
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Set new values of y
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set new values of width
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set new values of height
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return velocity
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Set new values of velocity
     *
     * @param velocity
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set new values of color
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return roadNumber
     */
    public int getRoadNumber() {
        return roadNumber;
    }

    /**
     * Set new values of roadNumber
     *
     * @param roadNumber
     */
    public void setRoadNumber(int roadNumber) {
        this.roadNumber = roadNumber;
    }

    /**
     * Updating the location of the
     * vehicle according to the road.
     */
    public void updateVehicle() {

        // updating the location of car
        // according to the car.
        switch(roadNumber) {

            case 1:
                y += velocity;
                break;
            case 2:
                x -= velocity;
                break;
            case 3:
                y -= velocity;
                break;
            case 4:
                x += velocity;
                break;

        }

    }

}