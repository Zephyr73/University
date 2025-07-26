public interface Reservable {
    void reserveSeat(Passenger passenger, String seat) throws SeatNotAvailableException;
}
