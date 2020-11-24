public class Fibonacci {
    public static void main(String[] args) {
        int fibo = 0;
        int nr1 = 0;
        int nr2 = 0;
        int nr3 = 0;
        int count = 0;
        int oldFibo;
        double fiboRatio;
        
        // Iterate until fibo is a negative int
        for (int i = 0; fibo >= 0; i++) {
            oldFibo = fibo;
            
            if (nr1 == 0 || nr2 == 0 || nr3 == 0) {
                fibo = 1;
                fiboRatio = 1;
            } else {
                fibo = nr1 + nr2 + nr3;
                
                fiboRatio = (double) fibo/oldFibo;
            }
            System.out.printf("%d  %f%n", fibo, fiboRatio);

            nr1 = nr2;
            nr2 = nr3;
            nr3 = fibo;

            count = i;
        }
        System.out.printf("Count: %d %n", count);
    }
}