package ss.week2;

public class ThreeWayLamp {
    enum Commands {
        OFF,
        LOW,
        MEDIUM,
        HIGH,
        STATE,
        NEXT,
        HELP,
        EXIT
    }

    private String lampState;

    public ThreeWayLamp() {
        this.lampState = "OFF";
    }

    /**
     * @requires lamp state variable to have a String value which is not null
     * @ensures that the current state of lamp is returned as type String
     * @return returns current lamp state String
     **/
    public String getLampState() {
        assert this.lampState != null;
        return this.lampState;
    }

    /**
     * @requires current lamp state to be of non-null type String
     * @ensures that the next lamp state is properly returned as type String in this order OFF → LOW → MEDIUM → HIGH → OFF
     * @return next lamp state
     */
    public String getNextLampState() {
        assert this.lampState != null;

        String nextState = "";
        switch (this.lampState) {
            case "OFF":
                nextState = "LOW";
                break;
            case "LOW":
                nextState = "MEDIUM";
                break;
            case "MEDIUM":
                nextState = "HIGH";
                break;
            case "HIGH":
                nextState = "OFF";
                break;
        }
        return nextState;
    }

    /**
     * @requires a Commands enum to be defined to check commands against
     * @ensures that the return will indicate whether the command is valid or not
     * @return command validity
     */
    public static boolean isInputValid(String input) {
        for (Commands c : Commands.values()) { // Iterates over Actions enum values
            if (c.name().equals(input)) { // If the name of the action is the same as user's entered action
                return true;
            }
        }
        return false;
    }

    /**
     * @ensures that the pre-defined command help string is printed
     */
    public static void printCommandList() {
        System.out.println(
                "      OFF: Turn off the lamp (default value)\n" +
                "      LOW: Set the lamp to low light\n" +
                "      MEDIUM: Set the lamp to medium light\n" +
                "      HIGH: Set the lamp to full light\n" +
                "      STATE: Show the current setting of the lamp\n" +
                "      NEXT: Change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH → OFF\n" +
                "      HELP: Show this help menu\n" +
                "      EXIT: Quit the program\n"
        );
    }

    /**
     * @requires the argument to be a valid command
     * @ensures that the state of the lamp will be set
     */
    public void setLampState(String state) {
        assert isInputValid(state);

        this.lampState = state;
    }

    public static void mainow (String[] args) {

    }
}
