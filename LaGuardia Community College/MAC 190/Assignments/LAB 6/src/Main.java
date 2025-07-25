import java.util.Scanner;
import java.util.InputMismatchException; //found this import from google to handle wrong input type

class TimeInUseException extends Exception {
    public TimeInUseException(String message) {
        super(message);
    }
}

class InvalidTimeException extends Exception {
    public InvalidTimeException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] timeSlots = new String[6];

        for (int x = 0; x < 6; x++) {
            try {
                System.out.print("Enter appointment time within 1-6pm: ");
                int time = input.nextInt();
                input.nextLine();

                if (time < 1 || time > 6) {
                 throw new InvalidTimeException("Invalid time, choose between 1 and 6");
                }
                if (timeSlots[time - 1] != null) {
                 throw new TimeInUseException("Time at " + time + " is booked");
                }
                System.out.print("Enter your name: ");
                String name = input.nextLine();
                timeSlots[time - 1] = name;
                System.out.println("Appointment: " + time + "PM");
                System.out.println("Patient name: " + name);
            } catch (InvalidTimeException e) {
                System.out.println(e.getMessage());
                x--;
            } catch (TimeInUseException e) {
                System.out.println(e.getMessage());
                x--;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                input.nextLine();
                x--;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                input.nextLine();
                x--;
            }
        }
        System.out.println("\nAll patient details: \n");
        for (int x = 0; x < timeSlots.length; x++) {
            System.out.println(timeSlots[x] + ": " + (x + 1) + "PM");
        }
    }
}