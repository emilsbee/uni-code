package ss.week6.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsoleLock implements Runnable {
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
     sum();   
    }

    public void sum() {
        lock.lock();
        int num1 = SyncConsole.readInt(Thread.currentThread().getName()+": "+"get number 1? ");
        int num2 = SyncConsole.readInt(Thread.currentThread().getName()+": "+"get number 2? ");

        SyncConsole.println(Thread.currentThread().getName()+": "+num1+" + "+num2+" = "+(num1+num2));
        lock.unlock();
    }

    public static void main(String[] args) {
        TestSyncConsoleLock syncConsoleLock = new TestSyncConsoleLock();

        Thread t1 = new Thread(syncConsoleLock, "Thread A");
        Thread t2 = new Thread(syncConsoleLock, "Thread B");
        t1.start();
        t2.start();

    }
}