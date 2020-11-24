package ss.week2;
import ss.week2.ThreeWayLamp;
import ss.utils.TextIO;

public class ThreeWayLampTUI {
    public static void main(String[] args) {
        ThreeWayLamp lamp = new ThreeWayLamp();

        System.out.println("Welcome! You can use one of the following actions to change the state of the lamp: ");

        ThreeWayLamp.printCommandList();

        boolean running = true; // Determines the state of program

        // Program loop
        while(running) {
            System.out.print("Enter action: ");

            String methodInput = TextIO.getln();

            boolean isValid = ThreeWayLamp.isInputValid(methodInput);

            if (isValid) {
                switch (methodInput) {
                    case "OFF":
                        lamp.setLampState("OFF");
                        System.out.println("Lamp turned off.\n");
                        break;
                    case "LOW":
                        lamp.setLampState("LOW");
                        System.out.println("Lamp state set to low.\n");
                        break;
                    case "MEDIUM":
                        lamp.setLampState("MEDIUM");
                        System.out.println("Lamp state set to medium.\n");
                        break;
                    case "HIGH":
                        lamp.setLampState("HIGH");
                        System.out.println("Lamp state set to high.\n");
                        break;
                    case "STATE":
                        System.out.printf("Current lamp state: %s\n\n", lamp.getLampState());
                        break;
                    case "HELP":
                        ThreeWayLamp.printCommandList();
                        break;
                    case "NEXT":
                        String nextState = lamp.getNextLampState();
                        lamp.setLampState(nextState);
                        System.out.printf("The lamp state is now: %s\n\n", nextState.toLowerCase());
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
