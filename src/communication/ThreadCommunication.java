package communication;

class SharedResource{
    private int data = 0;
    private boolean hasData;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify();
    }
    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        return data;
    }
}
class Producer implements Runnable{

    private SharedResource resource;
    public Producer(SharedResource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                resource.produce(i);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
class Consumer implements Runnable{

    private SharedResource resource;
    public Consumer(SharedResource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                int value = resource.consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
