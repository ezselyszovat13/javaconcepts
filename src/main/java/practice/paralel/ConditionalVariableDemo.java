package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ConditionalVariableDemo {
    public static class HungryPerson extends Thread {
        private static final int AVAILABLE_SERVINGS = 11;
        public static final int HUNGRY_PERSONS = 5;

        private static Lock slowCookerLid = new ReentrantLock();
        private static int servings = AVAILABLE_SERVINGS;
        private static Condition soupTaken = slowCookerLid.newCondition();

        private int personID;

        public HungryPerson(int personID) {
            this.personID = personID;
        }

        @Override
        public void run() {
            while (servings > 0){
                slowCookerLid.lock();
                try {
                    while((personID != servings % HUNGRY_PERSONS) && servings > 0) {
                        System.out.println("Person " + personID + " checked.. then put the lid back.");
                        soupTaken.await();
                    }
                    if(servings > 0){
                        servings--;
                        System.out.println("Person " + personID + " took some soup! Serving left: " + servings);
                        soupTaken.signalAll();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    slowCookerLid.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < HungryPerson.HUNGRY_PERSONS; i++) {
            new HungryPerson(i).start();
        }
    }
}
