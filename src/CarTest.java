import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CarTest {
    private Car car = new Car(0);

    @Test
    public void moveCarForward() {
        for (int i = 1; i <= 4; i++) {
            car.setCarPosition(i);
            assertEquals(i, car.getCarPosition());
        }
    }

    @Test
    public void getCarPosition() {
        assertEquals(0, car.getCarPosition());
    }

    @Test
    public void setCarPosition() {
        car.setCarPosition(3);
        assertEquals(3, car.getCarPosition());
    }
}