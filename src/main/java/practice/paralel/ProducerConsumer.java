package practice.paralel;

import java.util.concurrent.*;

public class ProducerConsumer {
    public static class SoupConsumer extends Thread {
        private BlockingQueue servingLine;

        public SoupConsumer(String name, BlockingQueue servingLine) {
            this.setName(name);
            this.servingLine = servingLine;
        }

        @Override
        public void run() {
            while(true){
                try {
                    String bowl = (String) servingLine.take();
                    if(bowl == "No soup for you!"){
                        break;
                    }
                    System.out.println(this.getName() + " ate " + bowl);
                    Thread.sleep(300);
                } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    public static class SoupProducer extends Thread {
        private BlockingQueue servingLine;

        public SoupProducer(BlockingQueue servingLine) {
            this.servingLine = servingLine;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 20; i++) {
                try {
                    servingLine.add("Bowl #" + i);
                    System.out.println("Served Bowl #" + i + " - remaining capacity: " + servingLine.remainingCapacity());
                    Thread.sleep(200);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            servingLine.add("No soup for you!");
            servingLine.add("No soup for you!");
        }
    }

    public static void main(String args[]){
        BlockingQueue servingLine = new ArrayBlockingQueue<String>(5);
        new SoupConsumer("Cons-1",servingLine).start();
        new SoupConsumer("Cons-2",servingLine).start();
        new SoupProducer(servingLine).start();
    }
}
