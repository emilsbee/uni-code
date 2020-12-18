package ss.week6.account;

public class AccountSync {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        double amount = 100.00;
        int frequency = 5;

        Thread t1 = new Thread(new MyThread(amount, frequency, account));
        Thread t2 = new Thread(new MyThread(-amount, frequency, account));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(account.getBalance());

    }
}
