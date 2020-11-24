package ss.week1.hotel;

import ss.utils.TextIO;

public class HotelTUI {

    public static void printMenu() {
        System.out.println(
                "Welcome to the Hotel booking system of the U Parkhotel\n" +
                "Commands:\n" +
                "i name ........... check in guest with name\n" +
                "o name ........... check out guest with name\n" +
                "r name ........... request room of guest\n" +
                "h ................ help ( this menu )\n" +
                "p ................ print state\n" +
                "x ................ exit\n"
        );
    }

    static final String HOTEL_NAME = "Hotel U Parkhotel";
    static final String ROOM_NAME = "101";


    public static void main(String[] args) {
        printMenu();
        boolean running = true;
        String roomStatus = null;
        while (running) {
            System.out.print("Enter command: ");
            String userInput = TextIO.getln();

            String[] split = userInput.split(" ");

            String command = split[0].toLowerCase();
            String param = null;

            if (split.length > 1) {
                param = split[1];
            }

            if (command.length() == 1) { // Check that command argument is 1 character long

                switch (command) {
                    case "i":
                        if (param == null) { // If no name provided
                            System.out.println("You must add the name of the guest!");
                        } else if (roomStatus == null) {
                            roomStatus = param;
                            System.out.printf("Room %s booked for %s \n", ROOM_NAME, param);
                        } else {
                            System.out.printf("Room is already booked by %s! \n", roomStatus);
                        }
                        break;
                    case "o":
                        if (param == null) { // If no guest name provided
                            System.out.println("You must add the name of the guest!");

                        } else if (roomStatus == null) { // If room is already empty
                            System.out.printf("Room %s is already empty.\n", ROOM_NAME);

                        } else if (!roomStatus.equals(param)) { // If there is no guest with given name occupying the room
                            System.out.printf("No room occupied by guest named %s.\n", param);

                        } else { // If there is a given guest occupying a room
                            roomStatus = null;
                            System.out.printf("Room %s is now empty.\n", ROOM_NAME);
                        }
                        break;
                    case "r":
                        if (param == null) {
                            System.out.println("You must add the name of the guest!");
                        } else if (roomStatus == null) {
                            System.out.printf("Room %s is empty.\n", ROOM_NAME);
                        } else if (!roomStatus.equals(param)) {
                            System.out.println("No guest found with such name!");
                        } else {
                            System.out.printf("%s occupies room %s.\n", param, ROOM_NAME);
                        }
                        break;
                    case "p":
                        System.out.printf("%s\n", HOTEL_NAME);
                        break;
                    case "h":
                        printMenu();
                        break;
                    case "x":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Such command does not exist. Type h to bring up the command menu!");
                }

            } else {
                System.out.println("Such command does not exist. Type h to bring up the command menu!");
            }

        }

    }
}
