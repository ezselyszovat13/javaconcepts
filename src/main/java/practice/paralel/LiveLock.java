package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class LiveLock {
    public static class Philosopher extends Thread {
        private Lock firstChopstick, secondChopstick;
        private static int sushiCount = 5000000;
        private Random rps = new Random();

        public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
            this.setName(name);
            this.firstChopstick = firstChopstick;
            this.secondChopstick = secondChopstick;
        }

        @Override
        public void run() {
            while(sushiCount > 0){
                firstChopstick.lock();
                if(!secondChopstick.tryLock()){
                    //cannot get second, releases first and waits (when no wait then we get deadlock)
                    System.out.println(this.getName() + " released their first chopstick.");
                    firstChopstick.unlock();
                    try{
                        Thread.sleep(rps.nextInt(3));
                    } catch (InterruptedException e) { e.printStackTrace(); }
                } else {
                    try {
                        if(sushiCount > 0){
                            sushiCount--;
                            System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                        }
                    } catch (Exception e) { e.printStackTrace();
                    } finally{
                        secondChopstick.unlock();
                        firstChopstick.unlock();
                    }
                }

            }
        }
    }

    public static void main(String[] args){
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        //they should have taken the chopsticks in prioritized order
        //if they have A then A first, then B second, C last
        new LiveLock.Philosopher("Barron", chopstickA, chopstickB).start();
        new LiveLock.Philosopher("Olivia", chopstickB, chopstickC).start();
        new LiveLock.Philosopher("Steve", chopstickC, chopstickA).start();
    }
}
