package org.javalord.chapter1;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MeThread extends Thread {

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Object lock = new Object();

    public MeThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(this.getName() + " has started running");
            System.out.println(this.getState());
            try {
                System.out.println(this.getName() + " is paused");
                lock.wait();
                System.out.println(this.getState());
                System.out.println(this.getName() + " running again");
            } catch (InterruptedException e) {
                System.out.println(this.getState());
                throw new RuntimeException(e);
            }
        }

    }
}

public class Lec02 {

    static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        MeThread t1 = new MeThread(lock);
        t1.start();
        System.out.println(t1.getState());

        Thread thread = new Thread(new MeThread(lock), "");

        Thread.sleep(5000);

        synchronized (lock) {
            lock.notify();
        }
    }
}
