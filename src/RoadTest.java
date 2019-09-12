import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoadTest {
    private Road road = new Road();
    private Car car = new Car(4);
    private TrafficLight light = new TrafficLight("R");

    @Before
    public void setUp() throws Exception {
        road.setCar(car);
        road.setTrafficLight(light);
    }

    @Test
    public void setCar() {
        assertEquals(car, road.getCar());
    }

    @Test
    public void setTrafficLight() {
        assertEquals(light, road.getTrafficLight());
    }

    @Test
    public void getCar() {
        assertEquals(car, road.getCar());
    }

    @Test
    public void getTrafficLight() {
        assertEquals(light, road.getTrafficLight());
    }
}