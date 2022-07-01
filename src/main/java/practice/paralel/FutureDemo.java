package practice.paralel;

import java.util.concurrent.*;

public class FutureDemo {
    public static class HowManyVegetables implements Callable {
        @Override
        public Integer call() throws Exception {
            System.out.println("Olivia is couting vegetables...");
            Thread.sleep(3000);
            return 42;
        }
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException{
        System.out.println("Barron asks Olivia how many vegetables are in the pantry.");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future result = executorService.submit(new HowManyVegetables());
        System.out.println("Barron can do other things while he waits for the result...");
        System.out.println("Olivia responded with " + result.get());
        executorService.shutdown();
    }
}
