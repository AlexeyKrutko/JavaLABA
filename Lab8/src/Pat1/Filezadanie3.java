package Pat1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filezadanie3 {

    public static void main(String[] args) {
        String filePathF = "f.txt";
        String filePathG = "g.txt";
        String filePathH = "h.txt";
        int numCount = 20; // Количество случайных чисел для файла f

        try {
            generateRandomNumbers(filePathF, numCount);
            List<Integer> evenNumbers = new ArrayList<>();
            List<Integer> oddNumbers = new ArrayList<>();
            splitEvenAndOdd(filePathF, filePathG, filePathH, evenNumbers, oddNumbers);
            System.out.println("Файлы успешно обработаны.");

            System.out.println("Четные числа:");
            printNumbers(evenNumbers);
            System.out.println("Нечетные числа:");
            printNumbers(oddNumbers);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }

    // Метод для генерации случайных чисел и записи в файл f
    public static void generateRandomNumbers(String filePath, int numCount) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < numCount; i++) {
                int randomNumber = random.nextInt(100); // Генерация случайных чисел от 0 до 99
                writer.write(Integer.toString(randomNumber));
                writer.newLine();
            }
        }
    }

    // Метод для чтения чисел из файла f, записи четных в g, нечетных в h и добавления их в списки
    public static void splitEvenAndOdd(String filePathF, String filePathG, String filePathH, List<Integer> evenNumbers, List<Integer> oddNumbers) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathF));
             BufferedWriter evenWriter = new BufferedWriter(new FileWriter(filePathG));
             BufferedWriter oddWriter = new BufferedWriter(new FileWriter(filePathH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0) {
                        evenNumbers.add(number);
                        evenWriter.write(Integer.toString(number));
                        evenWriter.newLine();
                    } else {
                        oddNumbers.add(number);
                        oddWriter.write(Integer.toString(number));
                        oddWriter.newLine();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Некорректный формат числа в файле f: " + line);
                }
            }
        }
    }

    // Метод для печати чисел из списка
    public static void printNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
