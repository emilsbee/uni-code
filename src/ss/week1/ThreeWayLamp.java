package ss.week1;

import ss.utils.TextIO;

public class ThreeWayLamp {
    enum Actions {
        OFF,
        LOW,
        MEDIUM,
        HIGH,
        STATE,
        NEXT,
        HELP,
        EXIT
    }

    // Method to check if a string is present in an enum
    public static boolean contains(String str) {
        for (Actions a : Actions.values()) { // Iterates over Actions enum values
            if (a.name().equals(str)) { // If the name of the action is the same as user's entered action
                return true;
            }
        }

        return false;
    }

    public static void printHelp() {
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

    public static String nextState(String currentState) {
        String nextState = "";
        switch (currentState) {
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

        public static void main(String[] args) {
            System.out.println("Welcome! You can use one of the following actions to change the state of the lamp: ");
            printHelp();

        boolean running = true; // Determines the state of program
        String lampState = "OFF";

        // Program loop
        while(running) {
            System.out.print("Enter action: ");

            String methodInput = TextIO.getln();

            boolean isValid = contains(methodInput);

            if (isValid) { // Check if user input is a valid action
                switch (methodInput) {
                    case "OFF":
                        lampState = "OFF";
                        System.out.println("Lamp turned off.\n");
                        break;
                    case "LOW":
                        lampState = "LOW";
                        System.out.println("Lamp state set to low.\n");
                        break;
                    case "MEDIUM":
                        lampState = "MEDIUM";
                        System.out.println("Lamp state set to medium.\n");
                        break;
                    case "HIGH":
                        lampState = "HIGH";
                        System.out.println("Lamp state set to high.\n");
                        break;
                    case "STATE":
                        System.out.printf("Current lamp state: %s\n\n", lampState.toLowerCase());
                        break;
                    case "HELP":
                        printHelp();
                        break;
                    case "NEXT":
                        String nextUp = nextState(lampState);
                        lampState = nextUp;
                        System.out.printf("The lamp state is now: %s\n\n", nextUp.toLowerCase());
                        break;
                    case "EXIT":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                }
            } else {
                System.out.println("Looks like you've entered an invalid action. Enter HELP to see the actions again!\n");
            }

        }


    }
}
