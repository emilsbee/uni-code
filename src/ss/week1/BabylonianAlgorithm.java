package ss.week1;

import ss.utils.TextIO;

public class BabylonianAlgorithm {

    public static double percentDiff(double nr1, double nr2) {
        return (Math.abs(nr1-nr2)/((nr1+nr2)/2))*100;
    }

    public static void main(String[] args) {
        System.out.println("Please enter number you wish to square root: ");

        double n = TextIO.getDouble();

        double prevGuess = 0;
        double guess = n/2;

        while(percentDiff(guess, prevGuess) > 1) {
            prevGuess = guess;

            double r = n / guess;
            guess = (guess + r) / 2;

            System.out.printf("Current guess: %.2f\n", guess);
        }

        System.out.printf("Final guess: %.2f\n", guess);
    }
}
