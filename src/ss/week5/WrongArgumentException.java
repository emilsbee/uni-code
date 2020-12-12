package ss.week5;

public class WrongArgumentException  extends Exception {
    /**
	 *
	 */
	private static final long serialVersionUID = -1395838838556485405L;

	public WrongArgumentException(String message) {
        super(message);
    }

    public WrongArgumentException() {
        super("Wrong argument exception");
    }
}
