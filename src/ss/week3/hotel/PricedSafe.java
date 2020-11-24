package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.password.Password;

public class PricedSafe extends Safe implements Bill.Item {
    private double price;
    private Password password;

    public PricedSafe(double price) {
        this.price = price;
        this.password = new Password();
    }

    public boolean activate(String testPassword) {
        assert testPassword != null;
//        assert password.testWord(testPassword) : "Bad password";
        if (password.testWord(testPassword)) { // If password is valid
            super.activate();
            return true;
        }
        return false;
    }

    public Password getPassword() {
        return this.password;
    }

    @Override
    public void activate() {
        System.out.println("You must provide a password to activate the safe.");
    }

    @Override
    public double getAmount() {
        return this.price;
    }

    public void open(String testPassword) {
        assert testPassword != null;
        if (password.testWord(testPassword) && super.active) { // If password is valid and safe is active
            super.open();
        }
    }

    @Override
    public void open() {

    }

    @Override
    public String toString() {
        return String.valueOf(this.price);
    }
}
