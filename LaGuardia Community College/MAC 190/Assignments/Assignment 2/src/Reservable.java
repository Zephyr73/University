public interface Reservable {
    void reserveSeat(Passenger passenger, int row, char seatLetter) throws SeatNotAvailableException;
}
