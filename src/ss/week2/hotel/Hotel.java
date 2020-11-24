package ss.week2.hotel;

public class Hotel {
    private Room room1;
    private Room room2;
    String name;

    public Hotel(String name) {
        // A hotel is established with only two room instances
        this.room1 = new Room(1);
        this.room2 = new Room(2);
        this.name = name;
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

}
