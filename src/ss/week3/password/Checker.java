package ss.week3.password;

public interface Checker {

    /**
     * Test if a given string is an acceptable password.
     * @requires suggestion != null
     * @param suggestion password to test
     * @return true If the suggestion has at least 6 characters and no spaces
     */
    default boolean acceptable(String suggestion) {
        return (
                suggestion != null &&
                suggestion.length() >= 6 && // Check that suggestion is 6 or more characters
                !suggestion.contains(" ") // Check that there aren't any spaces in between
        );
    };

    boolean generatePassword();
}
