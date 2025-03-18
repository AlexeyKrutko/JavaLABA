package Pat1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filezadanie5 {

    private static final String FILE_NAME = "f.txt";
    private static final int COUNT_VVOD = 10;

    public static void main(String[] args) {
        writeRandomIntegersToFile();
        processIntegersFromFile();
    }

    /**
     * Записывает 10 случайных целых чисел в файл.
     */
    private static void writeRandomIntegersToFile() {
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < COUNT_VVOD; i++) {
                int randomNumber = random.nextInt(201) - 100; // Генерируем случайные числа от -100 до 100
                writer.println(randomNumber);
            }
            System.out.println("Случайные числа записаны в файл " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    /**
     * Считывает целые числа из файла, выводит их на экран и считает количество положительных значений.
     */
    private static void processIntegersFromFile() {
        List<Integer> numbers = new ArrayList<>();
        int positiveCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                    if (number > 0) {
                        positiveCount++;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Некорректный формат числа в файле: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + FILE_NAME);
            return;
        } catch (IOException e) {
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
            return;
        }

        if(numbers.isEmpty()){
            System.err.println("Файл пуст или не содержит корректных чисел.");
            return;
        }

        System.out.println("Числа из файла:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\nКоличество положительных чисел: " + positiveCount);
    }
}