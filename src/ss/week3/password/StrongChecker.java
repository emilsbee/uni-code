package ss.week3.password;

public class StrongChecker extends BasicChecker implements Checker {


    @Override
    public boolean acceptable(String suggestion) {
        return (
                super.acceptable(suggestion) &&
                !Character.isDigit(suggestion.charAt(0)) && // Check that suggestion starts with letter
                Character.isDigit(suggestion.charAt(suggestion.length()-1)) // Check that suggestion ends with digit
        );
    }
}
