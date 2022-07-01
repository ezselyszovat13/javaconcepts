package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataRace {
    public static class Shopper extends Thread {
        static int garlicCount = 0;
        //without the lock the garlicCount increase wouldn't happen every time
        static Lock pencil = new ReentrantLock();

        @Override
        public void run() {
            for(int i=0; i < 10000; i++){
                pencil.lock();
                garlicCount++;
                pencil.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread barron = new Shopper();
        Thread olivia = new Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println(Shopper.garlicCount);
    }
}
