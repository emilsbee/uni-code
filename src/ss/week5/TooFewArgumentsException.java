package ss.week5;

public class TooFewArgumentsException extends WrongArgumentException {
    /**
	 *
	 */
	private static final long serialVersionUID = -8615575659164189115L;

	public TooFewArgumentsException() {
        super("error: too few command line arguments");
    }
}
