package ss.week3.password;

public class BasicPassword {
    public static final String INITIAL = "initialpass";
    private String password;

    public BasicPassword() {
        this.password = INITIAL;
    }

    public static void main(String[] args) {

    }

    /**
     * Test if a given string is an acceptable password.
     * Not acceptable: A word with less than 6 characters
     * or a word that contains a space.
     * @requires suggestion != null
     * @param suggestion password to test
     * @return true If the suggestion has at least 6 characters and no spaces
     */
    public boolean acceptable(String suggestion) {
        return (
            suggestion != null &&
            suggestion.length() >= 6 && // Check that suggestion is 6 or more characters
            !suggestion.contains(" ") // Check that there aren't any spaces in between
        );
    }

    /**
     * Tests if a given word is equal to the current password.
     * @requires test != null
     * @param test the password to check
     * @return true If test is equal to the current password
     */
    public boolean testWord(String test) {
        return test != null && test.equals(this.password);
    }

    /**
     * Changes this password.
     * @requires oldpass != null, newpass != null
     * @param oldPass the current password
     * @param newPass the new password
     * @return true If oldPass is equal to the current password and newpass is an acceptable password
     */
    public boolean setWord(String oldPass, String newPass) {

        if (oldPass != null && newPass != null) { // Check that provided passwords aren't null
            if (testWord(oldPass)) { // Check that the current password is correct
                if (acceptable(newPass)) { // Check that new password is acceptable
                    this.password = newPass;
                    return true;
                }
            }
        }

        return false;
    }
}
