package ss.week4.tictactoe;

import ss.utils.TextIO;

public class TicTacToe {
    public static void main(String[] args) {
        String name1;
        String name2;
        
        if (args.length != 2) {
            System.out.print("Please enter  player 1 name: ");
            name1 = TextIO.getlnString();
            System.out.print("Please enter  player 2 name: ");
            name2 = TextIO.getlnString();
        } else {
            name1 = args[0];
            name2 = args[1];
        }

        Player p1 = new HumanPlayer(name1, Mark.OO);
        Player p2 = new HumanPlayer(name2, Mark.XX);
        Game game = new Game(p1, p2);
        game.start();
    }
}
