public class Main {
    public static void main(String[] args) {
        Road road = new Road();
        int i = 0;
        while (i <= 20) {
            road.getTrafficLight().simulateTrafficLight(1000);
            if (road.getTrafficLight().getSignal().equals("R")) {
                System.out.println("Car Position : " + road.getCar().carPosition + "\t" + "Traffic Light : " + road.getTrafficLight().getSignal());
            } else if (road.getTrafficLight().getSignal().equals("G")) {
                System.out.println("Car Position : " + road.getCar().carPosition + "\t" + "Traffic Light : " + road.getTrafficLight().getSignal());
                road.getCar().moveCarForward();
            }
            i++;
        }
    }
}
