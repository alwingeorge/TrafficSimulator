public class Road {
    private Car car;
    private TrafficLight trafficLight;

    public Road(Car car, TrafficLight trafficLight) {
        this.car = car;
        this.trafficLight = trafficLight;
    }

    Road() {
        car = new Car(0);
        trafficLight = new TrafficLight("R");
    }

    Car getCar() {
        return car;
    }

    void setCar(Car car) {
        this.car = car;
    }

    TrafficLight getTrafficLight() {
        return trafficLight;
    }

    void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

}
