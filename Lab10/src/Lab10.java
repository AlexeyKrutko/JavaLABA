import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Philosopher implements Runnable {
    final int id; // Сделаем id публичным
    private final Semaphore leftFork;
    private final Semaphore rightFork;
    private final Random random;
    private int mealsEaten;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.random = new Random();
        this.mealsEaten = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " думает");
        Thread.sleep(random.nextInt(1000)); // Время размышлений
    }

    private void eat() throws InterruptedException {
        // Берем вилки
        leftFork.acquire();
        rightFork.acquire();

        System.out.println("Философ " + id + " ест.");
        mealsEaten++;
        Thread.sleep(random.nextInt(1000)); // Время еды

        // Возвращаем вилки
        rightFork.release();
        leftFork.release();
        System.out.println("Философ " + id + " закончил есть.");
    }

    public int getMealsEaten() {
        return mealsEaten;
    }
}

public class Lab10 {
    public static void main(String[] args) {
        final int NUMPHIL = 5;
        Semaphore[] forks = new Semaphore[NUMPHIL];
        Philosopher[] philosophers = new Philosopher[NUMPHIL];

        // Инициализация вилок
        for (int i = 0; i < NUMPHIL; i++) {
            forks[i] = new Semaphore(1);
        }

        // Создание пула потоков
        ExecutorService executorService = Executors.newFixedThreadPool(NUMPHIL);

        // Создание философов и выполнение их в пуле потоков
        for (int i = 0; i < NUMPHIL; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NUMPHIL]);
            executorService.execute(philosophers[i]); // Запуск философа в пуле
        }

        // Запуск программы на определенное время
        try {
            Thread.sleep(10000); // 10 секунд
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Остановка философов
        executorService.shutdownNow(); // Остановка всех потоков

        // Протокол
        for (Philosopher philosopher : philosophers) {
            try {
                Thread.sleep(50); // Небольшая задержка для завершения потоков
                System.out.println("Философ " + philosopher.id + " ел " + philosopher.getMealsEaten() + " раз.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}