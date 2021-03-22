import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 1000; i++) {
            Thread.startVirtualThread(new RandomNumbers());
            // Thread t = new Thread(new RandomNumbers());
            // t.start();
        }

        Thread.sleep(120000);

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
