import java.util.Random;

class TrafficLight {
    private String signal;
    private int duration;

    TrafficLight(String signal) {
        this.signal = signal;
    }

    void simulateTrafficLight(int duration) {
        try {
            Random random = new Random();
            int num = random.nextInt(2);
            if (num == 1) {
                this.signal = "G";
            } else {
                this.signal = "R";
            }
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    String getSignal() {
        return signal;
    }

    void setSignal(String signal) {
        this.signal = signal;
    }

    int getDuration() {
        return duration;
    }

    void setDuration(int duration) {
        this.duration = duration;
    }
}