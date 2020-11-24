package ss.week3.hotel;

import ss.utils.TextIO;
import ss.week3.bill.SysoutPrinter;

public class HotelTUI {
    private Hotel hotel;
    private static final String HOTEL_NAME = "U Parkhotel";
    private static final String INVALID_COMMAND = "Such command does not exist. Type h to bring up the command menu!";

    public HotelTUI(String name) {
        this.hotel = new Hotel(name);
    }

    public void printHelpMenu() {
        System.out.println(
                "Welcome to the Hotel booking system of the U Parkhotel\n" +
                "Commands:\n" +
                "i name ........... check in guest with name\n" +
                "o name ........... check out guest with name\n" +
                "r name ........... request room of guest\n" +
                "a name password .. activate safe , password required for PricedSafe\n" +
                "b name nights ..... print bill for guest ( name ) and number of nights\n" +
                "h ................ help ( this menu )\n" +
                "p ................ print state\n" +
                "x ................ exit\n"
        );
    }

    public void start() {
        this.printHelpMenu();

        boolean running = true;

        // Program loop
        while (running) {
            System.out.print("Enter command: ");
            String userInput = TextIO.getln();

            String[] split = userInput.split(" "); // Splits command from parameter


            String command = split[0].toLowerCase(); // Extracts command part from user's input
            String param = null;
            String param2 = null;
            // Check if there is a parameter in user's input and set set it to the param variable if there is
            if (split.length > 1) {
                param = split[1];
            }

            if (split.length > 2) {
                param2 = split[2];
            }

            if (command.length() == 1) { // Check that command argument is 1 character long

                switch (command) {
                    case "b": // Get a bill for a guest for specific night amount
                        if (param != null && param2 != null) { // Check that guest name an number of nights is provided

                            hotel.getBill(param, Integer.parseInt(param2), new SysoutPrinter());

                        } else {
                            System.out.println("You must provide guest name and night amount.");
                        }
                        break;
                    case "i": // Checking in a guest
                        if (param == null) { // If no name provided

                            System.out.println("You must add the name of the guest!");

                        } else if (hotel.getFreeRoom() != null) { // If there is a free room and a name provided

                            hotel.checkIn(param);
                            System.out.println("Room " + hotel.getRoom(param).getNumber() + " is booked for "+ param);

                        } else { // If all rooms are booked and a name is provided
                            System.out.println("All rooms are already booked!");
                        }
                        break;

                    case "o": // Checking out a guest
                        if (param == null) { // If no guest name provided

                            System.out.println("You must add the name of the guest!");

                        } else if (hotel.getRoom(param) == null) { // If name provided but there is no guest with such name

                            System.out.println("No guest under such name occupies a room.");

                        }  else { // If name is provided and there is a guest with that name occupying a room
                            int roomNumber = hotel.getRoom(param).getNumber();
                            hotel.checkOut(param);
                            System.out.println("Guest " + param + " is checked out of room "+ roomNumber);
                        }
                        break;
                    case "r": // Get the room number of a guest
                        if (param == null) { // If no guest name provided

                            System.out.println("You must add the name of the guest!");

                        } else if (hotel.getRoom(param) == null) { // If name provided but such guest doesn't exist

                            System.out.println("No guest under such name occupies a room.");

                        } else { // If name provided and there is a guest with such name

                            Room room = hotel.getRoom(param);
                            System.out.printf("%s occupies room %s.\n", param, room.getNumber());

                        }
                        break;
                    case "a": // Activate the safe for a guest
                        if (param == null) { // If no guest name provided

                            System.out.println("You must add the name of the guest!");

                        } else if (hotel.getRoom(param) == null) { // If name provided but such guest doesn't exist

                            System.out.println("No guest under such name occupies a room.");

                        } else { // If name provided and such guest exists

                            if (hotel.getRoom(param).getSafe() instanceof PricedSafe) { // Check that it is room 1
                                if (param2 != null) { // Checks that password is provided

                                    PricedRoom room = (PricedRoom) hotel.getRoom(param);
                                    PricedSafe safe = (PricedSafe) room.getSafe();

                                    if (safe.getPassword().testWord(param2)) { // If password is correct

                                        safe.activate(param2);
                                        System.out.println("Safe activated for guest " + param + " in room " + room.getNumber());

                                    } else { // If password is wrong

                                        System.out.println("Incorrect password!");

                                    }
                                } else { // If no password provided

                                    System.out.println("You must provide a password.");

                                }
                            } else { // It is room 2
                                Room room = hotel.getRoom(param);
                                Safe safe = room.getSafe();
                                safe.activate();
                                System.out.println("Safe activated for guest " + param + " in room " + room.getNumber());
                            }
                            break;
                        }
                        break;
                    case "p":  // Print out hotel status

                        // Initialise room 1 data
                        String room1RentedBy = null;
                        if (hotel.getRoom(1).getGuest() != null) { // Checks if a guest occupies the room
                            room1RentedBy = hotel.getRoom(1).getGuest().getName();
                        }
                        boolean room1SafeActive = hotel.getRoom(1).getSafe().isActive();

                        // Initialise room 1 data
                        String room2RentedBy = null;
                        if (hotel.getRoom(2).getGuest() != null) { // Checks if a guest occupies the room
                            room2RentedBy = hotel.getRoom(2).getGuest().getName();
                        }
                        boolean room2SafeActive = hotel.getRoom(2).getSafe().isActive();

                        System.out.println(HotelTUI.HOTEL_NAME);
                        System.out.println("  Room 1 (" + Hotel.ROOM_PRICE + "/night):");
                        System.out.println("    Rented by: " + room1RentedBy);
                        System.out.println("    Safe active: " + room1SafeActive);
                        System.out.println("  Room 2");
                        System.out.println("    Rented by: " + room2RentedBy);
                        System.out.println("    Safe active: " + room2SafeActive);
                        break;
                    case "h": // Print out the help menu
                        this.printHelpMenu();
                        break;
                    case "x": // Exit program
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default: // Invalid command
                        System.out.println(INVALID_COMMAND);
                }

            } else { // Invalid command
                System.out.println(INVALID_COMMAND);
            }

        }
    }

    public static void main(String[] args) {
        HotelTUI hotelTUI = new HotelTUI(HOTEL_NAME);
        hotelTUI.start();
    }
}
