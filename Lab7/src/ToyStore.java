
import java.util.HashMap;
import java.util.Scanner;

public class ToyStore {

    public static void main(String[] args) {
        HashMap<String, Product> toys = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите название игрушки (или 'стоп' для завершения):");
                String name = scanner.nextLine();

                if ("стоп".equalsIgnoreCase(name)) {
                    break;
                }
                try {
                    System.out.println("Введите цену игрушки:");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Введите описание игрушки:");
                    String description = scanner.nextLine();

                    toys.put(name, new Product(name, price, description));
                    System.out.println("Игрушка добавлена.");

                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка при создании игрушки: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: Неверный формат цены. Попробуйте еще раз.");
                } catch (Exception e) {
                    System.err.println("Ошибка при добавлении игрушки: " + e.getMessage());
                }
            }
            if (!toys.isEmpty()) {
                ToyPrinter.printEntrySet(toys);
                ToyPrinter.printKeySet(toys);
                ToyPrinter.printValues(toys);
            } else {
                System.out.println("Список игрушек пуст.");
            }

        } catch (Exception e) {
            System.err.println("Произошла общая ошибка: " + e.getMessage());
        }
    }
}
