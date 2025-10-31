// Main.java
public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ЗООПАРКОМ ===\n");

        // Демонстрация того, что абстрактные классы не могут быть инстанциированы
        demonstrateAbstractClassInstantiation();

        // Создание животных
        System.out.println("\n--- СОЗДАНИЕ ЖИВОТНЫХ ---");
        Lion lion = new Lion("Симба", 5, 190.5);
        Elephant elephant = new Elephant("Дамбо", 10, 4500.0, 2.1);
        Snake snake = new Snake("Каа", 3, 8.5, 28.0, 4.2);

        // Создание вольеров
        Enclosure bigCatsEnclosure = new Enclosure("Большие кошки");
        Enclosure reptilesEnclosure = new Enclosure("Рептилии");

        // Добавление животных в вольеры
        bigCatsEnclosure.addAnimal(lion);
        reptilesEnclosure.addAnimal(snake);

        // Демонстрация полиморфизма
        demonstratePolymorphism(lion, elephant, snake);

        // Работа с вольерами
        demonstrateEnclosureOperations(bigCatsEnclosure, reptilesEnclosure, elephant);

        // Дополнительные демонстрации
        demonstrateAdditionalFeatures(lion, elephant, snake);
    }

    private static void demonstrateAbstractClassInstantiation() {
        System.out.println("--- ДЕМОНСТРАЦИЯ: АБСТРАКТНЫЕ КЛАССЫ НЕ МОГУТ БЫТЬ ИНСТАНЦИИРОВАНЫ ---");
        System.out.println("Следующие строки кода вызовут ошибки компиляции:");
        System.out.println("// Vertebrate animal = new Vertebrate(\"Абстрактное\", 1, 10.0); - ОШИБКА!");
        System.out.println("// Reptile reptile = new Reptile(\"Рептилия\", 1, 1.0, 25.0); - ОШИБКА!");
        System.out.println("Абстрактные классы служат только как шаблоны для конкретных классов.\n");
    }

    private static void demonstratePolymorphism(Animal... animals) {
        System.out.println("--- ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА ---");
        System.out.println("Один и тот же код (animal.makeSound()) приводит к разному поведению:");

        for (Animal animal : animals) {
            // Полиморфизм: один метод, разное поведение
            animal.makeSound();
        }

        System.out.println("\nТо же самое с методом feed():");
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    private static void demonstrateEnclosureOperations(Enclosure enclosure1, Enclosure enclosure2, Animal additionalAnimal) {
        System.out.println("\n--- РАБОТА С ВОЛЬЕРАМИ ---");

        // Добавление животного во второй вольер
        enclosure2.addAnimal(additionalAnimal);

        // Отображение содержимого вольеров
        enclosure1.displayAnimals();
        enclosure2.displayAnimals();

        // Демонстрация методов вольера
        enclosure1.makeAllAnimalsSound();
        enclosure2.feedAllAnimals();

        // Удаление животного
        enclosure2.removeAnimalByName("Дамбо");
        enclosure2.displayAnimals();
    }

    private static void demonstrateAdditionalFeatures(Lion lion, Elephant elephant, Snake snake) {
        System.out.println("\n--- ДОПОЛНИТЕЛЬНЫЕ ВОЗМОЖНОСТИ ---");

        // Демонстрация специфических методов
        if (lion instanceof Lion) {
            ((Lion) lion).hunt();
        }

        if (elephant instanceof Elephant) {
            ((Elephant) elephant).sprayWater();
        }

        if (snake instanceof Snake) {
            ((Snake) snake).baskInSun();
            ((Snake) snake).shedSkin();
        }

        // Демонстрация инкапсуляции через геттеры
        System.out.println("\n--- ДЕМОНСТРАЦИЯ ИНКАПСУЛЯЦИИ ---");
        System.out.println("Имя льва: " + ((Vertebrate) lion).getName());
        System.out.println("Возраст слона: " + ((Vertebrate) elephant).getAge() + " лет");
        System.out.println("Вес змеи: " + ((Vertebrate) snake).getWeight() + " кг");

        // Демонстрация проверок в сеттерах
        try {
            lion.setAge(-1); // Попытка установить отрицательный возраст
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка при установке возраста: " + e.getMessage());
        }

        try {
            elephant.setWeight(0); // Попытка установить нулевой вес
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при установке веса: " + e.getMessage());
        }
    }
}