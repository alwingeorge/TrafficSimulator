
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @version 1.0
 *
 * To create a frame in it.
 */
public class Main extends JFrame {

    // Attributes..
    private static final long serialVersionUID = 1L;
    // centered panel of frame
    private JPanel centeredPanel;
    // graphics panel
    private SimulationPanel simulation;

    /**
     * Create the frame.
     */
    public Main() {

        // Creating a JFrame.
        setTitle("Car Simulation");
        // closing the program on exiting.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting size and location of frame.
        setBounds(100, 100, 515, 535);
        // creating a centered panel to add
        // components in it.
        centeredPanel = new JPanel();
        centeredPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(centeredPanel);
        centeredPanel.setLayout(null);

        simulation = new SimulationPanel();
        centeredPanel.add(simulation);

    }

    /**
     * Main method to start the program.
     *
     * @param args
     */
    public static void main(String[] args) {

        Main frame = new Main();
        frame.setVisible(true);

    }

}
