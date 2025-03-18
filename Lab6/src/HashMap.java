import java.util.HashMap;
import java.util.Map;

// Класс Product
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

// Основной класс
 class ToyStore {

    private HashMap<String, Product> products;

    public ToyStore() {
        products = new HashMap<>();
    }

    // Метод для добавления продукта
    public void addProduct(String toyName, Product product) {
        products.put(toyName, product);
    }

    // Метод для печати пар значений (entrySet)
    public void printEntrySet() {
        System.out.println("Пары значений (имя игрушки - объект):");
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();
    }

    // Метод для печати набора имен продуктов (keySet)
    public void printKeySet() {
        System.out.println("Набор имен продуктов:");
        for (String toyName : products.keySet()) {
            System.out.println(toyName);
        }
        System.out.println();
    }

    // Метод для печати значений продуктов (values)
    public void printValues() {
        System.out.println("Значения продуктов:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
        System.out.println();
    }

    // Точка входа в программу
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление игрушек в магазин
        toyStore.addProduct("Мягкая игрушка", new Product("Медведь", 19.99));
        toyStore.addProduct("Конструктор", new Product("Лего", 29.99));
        toyStore.addProduct("Кукла", new Product("Барби", 24.99));

        // Печать данных
        toyStore.printEntrySet();
        toyStore.printKeySet();
        toyStore.printValues();
    }
}
