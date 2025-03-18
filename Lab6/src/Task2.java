import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main
{
    public static void main(String[] args) {
        List<Workers> workers = new ArrayList<>();

        workers.add(new WorkerFix(123.0, "Семен"));
        workers.add(new WorkerHours(125.0, "Aнтон"));
        workers.add(new WorkerFix(150.0, "Бoрис"));
        workers.add(new WorkerHours(100.0, "Aлиса"));
        workers.add(new WorkerFix(123.0, "Aлена")); //added for testing sorting by name
        workers.add(new WorkerHours(150.0, "Cтепан"));


        // Сортировка по среднемесячной зарплате (убывание), затем по имени (алфавит)
        Collections.sort(workers, new Comparator<Workers>() {
            @Override
            public int compare(Workers w1, Workers w2) {
                double salaryDiff = w2.calculate() - w1.calculate(); // убывание
                if (salaryDiff == 0) {
                    return w1.getName().compareTo(w2.getName()); // алфавит
                }
                return Double.compare(salaryDiff, 0);
            }
        });

        // Вывод информации о работниках
        System.out.println("Список работников:");
        for (Workers worker : workers) {
            System.out.println("ID: " + workers.indexOf(worker) + ", Имя: " + worker.getName() +
                    ", Среднемесячная зарплата: " + worker.calculate());
        }

        // Вывод первых 5 имен
        System.out.println("\nПервые 5 имен:");
        for (int i = 0; i < Math.min(5, workers.size()); i++) {
            System.out.println(workers.get(i).getName());
        }

        // Вывод последних 3 идентификаторов
        System.out.println("\nПоследние 3 идентификатора:");
        for (int i = Math.max(0, workers.size() - 3); i < workers.size(); i++) {
            System.out.println(i);
        }
    }
}

