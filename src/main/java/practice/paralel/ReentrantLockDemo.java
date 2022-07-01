package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static class Shopper extends Thread {
        static int garlicCount = 0, potatoCount = 0;
        //we can lock it more times (getHoldCount() can tell how many times it was locked)
        static Lock pencil = new ReentrantLock();

        private void addGarlic(){
            pencil.lock();
            garlicCount++;
            pencil.unlock();
        }

        private void addPotato(){
            pencil.lock();
            potatoCount++;
            addGarlic();
            pencil.unlock();
        }

        @Override
        public void run() {
            for(int i=0; i < 10000; i++){
                addGarlic();
                addPotato();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread barron = new ReentrantLockDemo.Shopper();
        Thread olivia = new ReentrantLockDemo.Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println(ReentrantLockDemo.Shopper.garlicCount);
        System.out.println(ReentrantLockDemo.Shopper.potatoCount);
    }
}
