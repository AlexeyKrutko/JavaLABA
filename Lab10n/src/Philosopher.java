class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private final int eatTime;
    private final int thinkTime;
    private int mealsEaten; // Счетчик приемов пищи

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatTime = (int) (Math.random() * 300 + 100); // 1-3 сек
        this.thinkTime = (int) (Math.random() * 300 + 100); // 1-3 сек
        this.mealsEaten = 0; // Инициализация счетчика
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {  //циклпродолжается пока поток не прерывается
                think();
                if (leftFork.pickUp(id)) {
                    if (rightFork.pickUp(id)) {
                        eat();
                        rightFork.putDown(id);
                    }
                    leftFork.putDown(id);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Философ " + id + " завершает размышления...");
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет...");
        Thread.sleep(thinkTime);
    }

    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " ест...");
        mealsEaten++; // Увеличиваем счетчик приемов пищи
        Thread.sleep(eatTime);
    }

    public int getMealsEaten() {
        return mealsEaten; // Метод для получения количества приемов пищи
    }

    public int getId() { // Геттер для ID
        return id;
    }
}
