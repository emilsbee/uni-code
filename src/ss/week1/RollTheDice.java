package ss.week1;

public class RollTheDice {
    public static void main(String[] args) {
        int die1 = (int)(Math.random()*6) + 1;
        int die2 =  (int)(Math.random()*6) + 1;

        System.out.printf("The first die comes up %d \n", die1);
        System.out.printf("The second die comes up %d \n", die2);
        System.out.printf("Your final result is %d \n", die1+die2);
    }

}
