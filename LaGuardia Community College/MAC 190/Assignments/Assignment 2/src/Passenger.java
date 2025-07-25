public class Passenger extends Person {
    private String seatNumber;

    public Passenger(String name, String ssn, String address, int age, String contact, String seatNumber) {
        super(name, ssn, address, age, contact);
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}
