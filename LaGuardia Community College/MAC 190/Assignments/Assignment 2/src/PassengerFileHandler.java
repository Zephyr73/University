import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerFileHandler {
    private static final String fileName = "data/CustomerDetails.txt";

    public static void savePassenger(Passenger p) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Name: " + p.getName() + ", SSN: " + p.getSsn() + ", Address: " + p.getAddress() + ", Age: " + p.getAge() +
                        ", Contact: " + p.getContact() + ", Seat: " + p.getSeatNumber());
            writer.newLine();
        }
    }

    public  static void deletePassenger(String seatNumber) throws IOException {
        File file = new File(fileName);
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("Seat: " + seatNumber) && !line.trim().isEmpty()) {
                    updatedLines.add(line);
                }
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        }
    }

    public static void viewPassenger() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.printf("%-15s | %-10s | %-6s | %-15s | %-3s | %-12s%n", "NAME", "SSN", "SEAT", "ADDRESS", "AGE", "CONTACT");
            System.out.println("----------------------------------------------------------------------------");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");

                if (parts.length < 6) {
                    continue;
                }
                String name = parts[0].split(":", 2)[1].trim();
                String ssn = parts[1].split(":", 2)[1].trim();
                String seat = parts[5].split(":", 2)[1].trim();
                String address = parts[2].split(":", 2)[1].trim();
                String age = parts[3].split(":", 2)[1].trim();
                String contact = parts[4].split(":", 2)[1].trim();

                System.out.printf("%-15s | %-10s | %-6s | %-15s | %-3s | %-12s%n", name, ssn, seat, address, age, contact);

            }
        }
        System.out.println();
    }
}
