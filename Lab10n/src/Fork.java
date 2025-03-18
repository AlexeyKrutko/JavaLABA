import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Fork {
    private boolean isTaken = false;

    // Синхронизация доступа к вилке
    public synchronized boolean pickUp(int philosopherId) {
        if (!isTaken) {
            isTaken = true;
            System.out.println("Философ " + philosopherId + " взял вилку.");
            return true;
        }
        return false;
    }

    public synchronized void putDown(int philosopherId) {
        isTaken = false;
        System.out.println("Философ " + philosopherId + " положил вилку.");
    }
}

