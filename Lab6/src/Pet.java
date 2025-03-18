import java.util.HashMap;
import java.util.Map;

// Базовый класс Pet
class Pet {
    protected String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + "'}";
    }
}

// Класс Cat, наследующий от Pet
class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Cat{name='" + name + "'}";
    }
}

// Класс Dog, наследующий от Pet
class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "'}";
    }
}

// Класс Parrot, наследующий от Pet
class Parrot extends Pet {
    public Parrot(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Parrot{name='" + name + "'}";
    }
}

// Основной класс
class PetStore {

    // Метод для вывода всех ключей (имен животных) из HashMap
    public static void printPetNames(HashMap<String, Pet> pets) {
        System.out.println("Список имен домашних животных:");
        for (String name : pets.keySet()) {
            System.out.println(name);
        }
        System.out.println();
    }

    // Точка входа в программу
    public static void main(String[] args) {
        // Создание HashMap с парами "имя животного" - "объект животного"
        HashMap<String, Pet> pets = new HashMap<>();

        // Добавление животных в HashMap
        pets.put("Барсик", new Cat("Барсик"));
        pets.put("Шарик", new Dog("Шарик"));
        pets.put("Попугайчик", new Parrot("Попугайчик"));
        pets.put("Мурка", new Cat("Мурка"));
        pets.put("Бобик", new Dog("Бобик"));

        // Вызов метода для вывода имен животных
        printPetNames(pets);
    }
}
