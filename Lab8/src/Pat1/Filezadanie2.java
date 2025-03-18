package Pat1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filezadanie2 {

    public static void main(String[] args) {
        String filePath = "numbers.txt";
        int numCount = 10;


        // 1. Вводим чисел с клавиатуры и запись в файл
        try {
            writeNumbersToFile(filePath, numCount);
            System.out.println("Числа  записаны в файл '" + filePath + "'.\n");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            return; // Завершаем программу, если произошла ошибка записи
        }


        // 2. Чтение чисел из файла, вывод и подсчет среднего
        try {
            List<Integer> numbers = readNumbersFromFile(filePath);
            if (numbers.isEmpty())
            {
                System.out.println("Файл пустой");
            }
            else
            {
                printNumbers(numbers);
                calculateAndPrintAverage(numbers);
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
        }
    }

    // 1. Метод для ввода чисел с клавиатуры и записи в файл
    static void writeNumbersToFile(String filePath, int numCount) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
             Scanner scanner = new Scanner(System.in))
        {
            System.out.println("Введите " + numCount + " целых чисел:");
            for (int i = 0; i < numCount; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                int number = scanner.nextInt();
                writer.write(Integer.toString(number));
                writer.newLine(); // Каждое число на новой строке
            }
        }
    }
    // 2. Метод для чтения чисел из файла
    static List<Integer> readNumbersFromFile(String filePath) throws IOException
    {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                try
                {
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                }
                catch (NumberFormatException ex)
                {
                    System.err.println("Некорректный формат числа в файле: " + line);
                }
            }
        }
        return numbers;
    }

    // 3. Метод для вывода чисел на экран
    static void printNumbers(List<Integer> numbers) {
        System.out.println("Числа из файла:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // 4. Метод для вычисления и вывода среднего значения
    static  void calculateAndPrintAverage(List<Integer> numbers)
    {
        if (!numbers.isEmpty()) {
            double sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            double average = sum / numbers.size();
            System.out.println("Среднее значение: " + average);
        }
    }
}