package practice.paralel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchDemo {
    public static class Shopper extends Thread {
        public static final int TASK_TO_COMPLETE_BEFORE = 5;

        public static int bagOfChips = 1;
        private static Lock pencil = new ReentrantLock();
        private static CountDownLatch fistBump = new CountDownLatch(TASK_TO_COMPLETE_BEFORE);

        public Shopper(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            if(this.getName().contains("Olivia")){
                pencil.lock();
                try {
                    bagOfChips += 3;
                    System.out.println(this.getName() + " ADDED three bags of chips.");
                } finally {
                    pencil.unlock();
                }
                fistBump.countDown();
            } else {
                try {
                    fistBump.await();
                } catch (InterruptedException e) { e.printStackTrace(); }
                pencil.lock();
                try {
                    bagOfChips *= 2;
                    System.out.println(this.getName() + " DOUBLED the bags of chips.");
                } finally {
                    pencil.unlock();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Shopper[] shoppers = new Shopper[Shopper.TASK_TO_COMPLETE_BEFORE * 2];
        for (int i = 0; i < shoppers.length/2; i++) {
            shoppers[2*i] = new Shopper("Barron-"+(i+1));
            shoppers[2*i+1] = new Shopper("Olivia-"+(i+1));
        }
        for (Shopper s: shoppers) {
            s.start();
        }
        for (Shopper s: shoppers) {
            s.join();
        }
        System.out.println("We need to buy " + Shopper.bagOfChips + " bags of chips.");
    }
}
