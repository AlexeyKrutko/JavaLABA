import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Proba {

    public static void main(String[] args) {

        printTopics(new Locale("ru", "RU"));


        printTopics(new Locale("en", "US"));
    }

    public static void printTopics(Locale locale) {
        try {
            // Загружаем ресурсный файл в зависимости от локали
            ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

            // Заголовок для вывода
            if (locale.getLanguage().equals("ru")) {
                System.out.println("Распечатка на русском:");
            } else {
                System.out.println("Printout in English:");
            }

            // Массив ключей в нужном порядке
            String[] keys = {
                    "java.topic1",
                    "java.topic2",
                    "java.topic3",
                    "java.topic4",
                    "java.topic5",
                    "java.topic6",
                    "java.topic7",
                    "java.topic8",
                    "java.topic9",
                    "java.topic10",
                    "java.topic11"
            };

            // Получаем и распечатываем ключи и значения в порядке
            for (String key : keys) {
                System.out.println(key + ": " + bundle.getString(key));
            }
        } catch (MissingResourceException e) {
            System.out.println("Ресурс не найден для локали: " + locale);
        }
    }
}
