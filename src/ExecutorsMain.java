import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadExecutor();
        //ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executor.submit(new RandomNumbers());
        }

        executor.shutdown();

        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    static class RandomNumbers implements Runnable {

        Random random = new Random();

        @Override
        public void run() {
            for (int i = 0; i < 120; i++) {
                try {
                    int a = random.nextInt();
                    int b = random.nextInt();
                    int c = a * b;
                    System.out.println("c = " + c);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
