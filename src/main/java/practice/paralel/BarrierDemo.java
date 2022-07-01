package practice.paralel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarrierDemo {
    public static class Shopper extends Thread {
        public static final int BARRIER_BRAKER_COUNT = 10;

        private static Lock pencil = new ReentrantLock();
        private static CyclicBarrier fistBump = new CyclicBarrier(BARRIER_BRAKER_COUNT);
        public static int bagOfChips = 1;

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
                try {
                    fistBump.await();
                } catch (InterruptedException | BrokenBarrierException e) { e.printStackTrace(); }
            } else {
                try {
                    fistBump.await();
                } catch (InterruptedException | BrokenBarrierException e) { e.printStackTrace(); }
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
        Shopper[] shoppers = new Shopper[Shopper.BARRIER_BRAKER_COUNT];
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
