// Reptile.java
public abstract class Reptile extends Vertebrate {
    private double bodyTemperature;

    public Reptile(String name, int age, double weight, double bodyTemperature) {
        super(name, age, weight);
        setBodyTemperature(bodyTemperature);
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        if (bodyTemperature < -50 || bodyTemperature > 100) {
            throw new IllegalArgumentException("Температура тела должна быть в разумных пределах");
        }
        this.bodyTemperature = bodyTemperature;
    }

    public void baskInSun() {
        System.out.println(getName() + " греется на солнце");
        this.bodyTemperature += 2;
        System.out.println("Температура тела повысилась до: " + bodyTemperature + "°C");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", температура тела: %.1f°C", bodyTemperature);
    }
}