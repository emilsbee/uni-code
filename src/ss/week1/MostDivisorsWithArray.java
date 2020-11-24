package ss.week1;

public class MostDivisorsWithArray {
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
        int divisorArray[] = new int[10000];
        int mostDivisors = 0;
        int mostDivisorsNumber = 0;

        for (int i = 1; i < 10000; i++) {

            divisorArray[i-1] = getDivisorNumber(i); // Add divisor amount of current number to the divisors array

            if (getDivisorNumber(i) > mostDivisors) {
                mostDivisors = getDivisorNumber(i);
                mostDivisorsNumber = i;
            }
        }

        System.out.println("Among the integers between 1 and 10000,");
        System.out.printf("The maximum number of divisors was %d \n", mostDivisors);
        System.out.printf("Numbers with that many divisors include: \n");

        // Print out numbers with the most divisors
        for (int k = 0; k < divisorArray.length; k++) {
            if (divisorArray[k] == mostDivisors) {
                System.out.printf("%d \n", k+1);
            }
        }
    }
}
