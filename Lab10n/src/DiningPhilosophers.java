import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class DiningPhilosophers {
    public static void main(String[] args) {
        int philosopherCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(philosopherCount);
        Fork[] forks = new Fork[philosopherCount];
        Philosopher[] philosophers = new Philosopher[philosopherCount];

        // Инициализация вилок
        for (int i = 0; i < philosopherCount; i++) {
            forks[i] = new Fork();
        }

        // Создание философов
        for (int i = 0; i < philosopherCount; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % philosopherCount];

            // Последний философ берет вилки в другом порядке, чтобы избежать deadlock
            if (i == philosopherCount - 1) {
                philosophers[i] = new Philosopher(i, rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(i, leftFork, rightFork);
            }

            executor.execute(philosophers[i]);
        }

        try {
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();

        // Протокол: вывод количества приемов пищи
        for (Philosopher philosopher : philosophers) {
            System.out.println("Философ " + philosopher.getId() + " ел " + philosopher.getMealsEaten() + " раз.");
        }
    }
}
