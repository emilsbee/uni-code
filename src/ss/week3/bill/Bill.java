package ss.week3.bill;

import java.util.ArrayList;

public class Bill {
    private double amount;
    private ArrayList <Bill.Item> items = new ArrayList<Bill.Item>();
    public Printer printer;

    public Bill(Printer printer) {
        this.printer = printer;
    }

    public ArrayList<Bill.Item> getItems() {
        return this.items;
    }

    public void addItem(Bill.Item item) {
        if (item != null) {
            this.amount += item.getAmount();
            this.items.add(item);
            this.printer.printLine(item.toString(), item.getAmount());
        }
    }

    public void close() {
        this.printer.printLine("Total", this.amount);
    }

    public double getSum() {
        return this.amount;
    }

    public interface Item {
        double getAmount();
    }
}
