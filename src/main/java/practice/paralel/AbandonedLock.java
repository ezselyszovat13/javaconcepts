package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbandonedLock {
    public static class Philosopher extends Thread {
        private static final int INITIAL_SUSHI_COUNT = 5000;
        private static final int BRAKE_POINT = 10;

        private static int sushiCount = INITIAL_SUSHI_COUNT;
        private Lock firstChopstick;
        private Lock secondChopstick;

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

                    //exception happens here before we could release lock
                    //we need finally block to surely release the locks
                    if(sushiCount == BRAKE_POINT){
                        System.out.println(1/0);
                    }
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

        new Philosopher("Barron", chopstickA, chopstickB).start();
        new Philosopher("Olivia", chopstickB, chopstickC).start();
        new Philosopher("Steve", chopstickA, chopstickC).start();
    }
}
