package ss.week6.account;

public class MyThread implements Runnable {
    private double amount;
    private int frequency;
    private Account account;

    public MyThread (double amount , int frequency , Account account ) {
        this.amount = amount ;
        this.frequency = frequency ;
        this.account = account ;

        
    }

	@Override
	public void run() {
		for (int i = 0; i < frequency; i++) {
            account.transaction(amount);
        }
		
	} 
}
