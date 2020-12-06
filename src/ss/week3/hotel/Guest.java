package ss.week3.hotel;

/**
 * @author emils
 */

public class Guest {
    private String name;
    private Room room;

    /**
     *
     * @param name the name of the guest
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     *
     * @return guest's room instance
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     *
     * @return the name of the guest
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param room the room the guest should be checked in if it is empty
     *
     * @return boolean depending on whether the checking was successful or not
     */
    public boolean checkin(Room room) {
        if (room.getGuest() == null && this.room == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return boolean depending on whether the checkout of guest was successful or not
     */
    public boolean checkout() {
        if (this.room == null) {
            return false;
        } else {
            this.room.setGuest(null);
            this.room = null;
            return true;
        }
    }


    public String toString() {
        return "Guest "+this.name;
    }
}
