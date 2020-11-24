import java.util.Scanner;  // Import the Scanner class

public class Tickets {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Converts user input action to a number to use within seats array
    private static int getActionNumber(String action) {
        if (action.toLowerCase().equals("preliminary")) {
            return 1;
        } else if (action.toLowerCase().equals("final")) {
            return 2;
        } else if (action.toLowerCase().contains("cancel")) {
            return 0;
        } else {
            return -1;
        }
    }

    // Changes status of a seat within the seats array  
    private static int[] reservations(int[] seats, int seat, int action){
        seats[seat] = action;
        return seats;
    }

    // BONUS MARK METHOD
    // Prints a table with information about seat availability and whether the seat is a window seat
    private static int printSeatAvailability(int[] seats, String[] formattedSeats, int seatsPerRow) {
        boolean seatAvailable = false;
        // Iterates over seat indices
        for (int i = 0; i < seats.length; i++) {
            // If seat is available
            if (seats[i] == 0) {
                seatAvailable = true;
                String seatLetter = formattedSeats[i].substring(formattedSeats[i].length()-1);
                char seatLetterChar = seatLetter.charAt(0);
                String seatText;
                if (seatLetterChar == 'A' || seatLetterChar == Character.toUpperCase(ALPHABET.charAt(seatsPerRow-1))) {
                    seatText = String.format("The seat %s is available and it is a window seat!", formattedSeats[i]);
                } else {
                    seatText = String.format("The seat %s is available!", formattedSeats[i]);
                }
                System.out.println(seatText);
            } 
        }

        if (!seatAvailable) {
            System.out.println("Sorry, no seats available! Come back later please!");
            return -1;
        } else {
            return 1;
        }
    }

    
    private static String[] createFormattedSeats(int rows, int seatsPerRow) {
        String[] formattedSeats = new String[rows*seatsPerRow];
        
        // Iterate over rows
        for (var i = 1; i <= rows; i++) {
            for (var k = (i-1)*seatsPerRow; k < i*seatsPerRow; k++) {
                formattedSeats[k] = String.format("%d%c",i,Character.toUpperCase(ALPHABET.charAt(k-((i-1)*seatsPerRow))));
            }
        }
       
        return formattedSeats;
    }

    // Seat picked by user in the form "1B" 1 being row number and B being the seat within row in alphabetical order
    private static int getSeatFromUser(Scanner scnr, String[] formattedSeats, int[] seats) {
        System.out.println("Which seat would you like to book?");
        scnr.nextLine(); // Consumes unused \n from previous nextInt() call
        String currentSeat = scnr.nextLine();
        int seatIndex = -1;
        for (var s = 0; s < seats.length; s++) {
            if (formattedSeats[s].equals(currentSeat)) {
                seatIndex = s;
            } 
        }
        return seatIndex;
    }

    // BONUS MARK METHOD
    private static int getOccupiedSeatCount(int[] seats) {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 || seats[i] == 2) {
                count += 1;
            }
        }
        return count;
    }

    // BONUS MARK METHOD
    private static boolean isFlightFull(int[] seats) {
        boolean flightFull = true;
        for (var i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                flightFull = false;
            }
        }
        return flightFull;
    }

    // BONUS MARK METHOD
    // Return false if seat available, true if occupied
    private static boolean isSeatOccupied(int[] seats, int seatIndex) {
        return seats[seatIndex] != 0; 
    }
    public static void main(String[] args) {              
        Scanner scnr = new Scanner(System.in);  

        // Input user for number of rows
        System.out.println("Enter the number of rows: ");
        int rows = scnr.nextInt();  
    
        // Input user for number of seats per row
        System.out.println("Enter the number of seats per row: ");
        int seatsPerRow = scnr.nextInt();
        
        int[] seats = new int[rows*seatsPerRow]; // Creates array for seats with 0 as default value for a seat
        
        // Creates array with seat names corresponding to the seat values array.
        // For easier switch between human readable "1A" seat format and seat indices.
        String[] formattedSeats = createFormattedSeats(rows, seatsPerRow); 


        // Instead of just finding first free seat, this method finds
        // all free seats and lists them including the information about
        // whether it's a window seat (window seat is the first and last one in a row). 
        // If no seats available, user is notified and thread returns. 
        int seatAvailable = printSeatAvailability(seats, formattedSeats, seatsPerRow);
        if (seatAvailable == -1) {
            scnr.close();
            return;
        }


        // Getting the seat value from user. If seat format is wrong
        // main thread returns and prints an error message.
        int seatIndex = getSeatFromUser(scnr, formattedSeats, seats);
        if (seatIndex == -1) {
            System.out.println("Bad seat formatting!");
            return;
        }
        
        
        // Type of request by user (preliminary booking, 
        //final booking, cancelation of booking). Also alerts the user of 
        // incorrect answer and quits the thread. 
        System.out.println("Do you wish to perform preliminary booking, final booking or cancellation of a booking?");
        String action = scnr.nextLine();
        int actionNumber = getActionNumber(action);
        if (actionNumber == -1) {
            System.out.println("No such action found!");
            scnr.close();
            return;
        }
        
        // Check if the seat is occupied
        boolean isOccupied = isSeatOccupied(seats, seatIndex);
        if (isOccupied) {
            System.out.println("Sorry this seat is occupied!");
            return;
        }

        // Creates a reservation for a seat picked by user
        seats = reservations(seats, seatIndex, actionNumber);
        
        // Iterates over seats to show that reservation was succesfull
        for (int i : seats) {
            System.out.println(i);
        }

        scnr.close();
    }   
}
