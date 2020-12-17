package ss.week6.threads;

public class TestSyncConsole implements Runnable {
    @Override
    public void run() {
     sum();   
    }

    synchronized public void sum() {
        int num1 = SyncConsole.readInt(Thread.currentThread().getName()+": "+"get number 1? ");
        int num2 = SyncConsole.readInt(Thread.currentThread().getName()+": "+"get number 2? ");

        SyncConsole.println(Thread.currentThread().getName()+": "+num1+" + "+num2+" = "+(num1+num2));
    }

    public static void main(String[] args) {
        TestSyncConsole syncConsole = new TestSyncConsole();

        Thread t1 = new Thread(syncConsole, "Thread A");
        Thread t2 = new Thread(syncConsole, "Thread B");
        t1.start();
        t2.start();

    }
}