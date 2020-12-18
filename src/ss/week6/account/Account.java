package ss.week6.account;

public class Account {
	protected double balance = 0.0;

	synchronized public void transaction(double amount) {
		while (balance + amount < -1000.0) {
			try {
				wait();
			} catch (Exception e) {}
		}
		balance = balance + amount;
		notifyAll();
	}
	synchronized public double getBalance() {
		return balance;

	}
}
