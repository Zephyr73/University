import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Person implements Cancellable, AdminViewable {
    public Admin() {
        super("Admin", "0", "HQ", 0, "0");
    }

    @Override
    public void cancelReservation(String seatNumber, Flight flight) {
        try {
            SeatMap seatMap = flight.getSeatMap();
            int row = seatMap.getRow(seatNumber);
            char seatLetter = seatMap.getSeatLetter(seatNumber);
            int col = seatMap.getColumn(seatNumber);

            if ("ABCD".indexOf(seatLetter) == -1 || row < 0 || row >= seatMap.getRows()) {
                throw new SeatNotAvailableException("Invalid seat number");
            }
            if (seatMap.isSeatAvailable(row, col)) {
                System.out.println("Seat " + seatNumber + " is already empty\n");
            } else{
                seatMap.clearSeat(row, col);
                PassengerFileHandler.deletePassenger(seatNumber);
                System.out.println("Seat " + seatNumber + " reservation cancelled\n");
            }
        } catch (SeatNotAvailableException | NumberFormatException | StringIndexOutOfBoundsException | IOException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    @Override
    public void displayAdmin(SeatMap seatMap) {
        seatMap.displayAdmin();
    }

    public Flight launchAdminMenu(Scanner input, Flight flight) {
        while (true) {
            System.out.println("Admin Mode");
            System.out.println("|__ 1. Set Seat Rows");
            System.out.println("|__ 2. View Seat Rows");
            System.out.println("|__ 3. Cancel Seats");
            System.out.println("|__ 4. View CustomerDetails.txt");
            System.out.println("|__ 5. Go Back");
            System.out.print("Choice: ");

            try {
                int adminChoice = input.nextInt();
                input.nextLine();
                System.out.println();

                if (adminChoice == 1) {
                    System.out.print("Enter number of Rows: ");
                    int rows = input.nextInt();
                    input.nextLine();
                    if (flight == null) {
                        flight = new Flight(rows);
                        System.out.println("Seat rows set to " + rows + "\n");
                    } else {
                        System.out.println("Seat rows already set\n");
                    }
                } else if (adminChoice == 2) {
                    if (flight == null) {
                        throw new FlightNotFoundException("Flight not found. Please set seat rows first\n");
                    } else {
                        displayAdmin(flight.getSeatMap());
                        System.out.println();
                    }
                } else if (adminChoice == 3) {
                    if (flight == null) {
                        System.out.println("Seat map not initialized\n");
                    } else {
                        System.out.print("Enter seat number to cancel: ");
                        String cancelSeat = input.nextLine().toUpperCase();
                        cancelReservation(cancelSeat, flight);
                    }
                } else if (adminChoice == 4) {
                    PassengerFileHandler.viewPassenger();
                } else if (adminChoice == 5) {
                    System.out.println("Returning to main menu...\n");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.\n");
                }
            } catch (FlightNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Failed to read file" + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                input.nextLine();
                continue;
            }
        }
        return flight;
    }
}
