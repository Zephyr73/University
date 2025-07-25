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
            int col = seatLetter - 'A';

            if ("ABCD".indexOf(seatLetter) == -1 || row < 0 || row >= seatMap.getRows()) {
                throw new InvalidInputException("Invalid seat number");
            }
            if (seatMap.isSeatAvailable(row, col)) {
                System.out.println("Seat " + seatNumber + " is already empty\n");
            } else{
                seatMap.freeSeat(row, col);
                System.out.println("Seat " + seatNumber + "reservation cancelled\n");
            }
        } catch (InvalidInputException | NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void displayAdmin(SeatMap seatMap) {
        seatMap.displayAdmin();
    }
}
