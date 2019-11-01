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