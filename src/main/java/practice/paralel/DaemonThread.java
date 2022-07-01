package practice.paralel;

public class DaemonThread {
    public static class KitchenCleaner extends Thread {
        @Override
        public void run() {
            while(true){
                System.out.println("Olivia cleaned the kitchen");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread olivia = new KitchenCleaner();
        //without it, Olivia would clean the kitchen for eternity.
        //this thread will run until main program executes
        olivia.setDaemon(true);
        olivia.start();

        System.out.println("We are cooking...");
        Thread.sleep(600);
        System.out.println("We are cooking...");
        Thread.sleep(600);
        System.out.println("We are cooking...");
        Thread.sleep(600);
        System.out.println("We are done.");
    }
}
