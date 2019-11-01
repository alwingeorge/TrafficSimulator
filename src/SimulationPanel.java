import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel {

    // Attributes..
    private static final long serialVersionUID = 1L;
    // 4 traffic lights
    private TrafficLight[] lights;
    private int trafficLightIndex = 0; // running light
    private List<Vehicle> vehicleList; // list of cars..
    // this is to record distance before traffic
    // light for every road so that we can stop
    // the cars.
    private int[] distanceBeforeLight;

    /**
     * Constructor to initialize all objects.
     */
    public SimulationPanel() {

        // Setting background of panel
        setBackground(new Color(105, 105, 105));
        // setting size and location of panel
        setBounds(6, 6, 500, 500);

        this.vehicleList = new CopyOnWriteArrayList<>();

        // creating light objects..
        // creating lights..
        lights = new TrafficLight[4];
        lights[0] = new TrafficLight(1, Color.GREEN); // top
        lights[1] = new TrafficLight(2, Color.RED); // right
        lights[2] = new TrafficLight(3, Color.RED); // bottom
        lights[3] = new TrafficLight(4, Color.RED); // left

        // distance before lights..
        // 0 - Road 1
        // 1 - Road 2
        // 2 - Road 3
        // 3 - Road 4
        distanceBeforeLight = new int[4];
        // filling with minimum values
        Arrays.fill(distanceBeforeLight, Integer.MIN_VALUE);

        // creating a thread to automate the process
        // of changing traffic lights with a delay of
        // 10 seconds..
        new Thread() {

            @Override
            public void run() {

                // changing the lights continuously...
                while (true) {

                    // sleeping the traffic light for 5 seconds
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }

                    // updating the current light to red.
                    lights[trafficLightIndex].setColor(Color.RED);
                    // updating the screen.
                    repaint();
                    // sleeping the traffic light for 1 second
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    // increasing the index so that we can
                    // change the lights in a circle.
                    trafficLightIndex = (trafficLightIndex + 1) % 4;
                    lights[trafficLightIndex].setColor(Color.GREEN);
                    // updating the screen.
                    repaint();

                }

            }

        }.start();

        // creating a thread to automate the process
        // of moving the vehicles..
        new Thread() {

            @Override
            public void run() {

                // updating the vehicles continuously...
                while (true) {

                    // sleeping the process of creating
                    // vehicles for 10 milliseconds.
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }

                    // Initializing again all arrays to MIN_VALUE
                    Arrays.fill(distanceBeforeLight, Integer.MIN_VALUE);

                    // iterate through all vehicles
                    // to move them on the road.
                    for (Vehicle vehicle : vehicleList) {

                        // To check if the car is allowed to move
                        // and the respective traffic light
                        // is on or off. so that we can decide
                        // about vehicle's movement.
                        if (lights[vehicle.getRoadNumber() - 1].canMove(vehicle, distanceBeforeLight)) {

                            // if we are allowed to move
                            // update the vehicle location
                            vehicle.updateVehicle();

                        }

                    }
                    // updating the screen.
                    repaint();

                }

            }

        }.start();

        // creating a thread to automate the process
        // of adding vehicles in the simulation.
        new Thread() {

            @Override
            public void run() {

                // adding the vehicles continuously...
                while (true) {

                    // sleep creating a car process
                    // for 1000 milliseconds.
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    // creating a random vehicle
                    // and add it on the road.
                    createRandomVehicle();
                    // updating the screen.
                    repaint();

                }

            }

        }.start();

    }

    /**
     * Painting all components on the screen.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // setting color of road. Grey
        // it will execute always until
        // user click to stop the simulation.
        g.setColor(new Color(220, 220, 220));

        /*
         *
         * Creating Roads..
         *
         */
        // vertical
        g.fillRect(240, 0, 21, 500);
        // horizontal
        g.fillRect(0, 240, 500, 21);

        g.setColor(Color.WHITE);
        // vertical center line.
        g.fillRect(250, 0, 2, 500);
        // horizontal center line
        g.fillRect(0, 250, 500, 2);

        /*
         *
         * Setting Traffic Lights..
         *
         *
         */

        // top lane.
        // drawing box
        g.setColor(Color.WHITE);
        g.fillRect(264, 225, 12, 12);
        g.setColor(Color.BLACK);
        // outline circle
        g.drawOval(265, 226, 10, 10);
        g.setColor(lights[0].getColor());
        // light.
        g.fillOval(266, 227, 8, 8);

        // right
        // drawing box
        g.setColor(Color.WHITE);
        g.fillRect(264, 264, 12, 12);
        g.setColor(Color.BLACK);
        // outline circle
        g.drawOval(265, 265, 10, 10);
        g.setColor(lights[1].getColor());
        // light.
        g.fillOval(266, 266, 8, 8);

        // bottom-vertical lane.
        // drawing box
        g.setColor(Color.WHITE);
        g.fillRect(225, 264, 12, 12);
        g.setColor(Color.BLACK);
        // outline circle
        g.drawOval(226, 265, 10, 10);
        g.setColor(lights[2].getColor());
        // light.
        g.fillOval(227, 266, 8, 8);

        // left-horizontal..
        // drawing box
        g.setColor(Color.WHITE);
        g.fillRect(225, 225, 12, 12);
        g.setColor(Color.BLACK);
        // outline circle
        g.drawOval(226, 226, 10, 10);
        g.setColor(lights[3].getColor());
        // light.
        g.fillOval(227, 227, 8, 8);

        // drawing vehicles..
        for (Vehicle vehicle : vehicleList) {

            // setting color of vehicle
            g.setColor(vehicle.getColor());
            // painting the vehicle on the screen.
            g.fillRect(vehicle.getX(), vehicle.getY(), vehicle.getWidth(), vehicle.getHeight());

        }

    }

    /**
     * Randomly creating a vehicle...
     */
    public void createRandomVehicle() {

        Random random = new Random();
        int vehicleType = random.nextInt(3); // selecting from 4 vehicles.
        int roadType = 1 + random.nextInt(4); // selecting from 4 road types
        int x = 0, y = 0;
        int width = 0, height = 0;
        // setting values of x and y for the vehicle
        // according to the road type.
        switch (roadType) {

            // setting the variables of the car
            // according to the selected options.

            // if selected road is 1.
            case 1:
                x = 253;
                y = -30;
                width = 5;
                if (vehicleType == 1) {
                    height = 10;
                } else {
                    height = 30;
                }
                break;
            // if selected road is 2.
            case 2:
                x = 530;
                y = 253;
                height = 5;
                if (vehicleType == 1) {
                    width = 10;
                } else {
                    width = 30;
                }
                break;
            // if selected road is 3.
            case 3:
                x = 242;
                y = 530;
                width = 5;
                if (vehicleType == 1) {
                    height = 10;
                } else {
                    height = 30;
                }
                break;
            // if selected road is 4.
            case 4:
                x = -30;
                y = 242;
                height = 5;
                if (vehicleType == 1) {
                    width = 10;
                } else {
                    width = 30;
                }
                break;

        }

        Vehicle vehicle = null;

        // creating a object randomly....
        switch (vehicleType) {

            case 0:
                // creating a bike.
                vehicle = new Bike(x, y, roadType);
                break;
            case 1:
                // creating a car.
                vehicle = new Car(x, y, width, height, roadType);
                break;
            case 2:
                // creating a bus.
                vehicle = new Bus(x, y, width, height, roadType);
                break;

        }

        // adding it into the list.
        this.vehicleList.add(vehicle);

    }

}