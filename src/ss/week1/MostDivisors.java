package ss.week1;

public class MostDivisors {

    public static int getDivisorNumber(int nr) {
        int divisorCount = 0;
        for (int i = 1; i <= nr; i++) {
            if (nr % i == 0) {
                divisorCount += 1;
            }
        }
        return divisorCount;
    }

    public static void main(String[] args) {
        int mostDivisors = 0;
        int mostDivisorsNumber = 0;

        for (int i = 1; i < 10000; i++) {
            if (getDivisorNumber(i) > mostDivisors) {
                mostDivisors = getDivisorNumber(i);
                mostDivisorsNumber = i;
            }
        }

        System.out.printf("%d has the most divisors: %d", mostDivisorsNumber, mostDivisors);
    }
}
