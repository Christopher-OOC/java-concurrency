package org.javalord.chapter1;

import java.util.logging.Logger;

class ThreadCreation implements Runnable {

    private static final Logger logger = Logger.getLogger(ThreadCreation.class.getName());

    @Override
    public void run() {
        logger.info("Thread creation started");
        System.out.println("Thread is running and creating...");
    }
}

public class RunnableExample {

    private static final Logger logger = Logger.getLogger(RunnableExample.class.getName());

    static void main() {
        logger.info("Thread main");

        ThreadCreation obj = new ThreadCreation();
        Thread thread = new Thread(obj);
        thread.start();
    }

}
