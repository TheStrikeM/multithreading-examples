package com.thestrikem;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    Thread runnableThread = new Thread(new MyRunnable());
        SomeThread someThread = new SomeThread();
        runnableThread.start(); someThread.start();
        runnableThread.join(); someThread.join();
        System.out.println("The End");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        ThreadCreator.run("RunnableThread");
    }
}

class SomeThread extends Thread {
    @Override
    public void run() {
        ThreadCreator.run("SomeThread");
    }
}

class ThreadCreator {
    public static void run(String threadName) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().setName(threadName);
            System.out.println(String.format("%s:%s - %s", Thread.currentThread().getName(), Thread.currentThread().getId(), i));
        }
    }
}
