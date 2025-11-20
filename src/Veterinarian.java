public class Veterinarian implements Staff {
    private String name;
    private String licenseNumber;
    private double salary;
    private int yearsOfExperience;

    public Veterinarian(String name, String licenseNumber, double salary, int yearsOfExperience) {
        setName(name);
        setLicenseNumber(licenseNumber);
        setSalary(salary);
        setYearsOfExperience(yearsOfExperience);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер лицензии не может быть пустым");
        }
        this.licenseNumber = licenseNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Опыт работы не может быть отрицательным");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    public void examineAnimal(Animal animal) {
        System.out.println("Ветеринар " + name + " осматривает животное:");

        if (animal instanceof Vertebrate) {
            Vertebrate vertebrate = (Vertebrate) animal;
            System.out.println("  Имя: " + vertebrate.getName());
            System.out.println("  Возраст: " + vertebrate.getAge() + " лет");
            System.out.println("  Вес: " + vertebrate.getWeight() + " кг");
        }

        System.out.print("  Звук: ");
        animal.makeSound();

        System.out.print("  Питание: ");
        animal.feed();

        if (animal instanceof Elephant) {
            Elephant elephant = (Elephant) animal;
            System.out.println("  Длина хобота: " + elephant.getTrunkLength() + " м");
            System.out.println("  Проверка: Хобот в норме");
        } else if (animal instanceof Lion) {
            Lion lion = (Lion) animal;
            System.out.println("  Проверка: Зубы и когти в норме");
        } else if (animal instanceof Snake) {
            Snake snake = (Snake) animal;
            System.out.println("  Длина: " + snake.getLength() + " м");
            System.out.println("  Проверка: Чешуя в норме");
        }

        System.out.println("  Осмотр завершен: животное здорово!\n");
    }

    public void administerVaccine(Animal animal, String vaccineName) {
        System.out.println("Ветеринар " + name + " делает прививку '" + vaccineName + "' животному");
        if (animal instanceof Vertebrate) {
            Vertebrate vertebrate = (Vertebrate) animal;
            System.out.println("  Животное: " + vertebrate.getName());
        }
        System.out.println("  Прививка успешно сделана!\n");
    }

    @Override
    public void work() {
        System.out.println("Ветеринар " + name + " проводит плановый осмотр животных");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println("Ветеринар " + name + " проверяет санитарное состояние вольера '" +
                enclosure.getName() + "' и проводит дезинфекцию");
    }

    @Override
    public String getPosition() {
        return "Ветеринар";
    }

    @Override
    public String toString() {
        return String.format("Ветеринар: %s, лицензия: %s, опыт: %d лет, зарплата: %.2f",
                name, licenseNumber, yearsOfExperience, salary);
    }
}