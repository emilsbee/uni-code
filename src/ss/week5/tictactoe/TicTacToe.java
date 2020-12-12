package ss.week5.tictactoe;

import ss.utils.TextIO;
import ss.week4.tictactoe.Mark;


public class TicTacToe {

    public Player getPlayer(String name, Mark mark) {

        if (name.equals("-N")) {
            return new ComputerPlayer(mark);
        } else if (name.equals("-S")) {
            return new ComputerPlayer(mark, new SmartStrategy());
        } else return new HumanPlayer(name, mark);
        
    }
    public static void main(String[] args) {
        String name1;
        String name2;
        Player p1;
        Player p2;
        
        if (args.length != 2) { // If two arguments for player names (or -N for computer) aren't provided
            
            System.out.print("Please enter  player 1 name: ");
            name1 = TextIO.getlnString();
            System.out.print("Please enter  player 2 name: ");
            name2 = TextIO.getlnString();
            p1 = new HumanPlayer(name1, Mark.XX);
            p2 = new HumanPlayer(name2, Mark.OO);

        } else if (args[0].equals("-N") || args[1].equals("-N")){ // If -N is one of the arguments 

            if (args[0].equals("-N")) { // If -N is first argument
                
                p1 = new ComputerPlayer(Mark.XX);  // Sets computer as player 1 
                name2 = args[1];
                p2 = new HumanPlayer(name2, Mark.OO); // Sets human as player 2

            } else {  // If -N is second arguemnt

                p2 = new ComputerPlayer(Mark.OO); // Sets computer as player 2
                name1 = args[0];
                p1 = new HumanPlayer(name1, Mark.XX); // Sets human as player 1

            }

        } else if (args[0].equals("-S") || args[1].equals("-S")) {

            if (args[0].equals("-S")) { // If -N is first argument
                
                p1 = new ComputerPlayer(Mark.XX, new SmartStrategy());  // Sets computer as player 1 
                name2 = args[1];
                p2 = new HumanPlayer(name2, Mark.OO); // Sets human as player 2

            } else {  // If -N is second arguemnt

                p2 = new ComputerPlayer(Mark.OO, new SmartStrategy()); // Sets computer as player 2
                name1 = args[0];
                p1 = new HumanPlayer(name1, Mark.XX); // Sets human as player 1

            }

        } else { // If two names are provided as arguments

            name1 = args[0];
            name2 = args[1];
            p1 = new HumanPlayer(name1, Mark.OO);
            p2 = new HumanPlayer(name2, Mark.XX);
            
        }

        Game game = new Game(p1, p2);
        game.start();
    } 
}
