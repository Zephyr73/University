import java.io.IOException;
import java.util.ArrayList;

public class Flight implements Reservable, PassengerViewable {
    private SeatMap seatMap;
    private ArrayList<Passenger> passengers;

    public Flight(int rows) {
        seatMap = new SeatMap(rows);
        passengers = new ArrayList<>();
    }
    @Override
    public void reserveSeat(Passenger passenger, int row, char seatLetter) {
        int col = seatLetter - 'A';
        if (!seatMap.isSeatAvailable(row, col)) {
            throw new SeatNotAvailableException("Seat is already booked");
        }
        try {
            PassengerFileHandler.savePassenger(passenger);
            seatMap.assignPassenger(row, col, passenger);
            passengers.add(passenger);
        } catch (IOException e) {
            System.out.println("Failed to save passenger to file: " + e.getMessage());
        }
    }

    @Override
    public void displaySeats() {
        seatMap.displaySeats();
    }

    public SeatMap getSeatMap() {
        return seatMap;
    }

}
