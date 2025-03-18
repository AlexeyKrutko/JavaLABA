

    public class Lab91 {

        private static final Object lock = new Object();

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                try {
                    //Состояние потока во время выполнения
                    System.out.println("Состояние потока во время выполнения (до wait): " + Thread.currentThread().getState()); // RUNNABLE

                    synchronized (lock) {
                        System.out.println("Поток вошел в synchronized блок");
                        System.out.println("Состояние потока перед wait: " + Thread.currentThread().getState()); // RUNNABLE
                        lock.wait();  //Теперь поток находится в состоянии WAITING
                        System.out.println("Состояние потока после выхода из wait: " + Thread.currentThread().getState());//RUNNABLE (после получения notify)
                        System.out.println("Поток вышел из synchronized блока");
                    }

                    System.out.println("Состояние потока после synchronized блока: " + Thread.currentThread().getState()); //RUNNABLE

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //Состояние потока перед запуском
            System.out.println("Состояние потока перед запуском: " + thread.getState()); // NEW

            // Запуск потока
            thread.start();

            Thread.sleep(100); //Небольшая задержка, чтобы thread начал выполняться
            //Состояние потока после запуска
            System.out.println("Состояние потока после запуска: " + thread.getState()); // RUNNABLE

            // Отправляем уведомление, чтобы поток продолжил выполнение
            synchronized (lock) {
                lock.notify();
            }

            // Дожидаемся завершения потока
            thread.join();
            System.out.println("Состояние потока после завершения: " + thread.getState()); // TERMINATED
        }
    }

