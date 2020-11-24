package ss.week2;

public class DollarsAndCentsCounter {
    private int dollars;
    private int cents;

    public DollarsAndCentsCounter () {
        this.dollars = 0;
        this.cents = 0;
    }

    public int dollars() {
        return this.dollars;
    }

    public int cents() {
        return this.cents;
    }

    public void add(int dollars, int cents) {
        if (dollars > 0) {
            this.dollars += dollars;
        }

        if (cents > 0) {
            this.cents += cents;
        }

        while (this.cents > 99) {
            this.cents -= 100;
            this.dollars += 1;
        }
    }

    public void reset() {
        this.dollars = 0;
        this.cents = 0;
    }
}
