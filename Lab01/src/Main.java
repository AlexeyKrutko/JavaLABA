
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1-5):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                //Даны целые числа а1, а2,..., аn. Вывести на печать только те числа,
                //для которых аi ≥ i.
                // Задание 1: Вывод чисел, где ai ≥ i     -3 7 0 5
                System.out.print("Введите количество чисел: ");
                int n = scanner.nextInt();
                int[] a = new int[n];
                System.out.println("Введите числа:");
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                System.out.println("Числа, где ai ≥ i:");
                for (int i = 0; i < n; i++) {
                    if (a[i] >= i) {
                        System.out.print(a[i] + " ");
                    }
                }
                System.out.println();
                break;

            case 2:
                //Для заданной квадратной матрицы сформировать одномерный
                //массив из ее диагональных элементов.
                // Задание 2: Извлечение диагональных элементов матрицы
                int[][] matrix = {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
                int[] diagonal = new int[matrix.length];
                for (int i = 0; i < matrix.length; i++) {
                    diagonal[i++] = matrix[i][i];
                    diagonal[i] = matrix[i][i];

                }
                System.out.print("Диагональные элементы: ");
                for (int i = 0; i < diagonal.length; i++) {
                    System.out.print(diagonal[i] + " ");
                }
                System.out.println();
                break;

            case 3:
                //Выведите на экран все целые числа в диапазоне 2-90 на экран с
                //помощью функции while. Между числами знак табуляции

                // Задание 3: Вывод чисел от 2 до 90 с табуляцией
                int i = 2;
                System.out.print("Числа от 2 до 90: ");
                while (i <= 90) {
                    System.out.print(i + " ");
                    i++;
                }
                System.out.println();
                break;

            case 4:
                // Задание 4:
                System.out.println("Выберите подзадание (1, 2, 3):");
                int subChoice = scanner.nextInt();

                switch (subChoice) {
                    case 1:
                        // 4.1: Вывод дня недели по номеру
                        System.out.print("Введите номер дня недели (1-7): ");
                        int dayNumber = scanner.nextInt();
                        String dayName;


                        switch (dayNumber) {
                            case 1:
                                dayName = "Понедельник";
                                break;
                            case 2:
                                dayName = "Вторник";
                                break;
                            case 3:
                                dayName = "Среда";
                                break;
                            case 4:
                                dayName = "Четверг";
                                break;
                            case 5:
                                dayName = "Пятница";
                                break;
                            case 6:
                                dayName = "Суббота";
                                break;
                            case 7:
                                dayName = "Воскресенье";
                                break;
                            default:
                                dayName = "Неверный номер дня";
                        }
                        System.out.println("День недели: " + dayName);
                        break;

                    case 2:
                        // 4.2: Вывод названия страны по столице
                        System.out.print("Введите столицу: ");
                        String capital = scanner.next();
                        String country;
                        switch (capital) {
                            case "Минск":
                                country = "Беларусь";
                                break;
                            case "Лондон":
                                country = "Великобритания";
                                break;
                            case "Париж":
                                country = "Франция";
                                break;
                            case "Вашингтон":
                                country = "США";
                                break;
                            case "Берлин":
                                country = "Германия";
                                break;
                            case "Токио":
                                country = "Япония";
                                break;
                            default:
                                country = "Неизвестная страна";
                        }
                        System.out.println("Страна: " + country);
                        break;

                    case 3:
                        // 4.3: Вычисление суммы нечетных чисел от 0 до k
                        System.out.print("Введите k: ");
                        int k = scanner.nextInt();
                        int sum = 0;
                        int j = 0;
                        while (j <= k) {
                            if (j % 2 != 0) {
                                sum += j;
                            }
                            j++;
                        }
                        System.out.println("Сумма нечетных чисел от 0 до " + k + ": " + sum);
                        break;

                    default:
                        System.out.println("Неверный выбор подзадания.");
                }
                break;

            case 5:
                // Задание 5: Вычисление выражения x = 4² - 2 * 4
                double x = Math.pow(4,2)- 2 * 4; // Вычисление выражения
                System.out.println("Результат: x = " + x); // Вывод: Результат: x = 8
                break;

            default:
                System.out.println("Неверный выбор задания.");

        }
    }
}

