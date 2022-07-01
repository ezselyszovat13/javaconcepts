package practice.paralel;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariable {
    public static class Shopper extends Thread {
        private static final int MAXIMUM_GARLIC = 10000;
        //atomic provides mutual exclusion automatically
        public static AtomicInteger garlicCount = new AtomicInteger(0);

        @Override
        public void run() {
            for(int i=0; i < MAXIMUM_GARLIC; i++){
                garlicCount.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread barron = new DataRace.Shopper();
        Thread olivia = new DataRace.Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println(DataRace.Shopper.garlicCount);
    }
}
