package ss.week6.threads;

public class TestConsole implements Runnable {
    @Override
    public void run() {
     sum();   
    }

    private void sum() {
        int num1 = Console.readInt(Thread.currentThread().getName()+": "+"get number 1? ");
        int num2 = Console.readInt(Thread.currentThread().getName()+": "+"get number 2? ");

        Console.print(Thread.currentThread().getName()+": "+num1+" + "+num2+" = "+(num1+num2));
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestConsole(), "Thread A");
        Thread t2 = new Thread(new TestConsole(), "Thread B");
        t1.start();
        t2.start();
    }
}
