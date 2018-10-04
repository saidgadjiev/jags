package ru.saidgadjiev.pernutation.lexigraphic;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by said on 04.10.2018.
 */
public class Threads {

    public static void main(String[] args) throws Exception {
        Store store = new Store();

        new Thread(new Producer(store)).start();

        for (int i = 0; i < 10; ++i) {
            new Thread(new Consumer(store, String.valueOf(i))).start();
        }
    }

    private static class Store {

        private static final Object lock = new Object();

        private static final Random random = new Random();

        private static final Queue<Integer> queue = new ConcurrentLinkedDeque<>();

        public void put() throws InterruptedException {
            synchronized (lock) {
                while (!queue.isEmpty()) {
                    lock.wait();
                }
                random.setSeed(System.currentTimeMillis());
                int rand = random.nextInt(10);

                queue.add(rand);
                System.out.println("Producer: " + rand);

                Thread.sleep(2000);
                lock.notifyAll();
            }
        }

        public void get(String name) throws InterruptedException {
            synchronized (lock) {
                while (queue.isEmpty()) {
                    lock.wait();
                }
                System.out.println("Consumer(" + name + "): " + queue.poll());
                Thread.sleep(2000);
                lock.notify();
            }
        }
    }

    private static class Producer implements Runnable {

        private final Store store;

        private Producer(Store store) {
            this.store = store;
        }

        @Override
        public synchronized void run() {
            try {
                while (true) {
                    store.put();
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static class Consumer implements Runnable {

        private final Store store;

        private String name;

        private Consumer(Store store, String name) {
            this.store = store;
            this.name = name;
        }

        @Override
        public synchronized void run() {
            try {
                while (true) {
                    store.get(name);
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
