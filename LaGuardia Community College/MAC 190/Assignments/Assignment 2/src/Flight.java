import java.io.IOException;
import java.util.ArrayList;

public class Flight implements Reservable, PassengerViewable {
    private SeatMap seatMap;
    private ArrayList<Passenger> passengers;
    private int maxSeats;

    public Flight(int rows) {
        seatMap = new SeatMap(rows);
        passengers = new ArrayList<>();
        maxSeats = rows * 4;
    }

    @Override
    public void reserveSeat(Passenger passenger, String seat) {
        int row = seatMap.getRow(seat);
        int col = seatMap.getColumn(seat);
        try {
            PassengerFileHandler.savePassenger(passenger);
            seatMap.assignPassenger(row, col, passenger);
            passengers.add(passenger);
        } catch (IOException e) {
            System.out.println("Failed to save passenger to file: " + e.getMessage());
        }
    }
    public void removePassenger(String seat) {
        int row = seatMap.getRow(seat);
        int col = seatMap.getColumn(seat);
        Passenger found = null;
        for (Passenger passenger : passengers) {
            if (seatMap.getRow(passenger.getSeatNumber()) == row && seatMap.getColumn(passenger.getSeatNumber()) == col) {
                found = passenger;
            }
        }
        passengers.remove(found);
    }


    @Override
    public void displaySeats() {
        seatMap.displaySeats();
    }

    public SeatMap getSeatMap() {
        return seatMap;
    }

    public Boolean isFlightFull() {
        return (passengers.size() >= maxSeats);
    }
}
