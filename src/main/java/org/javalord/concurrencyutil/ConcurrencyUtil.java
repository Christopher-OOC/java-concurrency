package org.javalord.concurrencyutil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrencyUtil {

    private Semaphore semaphore = new Semaphore(0);
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private ReentrantLock reentrantLock = new ReentrantLock();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public void test() {
        try {
            countDownLatch.await(1000, TimeUnit.DAYS);
            semaphore.tryAcquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void main(String[] args) {

    }
}
