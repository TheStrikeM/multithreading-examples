package com.thestrikem;

//With enabled volatile value
public class VolatileExample extends Thread {
    volatile boolean volatileBoolean = true;

    @Override
    public void run() {
        int totalCounter = 0;
        System.out.println("Thread started");
        while (volatileBoolean) {
            totalCounter++;
        }
        System.out.println("Thread stopped with result of totalCounter is " + totalCounter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample exampleThread = new VolatileExample();
        exampleThread.start();
        Thread.sleep(3000);
        exampleThread.volatileBoolean = false;
        System.out.println("After");
        exampleThread.volatileBoolean = false;
        exampleThread.join();
        System.out.println("End of program");
    }
}

//With disabled volatile value
class NotVolatileExample extends Thread {
    boolean notVolatileBoolean = true;

    @Override
    public void run() {
        int totalCounter = 0;
        System.out.println("Thread started");
        while (notVolatileBoolean) {
            totalCounter++;
        }
        System.out.println("Thread stopped with result of totalCounter is " + totalCounter);
    }

    public static void main(String[] args) throws InterruptedException {
        NotVolatileExample exampleThread = new NotVolatileExample();
        exampleThread.start();
        Thread.sleep(3000);
        exampleThread.notVolatileBoolean = false;
        System.out.println("After");
        exampleThread.notVolatileBoolean = false;
        exampleThread.join();
        System.out.println("End of program");
    }
}
