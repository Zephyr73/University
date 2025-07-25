import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PassengerFileHandler {
    private static final String fileName = "data/CustomerDetails.txt";

    public static void savePassenger(Passenger p) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Name: " + p.getName() + ", SSN: " + p.getSsn() + ", Address: " + p.getAddress() + ", Age: " + p.getAge() +
                        ", " + p.getContact() + ", Seat: " + p.getSeatNumber());
            writer.newLine();
        }
    }
}
