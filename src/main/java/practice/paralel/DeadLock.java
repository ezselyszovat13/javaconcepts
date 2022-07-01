package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static class Philosopher extends Thread {
        private Lock firstChopstick, secondChopstick;
        private static int sushiCount = 5000000;

        public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
            this.setName(name);
            this.firstChopstick = firstChopstick;
            this.secondChopstick = secondChopstick;
        }

        @Override
        public void run() {
            while(sushiCount > 0){
                firstChopstick.lock();
                secondChopstick.lock();
                if(sushiCount > 0){
                    sushiCount--;
                    System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                }
                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
    }

    public static void main(String[] args){
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        //they should have taken the chopsticks in prioritized order
        //if they have A then A first, then B second, C last
        new Philosopher("Barron", chopstickA, chopstickB).start();
        new Philosopher("Olivia", chopstickB, chopstickC).start();
        new Philosopher("Steve", chopstickC, chopstickA).start();
    }
}
