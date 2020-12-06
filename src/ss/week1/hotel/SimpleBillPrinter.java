package ss.week1.hotel;

public class SimpleBillPrinter {
    public static void main(String[] args) {
        String billDescription = "Hotel night 1x";
        Double billAmount = 85.50;
        String bill = String.format("%-25s %8.2f",billDescription, billAmount);
        System.out.printf(bill);
    }
}
