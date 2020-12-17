package ss.week6.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.sql.rowset.spi.SyncResolver;

/**
 * Class for default input/output
 * @author  Arend Rensink en Theo Ruys.
 */
public class SyncConsole {
    /** character for wrong input */
    static public final char ERROR = '\u0004';

    static private BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    static private PrintStream out = System.out;

    // private Console() {

    // }

    /**
     * write a text on the default output
     * @param text text to be written
     */
    synchronized static public void print(String text) {
        out.print(text);
    }

    /**
     * write a text on the default output, ending with a new line
     * @param text text to be written
     */
    synchronized static public void println(String text) {
        out.println(text);
    }

    /**
     * Reads a line from the default input. 
     * @param  text question
     * @return read text (never null)
     */
    synchronized static public String readString(String text) {
        print(text);
        String answer = null;
        try {
            answer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (answer == null) {
            return "" + ERROR;
        } else {
            return answer;
        }
    }

    /**
     * Reads an integer from the default input
     * @param  text question text
     * @return entered number
     */
    synchronized static public int readInt(String text) {
        return readInt(text, "Enter a integer");
    }

    /**
     * Reads an integer from the default input
     * With an invalid input the question will be asked again
     * @param text question
     * @param errorMessage error message for wrong input
     * @return number
     */
    synchronized static public int readInt(String text, String errorMessage) {
        do {
            String ans = readString(text);
            try {
                return Integer.parseInt(ans);
            } catch (NumberFormatException e) {
                println(errorMessage);
            }
        } while (true);
    }
}

