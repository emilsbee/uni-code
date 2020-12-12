package ss.week5.tictactoe;

import ss.utils.TextIO;
import ss.week4.tictactoe.Mark;

public class TicTacToe {

    // Method that return a player intansce based on the name passed to it
    public static Player getPlayer(String name, Mark mark) {

        if (name.equals("-N")) {

            return new ComputerPlayer(mark);

        } else if (name.equals("-S")) {

            return new ComputerPlayer(mark, new SmartStrategy());
            
        } else return new HumanPlayer(name, mark);

    }

   

    public static void main(String[] args) {
        String name1;
        String name2;        
        

        if (args.length >= 2) { // If there are at least 2 arguments
            name1 = args[0];
            name2 = args[1];
        } else {
    
            System.out.print("Please enter  player 1 name: ");
            name1 = TextIO.getlnString();
            System.out.print("Please enter  player 2 name: ");
            name2 = TextIO.getlnString();

        }


        Game game = new Game(getPlayer(name1, Mark.XX), getPlayer(name2, Mark.OO));
        game.start();
    } 
}
