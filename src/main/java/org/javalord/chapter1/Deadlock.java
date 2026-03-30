package org.javalord.chapter1;

class Resource {
    public synchronized void m1(Resource resource) {
        System.out.println("Calling m1...");
        resource.m2();
        System.out.println("Done m1...");
    }

    public synchronized void m2() {
        System.out.println("Calling m1...");
    }
}

public class Deadlock {

    static void main() {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Thread t1 = new Thread(() -> {
            resource1.m1(resource2);
        });

        Thread t2 = new Thread(() -> {
            resource2.m1(resource1);
        });

        t1.start();
        t2.start();
    }
}
