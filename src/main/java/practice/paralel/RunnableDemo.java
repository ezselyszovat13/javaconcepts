package practice.paralel;

public class RunnableDemo {
    static class ChefOlivia implements Runnable {
        @Override
        public void run() {
            System.out.println("Olivia started cutting sausage.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Olivia finished cutting sausage.");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println("Cooking has been started, we request Olivia's help.");
        Thread olivia = new Thread(new ChefOlivia());
        System.out.println("We tell Olivia that she can start.");
        olivia.start();
        System.out.println("We continue cooking soup");
        Thread.sleep(500);
        System.out.println("We are patiently waiting for Olivia to finish.");
        olivia.join();
        System.out.println("We are both done.");
    }
}
