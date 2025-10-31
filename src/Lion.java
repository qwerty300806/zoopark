// Lion.java
public class Lion extends Vertebrate {
    private static final String LION_FOOD = "мясо";

    public Lion(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " рычит: Р-р-р-р!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " питается " + LION_FOOD);
    }

    public void hunt() {
        System.out.println(getName() + " охотится на добычу");
    }

    @Override
    public String toString() {
        return "Лев: " + super.toString();
    }
}