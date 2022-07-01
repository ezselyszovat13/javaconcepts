package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedStatement {
    public static class Shopper extends Thread {
        static int garlicCount = 0;

        @Override
        public void run() {
            for(int i=0; i < 10000; i++){
                synchronized (Shopper.class) {
                    garlicCount++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread barron = new SynchronizedStatement.Shopper();
        Thread olivia = new SynchronizedStatement.Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println(SynchronizedStatement.Shopper.garlicCount);
    }
}
