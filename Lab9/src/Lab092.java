public class Lab092 {

    private static final Object lock = new Object();
    private static volatile boolean threadEnteredSyncBlock = false; // Флаг

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // Состояние потока во время выполнения
                System.out.println("Состояние потока во время выполнения (до sleep): " + Thread.currentThread().getState()); // RUNNABLE

                Thread.sleep(2000); // Добавляем ожидание на 2 секунды (TIMED_WAITING)
                System.out.println("Состояние потока после sleep: " + Thread.currentThread().getState()); //RUNNABLE

                synchronized (lock) {
                    threadEnteredSyncBlock = true; // Устанавливаем флаг, что поток вошел в synchronized блок
                    System.out.println("Поток вошел в synchronized блок");
                    System.out.println("Состояние потока перед wait: " + Thread.currentThread().getState()); // RUNNABLE
                    lock.wait();  // Теперь поток находится в состоянии WAITING
                    System.out.println("Состояние потока после выхода из wait: " + Thread.currentThread().getState());//RUNNABLE (после получения notify)
                    System.out.println("Поток вышел из synchronized блока");
                }

                System.out.println("Состояние потока после synchronized блока: " + Thread.currentThread().getState()); //RUNNABLE

            } catch (InterruptedException e) {
                System.out.println("Поток прерван: " + Thread.currentThread().getState());
                e.printStackTrace();
            }
        });

        // Состояние потока перед запуском
        System.out.println("Состояние потока перед запуском: " + thread.getState()); // NEW

        // Запуск потока
        thread.start();

        // Ждем, пока поток войдет в synchronized блок (с таймаутом)
        long startTime = System.currentTimeMillis();
        while (!threadEnteredSyncBlock && (System.currentTimeMillis() - startTime) < 5000) { // Ждем до 5 секунд
            Thread.sleep(10); // Небольшая задержка, чтобы не загружать процессор
        }

        if (!threadEnteredSyncBlock) {
            System.out.println("Поток не вошел в synchronized блок за отведенное время. Завершаем программу.");
            return; // Выходим из main, чтобы не застрять
        }

        // Отправляем уведомление, чтобы поток продолжил выполнение
        synchronized (lock) {
            lock.notify();
        }

        // Дожидаемся завершения потока
        thread.join();
        System.out.println("Состояние потока после завершения: " + thread.getState()); // TERMINATED
    }
}
// два состояния ожидания:
//
//1. TIMED_WAITING: Вызвано методом Thread.sleep(2000);. Поток приостанавливает свое выполнение на 2 секунды.
//
//2. WAITING: Вызвано методом lock.wait();. Поток ожидает уведомления от другого потока (в данном случае, от главного потока). Это ожидание продолжается, пока не будет вызван lock.notify() или lock.notifyAll().