public class Car {
    int carPosition;

    Car(int carPosition) {
        this.carPosition = carPosition;
    }

    void moveCarForward() {
        carPosition++;
    }

    public void generateCar() {

    }

    int getCarPosition() {
        return carPosition;
    }

    void setCarPosition(int carPosition) {
        this.carPosition = carPosition;
    }
}
