public class Zookeeper implements Staff {
    private String name;
    private String specialization;
    private double salary;
    private int shift;

    public Zookeeper(String name, String specialization, double salary, int shift) {
        setName(name);
        setSpecialization(specialization);
        setSalary(salary);
        setShift(shift);
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Специализация не может быть пустой");
        }
        this.specialization = specialization;
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

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        if (shift < 1 || shift > 2) {
            throw new IllegalArgumentException("Смена должна быть 1 (утро) или 2 (вечер)");
        }
        this.shift = shift;
    }

    public void feedAnimalsInEnclosure(Enclosure enclosure) {
        System.out.println("Смотритель " + name + " кормит животных в вольере '" +
                enclosure.getName() + "'");
        enclosure.feedAllAnimals();
    }

    public void checkEnclosureSecurity(Enclosure enclosure) {
        System.out.println("Смотритель " + name + " проверяет безопасность вольера '" +
                enclosure.getName() + "'");
        System.out.println("  Количество животных: " + enclosure.getAnimalCount());
        System.out.println("  Проверка замков и ограждений: ОК");
    }

    @Override
    public void work() {
        String shiftTime = (shift == 1) ? "утреннюю" : "вечернюю";
        System.out.println("Смотритель " + name + " выполняет " + shiftTime + " смену");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println("Смотритель " + name + " чистит вольер '" + enclosure.getName() + "'");
        System.out.println("  Временное перемещение животных...");
        for (Animal animal : enclosure.getAnimals()) {
            if (animal instanceof Vertebrate) {
                Vertebrate vertebrate = (Vertebrate) animal;
                System.out.println("    " + vertebrate.getName() + " временно перемещен");
            }
        }
        System.out.println("  Уборка завершена! Возвращение животных в вольер\n");
    }

    @Override
    public String getPosition() {
        return "Смотритель (" + specialization + ")";
    }

    @Override
    public String toString() {
        String shiftName = (shift == 1) ? "утренняя" : "вечерняя";
        return String.format("Смотритель: %s, специализация: %s, смена: %s, зарплата: %.2f",
                name, specialization, shiftName, salary);
    }
}