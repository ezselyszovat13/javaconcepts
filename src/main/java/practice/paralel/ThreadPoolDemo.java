package practice.paralel;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static class VegetableChopper extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " chopped a vegetable!");
        }
    }

    public static void main(String args[]){
        int numProcs = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numProcs);
        for (int i = 0; i < 100; i++) {
            pool.submit(new VegetableChopper());
        }
        pool.shutdown();
    }
}
