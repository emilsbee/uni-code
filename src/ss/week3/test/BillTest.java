package ss.week3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillTest {
    Bill bill;
    StringPrinter printer;

    @BeforeEach
    public void setUp() {
        printer = new StringPrinter();
        this.bill = new Bill(printer);
    }

    @Test
    public void testBeginState() {
        assertEquals(0, bill.getItems().size()); // Checks that there are no items in the bill
    }

    @Test
    public void testAddItem() {
        bill.addItem(new Item("Room", 20.00)); // Adds new item Room that costs 20.00
        bill.addItem(new Item("Snacks", 10.00)); // Adds new item Snacks that costs 10.00

        assertEquals(2, bill.getItems().size()); // Checks that item count in bill is 2
        assertEquals("Room", bill.getItems().get(0).toString()); // Checks that the first item in bill is Room
        assertEquals(20.00, bill.getItems().get(0).getAmount(), 0.01); // Checks that the first item in bill has the amount 20.00

        bill.close();
        assertEquals(
                "" +
                        "Room                         20.00\n" +
                        "Snacks                       10.00\n" +
                        "Total                        30.00\n",
                printer.getResult()
        ); // Checks that the collected string is correct from StringPrinter after bill is closed
    }

    class Item implements Bill.Item {
        private double amount;
        private String text;

        @Override
        public double getAmount() {
            return this.amount;
        }

        public Item(String text, double amount) {
            this.text = text;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }
}
