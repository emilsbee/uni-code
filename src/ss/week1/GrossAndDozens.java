package ss.week1;

import ss.utils.TextIO;

public class GrossAndDozens {
    public static void main(String[] args) {
        System.out.println("How many eggs do you have?");

        int eggAmount = TextIO.getInt();
        int grosses = eggAmount /144;
        int grossesLeftover = eggAmount%144;
        int dozens = grossesLeftover/12;
        int leftover = grossesLeftover%12;

        System.out.printf("Your number of eggs is %d gross, %d dozen, and %d", grosses, dozens, leftover);
    }
}
