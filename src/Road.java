public class Road {
    private Car car;
    private TrafficLight trafficLight;
    private float roadLength;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public float getRoadLength() {
        return roadLength;
    }

    public void setRoadLength(float roadLength) {
        this.roadLength = roadLength;
    }
}
