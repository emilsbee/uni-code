package ss.week3.hotel;

import ss.week3.bill.Printer;

public class Hotel {
    public static final double ROOM_PRICE = 60.00;
    public static final double SAFE_PRICE = 20.00;
    private PricedRoom room1;
    private Room room2;
    public String name;

    public Hotel(String name) {
        // A hotel is established with only two room instances
        this.room1 = new PricedRoom(1, Hotel.ROOM_PRICE, Hotel.SAFE_PRICE);
        this.room2 = new Room(2);
        this.name = name;
    }

    public String getBill(String guestName, int numberOfNights, Printer printer) {
        if (room1.getGuest() != null && room1.getGuest().getName().equals(guestName)) { // If room 1 has the requested guest

            // Prints the room item in bill for the specified amount of nights
            for (int i = 0; i < numberOfNights; i++) {
                printer.printLine("Room 1 (" + Hotel.ROOM_PRICE + "/night)", Hotel.ROOM_PRICE);
            }

            printer.printLine("Safe for " + Hotel.SAFE_PRICE, Hotel.SAFE_PRICE); // Prints the safe part in the bill

            printer.printLine("Total ", Hotel.ROOM_PRICE*numberOfNights+Hotel.SAFE_PRICE); // Prints the total part in the bill

            return (String.valueOf(Hotel.ROOM_PRICE*numberOfNights+Hotel.SAFE_PRICE));

        } else return null;
    }

    public Room checkIn(String name) {

        Guest guest = new Guest(name);

        if (room1.getGuest() == null) { // If room 1 is empty

            guest.checkin(room1);

            return room1;
        } else if (room2.getGuest() == null) { // If room 2 is empty

            guest.checkin(room2);

            return room2;
        }

        else return null; // If neither room is empty
    }

    public static void deactivateSafe(Room room) {
        Safe roomSafe = room.getSafe();
        roomSafe.deactivate();
    }

    public void checkOut(String name) {

        if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) { // If room 1 isn't empty and has the guest being checked out

            // Checkout guest
            Guest guest = room1.getGuest();
            guest.checkout();

            // Deactivate safe in room
            deactivateSafe(room1);

        } else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) { // If room 2 isn't empty and has the guest being checked out

            // Checkout guest
            Guest guest = room2.getGuest();
            guest.checkout();

            // Deactivate safe in room
            deactivateSafe(room2);

        }
    }

    public Room getFreeRoom() {

        if (room1.getGuest() == null) { // If room 1 is free

            return room1;

        } else if (room2.getGuest() == null) { // If room 2 is free

            return room2;

        }

        else return null; // If both room occupied
    }

    // Gets the room of a guest given a name
    public Room getRoom(String name) {

        if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) { // If room 1 has a guest and that guest has the name of the guest being requested

            return room1;

        } else if(room2.getGuest() != null && room2.getGuest().getName().equals(name)) { // If room 2 has a guest and that guest has the name of the guest being requested

            return room2;

        }

        else return null; // If no guest with such name occupies room
    }

    public Room getRoom(int number) {
        if (number == 1) {
            return this.room1;
        } else if (number == 2) {
            return this.room2;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s %s", room1.getGuest(),room2.getGuest());
    }
}
