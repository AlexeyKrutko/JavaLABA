import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileInfoMe {

    public static void main(String[] args) {
        String filePath = "my_info.txt"; // Путь к файлу

        // 1. Создание файла и запись информации
        try {
            createAndWriteToFile(filePath,                                               "Имя: Крутько Алексей\nВозраст: 18\nГород: Минск\nИнтересы: Компьютеры\nВаша страна: Беларусь\nМесто рождения: Минск\nМой телефон:+3752976789344");
            System.out.println("Файл '" + filePath + "' успешно создан и заполнен.\n");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
            return;
        }


        // 2. Вывод данных о файле
        try {
            printFileInfo(filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при выводе информации о файле: " + e.getMessage());
        }

        // 3. Вывод информации из файла
        try {
            printFileContent(filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при выводе содержимого файла: " + e.getMessage());
        }
    }

    // 1. Метод для создания файла и записи информации
    static void createAndWriteToFile(String filePath, String content) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    // 2. Метод для вывода информации о файле
    static void printFileInfo(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists())
        {
            Path path = Paths.get(filePath);
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("Информация о файле '" + filePath + "':");
            System.out.println("  Имя: " + file.getName());
            System.out.println("  Размер: " + file.length() + " байт");
            System.out.println("  Дата создания: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(attributes.creationTime().toMillis())));
            System.out.println("  Последнее изменение: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(attributes.lastModifiedTime().toMillis())));
            System.out.println();
        } else {
            System.out.println("Файл не найден: " + filePath);
        }
    }

    // 3. Метод для вывода информации из файла
    static void printFileContent(String filePath) throws IOException
    {
        System.out.println("Содержимое файла '" + filePath + "':");

        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        for (String line: lines){
            System.out.println("  " + line);
        }
        System.out.println();
    }
}