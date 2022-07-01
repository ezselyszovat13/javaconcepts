package practice.paralel;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVariableDemoWithoutConditionalVar {
    //in this solution they check whether it is their turn a lot of times
    public static class HungryPerson extends Thread {
        private static final int AVAILABLE_SERVINGS = 11;

        private int personID;
        private static Lock slowCookerLid = new ReentrantLock();
        private static int servings = AVAILABLE_SERVINGS;

        public HungryPerson(int personID) {
            this.personID = personID;
        }

        @Override
        public void run() {
            while (servings > 0){
                slowCookerLid.lock();
                try {
                    if((personID == servings % 2) && servings > 0){
                        servings--;
                        System.out.println("Person " + personID + " took some soup! Serving left: " + servings);
                    } else{
                        System.out.println("Person " + personID + " checked.. then put the lid back.");
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
        for (int i = 0; i < 2; i++) {
            new HungryPerson(i).start();
        }
    }
}
