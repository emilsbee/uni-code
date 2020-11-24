package ss.week3.hotel;

import ss.week3.bill.Bill;

public class PricedRoom extends Room implements Bill.Item {
    private double roomPrice;

    public PricedRoom(int number, double roomPrice, double safePrice) {
        super(number, new PricedSafe(safePrice));
        this.roomPrice = roomPrice;
    }

    @Override
    public double getAmount() {
        return this.roomPrice;
    }


    @Override
    public String toString() {
        return String.valueOf(this.roomPrice);
    }

}
