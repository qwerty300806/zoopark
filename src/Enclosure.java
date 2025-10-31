// Enclosure.java
import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    // Инкапсуляция: приватное поле с контролируемым доступом
    private List<Animal> animals;
    private String name;

    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    // Контролируемые методы для работы со списком животных
    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Животное не может быть null");
        }
        animals.add(animal);
        System.out.println("Животное " + getAnimalDescription(animal) + " добавлено в вольер '" + name + "'");
    }

    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println("Животное " + getAnimalDescription(animal) + " удалено из вольера '" + name + "'");
        } else {
            System.out.println("Животное не найдено в вольере '" + name + "'");
        }
    }

    public void removeAnimalByName(String animalName) {
        Animal toRemove = null;
        for (Animal animal : animals) {
            if (animal instanceof Vertebrate) {
                Vertebrate vertebrate = (Vertebrate) animal;
                if (vertebrate.getName().equalsIgnoreCase(animalName)) {
                    toRemove = animal;
                    break;
                }
            }
        }

        if (toRemove != null) {
            removeAnimal(toRemove);
        } else {
            System.out.println("Животное с именем '" + animalName + "' не найдено в вольере");
        }
    }

    // Геттер для доступа к животным (без возможности модификации извне)
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals); // возвращаем копию для защиты инкапсуляции
    }

    public String getName() {
        return name;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void displayAnimals() {
        System.out.println("\n=== Вольер '" + name + "' (" + getAnimalCount() + " животных) ===");
        if (animals.isEmpty()) {
            System.out.println("Вольер пуст");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                System.out.println((i + 1) + ". " + getAnimalDescription(animal));
            }
        }
    }

    public void makeAllAnimalsSound() {
        System.out.println("\n--- Все животные в вольере '" + name + "' издают звуки ---");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void feedAllAnimals() {
        System.out.println("\n--- Кормление всех животных в вольере '" + name + "' ---");
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    private String getAnimalDescription(Animal animal) {
        if (animal instanceof Lion) {
            return ((Lion) animal).toString();
        } else if (animal instanceof Elephant) {
            return ((Elephant) animal).toString();
        } else if (animal instanceof Snake) {
            return ((Snake) animal).toString();
        } else {
            return animal.toString();
        }
    }
}