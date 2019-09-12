import javafx.scene.shape.Circle;

public class TrafficLight {
    private Circle redLight;
    private Circle greenLight;
    private Road attachedRoad;

    public Circle getRedLight() {
        return redLight;
    }

    public void setRedLight(Circle redLight) {
        this.redLight = redLight;
    }

    public Circle getGreenLight() {
        return greenLight;
    }

    public void setGreenLight(Circle greenLight) {
        this.greenLight = greenLight;
    }

    public Road getAttachedRoad() {
        return attachedRoad;
    }

    public void setAttachedRoad(Road attachedRoad) {
        this.attachedRoad = attachedRoad;
    }
}
