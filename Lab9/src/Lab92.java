public class Lab92 {
    private static final Object lock = new Object();
    private static boolean isFirstThread = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintName("Поток 1"));
        Thread thread2 = new Thread(new PrintName("Поток 2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();  // Главный поток ждет завершения thread1
            System.out.println("Поток 1 завершил выполнение, главный поток продолжает");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Главный поток прерван во время ожидания thread1");
        }

        System.out.println("Главный поток завершил");
    }

    static class PrintName implements Runnable {
        private final String name;

        public PrintName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while ((name.equals("Поток 1") && !isFirstThread) ||
                            (name.equals("Поток 2") && isFirstThread)) {
                        try {
                            lock.wait(); // Ждем своей очереди
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Восстанавливаем состояние прерывания
                            return; // Важно завершить поток при прерывании
                        }
                    }

                    // Выводим имя текущего потока
                    System.out.println(name);
                    // Меняем очередь
                    isFirstThread = !isFirstThread;
                    lock.notifyAll(); // Уведомляем другие потоки
                }
            }
        }
    }
}
// В main() методе добавлена конструкция try-catch с вызовом thread1.join();. Это заставляет главный поток ждать завершения выполнения потока thread1 перед тем, как продолжить выполнение. Теперь в main есть ожидание.
//  •  Добавлен вывод в консоль сообщения "Поток 1 завершил выполнение, главный поток продолжает" после того, как thread1 завершится и главный поток продолжит работу.
//  •  Добавлена обработка исключения InterruptedException для thread1.join().
