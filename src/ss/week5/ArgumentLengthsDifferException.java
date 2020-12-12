package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException {
    
    /**
	 *
	 */
	private static final long serialVersionUID = 2063311339576675841L;

	public ArgumentLengthsDifferException(int s1Length, int s2Length) {
        super("error: length of command line arguments "
        + "differ (" + s1Length + ", " + s2Length + ")");
    }
}
