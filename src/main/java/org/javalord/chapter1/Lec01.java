package org.javalord.chapter1;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " is running");
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
                System.out.println("Thread is interrupted");
            }
        }
    }
}

public class Lec01 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.NORM_PRIORITY);

        myThread.start();
    }

}
