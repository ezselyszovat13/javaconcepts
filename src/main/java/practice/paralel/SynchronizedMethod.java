package practice.paralel;

public class SynchronizedMethod {
    public static class Shopper extends Thread {
        static int garlicCount = 0;

        private static synchronized void addGarlic() { garlicCount++; }

        @Override
        public void run() {
            for(int i=0; i < 10000; i++){
                addGarlic();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread barron = new SynchronizedMethod.Shopper();
        Thread olivia = new SynchronizedMethod.Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println(SynchronizedMethod.Shopper.garlicCount);
    }
}
