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
    private int[] distanceBeforeLight;}