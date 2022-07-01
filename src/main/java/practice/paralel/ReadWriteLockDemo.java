package practice.paralel;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class ReadWriteLockDemo {
    public static class CalendarUser extends Thread {
        private static final String[] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        private static int today = 0;
        private static ReentrantReadWriteLock marker = new ReentrantReadWriteLock();
        private static Lock readMarker = marker.readLock();
        private static Lock writeMarker = marker.writeLock();

        public CalendarUser(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            while(today < WEEKDAYS.length - 1){
                if(this.getName().contains("Writer")){
                    writeMarker.lock();
                    today = (today+1)%7;
                    System.out.println(this.getName() + " updated date to " + WEEKDAYS[today]);
                    writeMarker.unlock();
                } else {
                    readMarker.lock();
                    System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today] + " readers: " + marker.getReadLockCount());
                    readMarker.unlock();
                }
            }
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            new CalendarUser("Reader-"+i).start();
        }
        for (int i = 0; i < 2; i++) {
            new CalendarUser("Writer-"+i).start();
        }
    }
}
