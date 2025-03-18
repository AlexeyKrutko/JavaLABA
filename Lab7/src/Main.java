import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();
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

                    toyManager.addToy(name, new Product(name, price, description));
                    System.out.println("Игрушка добавлена.");

                } catch (IllegalArgumentException e){
                    System.err.println("Ошибка при создании игрушки: " + e.getMessage());
                }

                catch (Exception e) {
                    System.err.println("Ошибка при добавлении игрушки: " + e.getMessage());
                }
            }
            toyManager.printEntrySet();
            toyManager.printKeySet();
            toyManager.printValues();
        } catch (Exception e) {
            System.err.println("Произошла общая ошибка: " + e.getMessage());
        }
    }
}