import java.awt.Color;

public class TrafficLight {

    // Attributes..
    private int roadNumber; // road number..
    private Color color; // color of traffic light

    /**
     * Constructor.
     *
     * @param roadNumber
     * @param color
     */
    public TrafficLight(int roadNumber, Color color) {

        this.roadNumber = roadNumber;
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
     * To check the cars can move or not
     * on the road in which this traffic
     * light is placed and working.
     *
     *
     * @param vehicle
     * @param distanceBeforeLight
     * @return true if car can move else false
     */
    public boolean canMove(Vehicle vehicle, int[] distanceBeforeLight) {

        // If current traffic light is green.
        // than we allow all cars to move on
        // the road but if the light is red
        // then we have to check the location
        // of the cars to make them stop before
        // traffic light.
        if(this.color == Color.RED && roadNumber == vehicle.getRoadNumber()) {

            int index = roadNumber - 1;
            // checking if traffic light is placed
            // on road 1,2,3 or 4. and calculate the
            // distance between car and traffic light
            // to stop them at specified location.
            switch(roadNumber) {
                case 1:

                    // if distance is MIN_VALUE, it means no car is
                    // stopped yet at the red traffic light, but when
                    // it reached at the traffic light value, we
                    // return false so that we can stop the car
                    // and we change the distance of comparison.
                    if((distanceBeforeLight[index] == Integer.MIN_VALUE &&
                            (vehicle.getY() + vehicle.getHeight()) == 235) ||
                            ((vehicle.getY() + vehicle.getHeight()) == distanceBeforeLight[index])) {

                        distanceBeforeLight[index] = vehicle.getY() - 5;
                        return false;

                    }

                    break;
                case 2:

                    // if distance is MIN_VALUE, it means no car is
                    // stopped yet at the red traffic light, but when
                    // it reached at the traffic light value, we
                    // return false so that we can stop the car
                    // and we change the distance of comparison.
                    if ((distanceBeforeLight[index] == Integer.MIN_VALUE && vehicle.getX() == 265)
                            || (vehicle.getX() == distanceBeforeLight[index])) {

                        distanceBeforeLight[index] = vehicle.getX() + vehicle.getWidth() + 5;
                        return false;

                    }

                    break;
                case 3:

                    // if distance is MIN_VALUE, it means no car is
                    // stopped yet at the red traffic light, but when
                    // it reached at the traffic light value, we
                    // return false so that we can stop the car
                    // and we change the distance of comparison.
                    if ((distanceBeforeLight[index] == Integer.MIN_VALUE && vehicle.getY() == 265)
                            || (vehicle.getY() == distanceBeforeLight[index])) {

                        distanceBeforeLight[index] = vehicle.getY() + vehicle.getHeight() + 5;
                        return false;

                    }

                    break;
                case 4:

                    // if distance is MIN_VALUE, it means no car is
                    // stopped yet at the red traffic light, but when
                    // it reached at the traffic light value, we
                    // return false so that we can stop the car
                    // and we change the distance of comparison.
                    if((distanceBeforeLight[index] == Integer.MIN_VALUE &&
                            (vehicle.getX() + vehicle.getWidth()) == 235)
                            || ((vehicle.getX() + vehicle.getWidth()) == distanceBeforeLight[index])) {

                        distanceBeforeLight[index] = vehicle.getX() - 5;
                        return false;

                    }

                    break;
            }


        }

        return true;

    }

}
