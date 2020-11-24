import java.util.ArrayList;
import java.util.Scanner;  

public class Flight {
    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SEPERATOR = "------------------------------";

    // Instance variables
    String planeType;
    int flightNumber;
    String from;
    String to;
    int rows;
    int seatsPerRow;
    int[] seats;
    String[] formattedSeats;


    // Maps user provided flight number to an instance of a flight within flights array list
    private static int getFlightIndexFromUser(Scanner scnr, ArrayList<Flight> flights) {
        System.out.println("Which flight do you wish to buy tickets for? (enter flight nr)");
        int flightNr = scnr.nextInt();
        System.out.println(SEPERATOR);
        int flightNrIndex = -1;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber() == flightNr) {
                flightNrIndex = i;
            }
        }
        return flightNrIndex;
    }

    // Method to pretty print(sort of) the flight list
    private static void printFlights(ArrayList<Flight> flights) {
        System.out.println("Today's flight schedule");
        System.out.println("Flight nr      From          To");
        System.out.println(SEPERATOR);
        for (int k = 0; k < flights.size(); k++) {
            System.out.printf(" %s          %s         %s%n", flights.get(k).getFlightNumber(), flights.get(k).getFrom(), flights.get(k).getTo());
        }
        System.out.println(SEPERATOR);
    }

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

    public String getPlaneType() {
        return this.planeType;
    }

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public int getRows() {
        return this.rows;
    }

    public int getSeatsPerRow() {
        return this.seatsPerRow;
    }

    public int[] getSeats() {
        return this.seats;
    }

    public String[] getFormattedSeats() {
        return this.formattedSeats;
    }

    public Flight(String planeType, int flightNumber, String from, String to, int rows, int seatsPerRow) {
        this.planeType = planeType;
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new int[rows*seatsPerRow]; 
        this.formattedSeats = createFormattedSeats(rows, seatsPerRow);
    }
    
    // Prints a table with information about seat availability and whether the seat is a window seat
    public int printSeatAvailability() {
        boolean seatAvailable = false;
        // Iterates over seat indices
        System.out.println("Seats available    Window seat");
        System.out.println(SEPERATOR);
        for (int i = 0; i < seats.length; i++) {
            // If seat is available
            if (seats[i] == 0) {
                seatAvailable = true;
                String seatLetter = formattedSeats[i].substring(formattedSeats[i].length()-1);
                char seatLetterChar = seatLetter.charAt(0);
                String seatText;
                if (seatLetterChar == 'A' || seatLetterChar == Character.toUpperCase(ALPHABET.charAt(seatsPerRow-1))) {
                    seatText = String.format("   %s                   yes", formattedSeats[i]);
                } else {
                    seatText = String.format("   %s", formattedSeats[i]);
                }
                System.out.println(seatText);
            } 
        }

        System.out.println(SEPERATOR);

        if (!seatAvailable) {
            System.out.println("Sorry, no seats available! Come back later please!");
            return -1;
        } else {
            return 1;
        }
    }

    // Seat picked by user in the form "1B" 1 being row number and B being the seat within row in alphabetical order
    public int getSeatFromUser(Scanner scnr) {
        System.out.println("Which seat would you like to book?");
        scnr.nextLine();
        String currentSeat = scnr.nextLine();
        int seatIndex = -1;
        for (var s = 0; s < seats.length; s++) {
            if (formattedSeats[s].equals(currentSeat)) {
                seatIndex = s;
            } 
            
        }
        System.out.println(SEPERATOR);
        return seatIndex;
    }

    public int getActionFromUser(Scanner scnr) {
        System.out.println("Do you wish to perform preliminary booking, final booking or cancellation of a booking?");
        String action = scnr.nextLine();
        System.out.println(SEPERATOR);
        return getActionNumber(action);
    }

    // Return false if seat available, true if occupied
    public boolean isSeatOccupied(int seatIndex) {
        return seats[seatIndex] != 0; 
    }

    // Changes status of a seat within the seats array  
    public void executeUserAction(int seat, int action){
        seats[seat] = action;
    }

    public void printConfirmationMessage(int seatIndex) {
        System.out.printf("Congratulations your ticket for flight %d from %s to %s is confirmed! Your seat is %s.%n", flightNumber, from, to, formattedSeats[seatIndex]);
    }

    public void printPreliminaryMessage(int seatIndex) {
        System.out.printf("You have reserved the seat %s for the flight %d from %s to %s. Return later to confirm the purchase.%n", formattedSeats[seatIndex], flightNumber, from, to);
    }

    public int getOccupiedSeatCount() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 || seats[i] == 2) {
                count += 1;
            }
        }
        return count;
    }

    public boolean isFlightFull() {
        boolean flightFull = true;
        for (var i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                flightFull = false;
            }
        }
        return flightFull;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to buying a plane ticket simulator!\n");
        
        Scanner scnr = new Scanner(System.in);  

        // Hard coded flight instances combined in an array list
        Flight flight1 = new Flight("BIG plane",2421, "Paris", "Bogota", 5, 4);
        Flight flight2 = new Flight("Small plane", 2321, "London", "Moscow", 5, 4);
        Flight flight3 = new Flight("Medium plane", 2221, "Tokyo", "Riga", 6, 4);
        Flight flight4 = new Flight("Large plane", 2121, "Nairobi", "Mexico city", 8, 7);
        ArrayList<Flight> flights = new ArrayList<>(); 
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        // Pretty print (sort of) flights
        printFlights(flights);

        // Gets flight nr from user as an index for flights array list
        int flightIndex = getFlightIndexFromUser(scnr, flights);
        if (flightIndex == -1) {
            System.out.println("Such flight doesn't exists.");
            return;
        }

        // Asigns one of the flight instances to a main flight instance
        Flight flight = flights.get(flightIndex);

        // Show user available seats
        flight.printSeatAvailability();

        // Getting the seat value from user. If seat format is wrong
        // main thread returns and prints an error message.
        int seatIndex = flight.getSeatFromUser(scnr);
        if (seatIndex == -1) {
            System.out.println("Bad seat formatting!");
            return;
        }
        
        // Type of request by user (preliminary booking, 
        //final booking, cancelation of booking). Also alerts the user of 
        // incorrect answer and quits the thread. 
        int actionNumber = flight.getActionFromUser(scnr);
        if (actionNumber == -1) {
            System.out.println("No such action found!");
            scnr.close();
            return;
        }

        // Check if the seat is occupied
        boolean isOccupied = flight.isSeatOccupied(seatIndex);
        if (isOccupied) {
            System.out.println("Sorry this seat is occupied!");
            return;
        }

        // Creates a reservation for a seat picked by user
        flight.executeUserAction(seatIndex, actionNumber);
        
        if (actionNumber == 2) {
            flight.printConfirmationMessage(seatIndex);
        } else if (actionNumber == 1) {
            flight.printPreliminaryMessage(seatIndex);
        } else if (actionNumber == 0) {
            System.out.println("You have succesfully canceled your ticket!");
        }

        scnr.close();
    }
    
}
