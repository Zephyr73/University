import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Old {
    public static void main(String[] args) {
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

                //--------------------------------[Admin Menu Choices]--------------------------------
                //------------------------------------------------------------------------------------
                if (choice == 1) {
                    while (true) {
                        System.out.println("--- Entered Admin menu ---");
                        System.out.println("|__ 1. Set Seat Rows");
                        System.out.println("|__ 2. View Seat Rows");
                        System.out.println("|__ 3. Cancel Seats");
                        System.out.println("|__ 4. View CustomerDetails.txt");
                        System.out.println("|__ 5. Go Back");

                        System.out.print("Choice: ");
                        choice = input.nextInt();
                        System.out.println();

                        if (choice == 1) {
                            System.out.print("Enter Number of Rows: ");
                            int rows = input.nextInt();
                            input.nextLine();
                            flight = new Flight(rows);
                            System.out.println("Created " + rows + " rows");
                            System.out.println();
                        } else if (choice == 2) {
                            if (flight == null) {
                                System.out.println("Seat map not initialized\n");
                            } else {
                                admin.displayAdmin(flight.getSeatMap());
                                System.out.println();
                            }
                        } else if (choice == 3) {
                            if (flight == null) {
                                System.out.println("Seat map not initialized\n");
                            } else {
                                System.out.println("Enter seat number to cancel: ");
                                String cancelSeat = input.nextLine().toUpperCase();
                                admin.cancelReservation(cancelSeat, flight);
                            }
                        } else if (choice == 4) {
                            continue;
                        } else if (choice == 5) {
                            System.out.println("Returning to main menu...\n");;
                            break;
                        } else {
                            System.out.println("Enter a valid option\n");
                        }
                    }
                    //------------------------------------------------------------------------------------
                    //------------------------------------------------------------------------------------

                    //--------------------------------[Passenger Menu Choices]--------------------------------
                } else if (choice == 2) {
                    while (true) {
                        System.out.println("--- Entered Passenger menu ---");
                        System.out.println("|__ 1. View Seat Layout");
                        System.out.println("|__ 2. Book Seat");
                        System.out.println("|__ 3. Go Back");
                        System.out.print("Choice: ");

                        try {
                            choice = input.nextInt();
                            input.nextLine();
                            System.out.println();

                            if (choice == 1) {
                                if (flight == null) {
                                    throw new FlightNotFoundException("Seat map not initialized, use admin mode to set seat rows");
                                }
                                flight.displaySeats();
                                System.out.println();
                            } else if (choice == 2) {
                                if (flight == null) {
                                    throw new FlightNotFoundException("Seat map not initialized, use admin mode to set seat rows");
                                }
                                System.out.println("Enter Passenger details: ");
                                System.out.print("Full Name: ");
                                String name = input.nextLine();

                                System.out.print("SSN: ");
                                String ssn = input.nextLine();

                                System.out.print("Address: ");
                                String address = input.nextLine();
                                if (address.trim().isEmpty()) {
                                    throw new InvalidAddressException("Address cannot be empty");
                                }

                                System.out.print("Age: ");
                                int age = input.nextInt();
                                input.nextLine();

                                System.out.print("Contact: ");
                                String contact = input.nextLine();
                                if (!contact.matches("\\d{10}")) {
                                    throw new InvalidPhoneException("Contact must be 10 digit number");
                                }

                                System.out.print("Desired Seat: ");
                                String seat = input.nextLine().toUpperCase();

                                int row = flight.getSeatMap().getRow(seat);
                                char seatLetter = flight.getSeatMap().getSeatLetter(seat);

                                if ("ABCD".indexOf(seatLetter) == -1) {
                                    throw new InvalidInputException("Enter valid seat letter. Choose A, B, C or D");
                                }
                                if (row < 0 || row >= flight.getSeatMap().getRows()) {
                                    throw new InvalidInputException("Enter valid seat number. Choose between 1 and " + flight.getSeatMap().getRows());
                                }

                                Passenger p = new Passenger(name, ssn, address, age, contact, seat);
                                flight.reserveSeat(p, row, seatLetter);
                                System.out.println();
                            } else if (choice == 3) {
                                System.out.println("Returning to main menu...\n");
                                break;
                            } else {
                                System.out.println("Enter a valid option\n");
                            }
                        } catch (InvalidInputException e) {
                            System.out.println("\nError: " + e.getMessage() +"\n");
                        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                            System.out.println("\nInvalid seat format\n");
                        } catch (FlightNotFoundException | InvalidAddressException | InvalidPhoneException e) {
                            System.out.println("Error: " + e.getMessage() + "\n");
                            continue;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            input.nextLine();
                            continue;
                        }
                    }
                    //------------------------------------------------------------------------------------
                    //------------------------------------------------------------------------------------

                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Enter a valid option\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input type\n");
                input.nextLine();
            }
        }
    }
}

