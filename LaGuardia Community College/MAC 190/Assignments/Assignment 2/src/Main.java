import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            new PrintWriter("data/CustomerDetails.txt").close();
        } catch (IOException e) {
            System.out.println("Failed to read data file");
        }

        Scanner input = new Scanner(System.in);
        Flight flight = null;
        Admin admin = new Admin();

        while(true) {
            try {
                System.out.println("Enter mode: ");
                System.out.println("1: Admin");
                System.out.println("2: Passenger");
                System.out.println("3: Exit");
                System.out.print("Choice: ");
                int choice = input.nextInt();
                input.nextLine();
                System.out.println();

                if (choice == 1) {
                    flight = admin.launchAdminMenu(input, flight);

                } else if (choice == 2) {
                    Passenger.launchPassengerMenu(input, flight);

                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;

                } else {
                    System.out.println("Invalid choice. Please try again\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number\n");
                input.nextLine();
                continue;
            }
        }
    }
}