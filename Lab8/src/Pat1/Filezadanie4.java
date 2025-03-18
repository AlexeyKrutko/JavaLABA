package Pat1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filezadanie4 {

    private static final String FILE_NAME = "tempFile.txt";
    private static final int COUNT_TEMPERATURES = 15;

    public static void main(String[] args) {
        writeTemperaturesToFile();
        double sredTemperature = readAndCalculateSredTemperature();
        System.out.println("Средняя температура: " + sredTemperature);
    }

    /**
     * Записывает 15 вещественных значений температуры, введённых с клавиатуры, в файл.
     */
    private static void writeTemperaturesToFile() {
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            System.out.println("Введите " + COUNT_TEMPERATURES + " значений температуры:");
            for (int i = 0; i < COUNT_TEMPERATURES; i++) {
                System.out.print("Температура " + (i + 1) + ": ");
                double temperature = scanner.nextDouble();
                writer.println(temperature);
            }
            System.out.println("Температуры записаны в файл " + FILE_NAME);

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }


    /**
     * Считывает вещественные значения температуры из файла и вычисляет среднюю температуру.
     *
     * @return Средняя температура или 0.0, если файл не найден или произошла ошибка при чтении.
     */
    private static double readAndCalculateSredTemperature()

     {
        List<Double> temperatures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    double temperature = Double.parseDouble(line);
                    temperatures.add(temperature);
                } catch (NumberFormatException e) {
                    System.err.println("Некорректный формат числа в файле: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + FILE_NAME);
            return 0.0;
        } catch (IOException e) {
            System.err.println("Ошибка при чтении из файла: " + e.getMessage());
            return 0.0;
        }


        if(temperatures.isEmpty()){
            System.err.println("Файл пуст или не содержит корректных значений температуры.");
            return 0.0;
        }
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        return sum / temperatures.size();
    }
}
