package ss.week3.bill;

public class StringPrinter implements Printer {
    private static String collectedString = "";

    @Override
    public void printLine(String text, double price) {
        collectedString += format(text, price);
    }

    public String getResult() {
        return collectedString;
    }
}
