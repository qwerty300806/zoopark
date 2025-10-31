// Elephant.java
public class Elephant extends Vertebrate {
    private static final String ELEPHANT_FOOD = "фрукты и овощи";
    private double trunkLength; // длина хобота

    public Elephant(String name, int age, double weight, double trunkLength) {
        super(name, age, weight);
        setTrunkLength(trunkLength);
    }

    public double getTrunkLength() {
        return trunkLength;
    }

    public void setTrunkLength(double trunkLength) {
        if (trunkLength <= 0) {
            throw new IllegalArgumentException("Длина хобота должна быть положительной");
        }
        this.trunkLength = trunkLength;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубит: Ту-у-у-у!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " питается " + ELEPHANT_FOOD);
    }

    public void sprayWater() {
        System.out.println(getName() + " распыляет воду с помощью хобота длиной " + trunkLength + " м");
    }

    @Override
    public String toString() {
        return "Слон: " + super.toString() + String.format(", длина хобота: %.1f м", trunkLength);
    }
}