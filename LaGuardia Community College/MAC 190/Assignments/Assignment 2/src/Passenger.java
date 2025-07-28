import java.util.InputMismatchException;
import java.util.Scanner;

public class Passenger extends Person {
    private String seatNumber;

    public Passenger(String name, String ssn, String address, int age, String contact, String seatNumber) {
        super(name, ssn, address, age, contact);
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
    public static void launchPassengerMenu(Scanner input, Flight flight) {
        while (true) {
            System.out.println("Passenger Mode");
            System.out.println("--- Entered Passenger menu ---");
            System.out.println("|__ 1. View Seat Layout");
            System.out.println("|__ 2. Book Seat");
            System.out.println("|__ 3. Go Back");
            System.out.print("Choice: ");

            try {
                int passengerChoice = input.nextInt();
                input.nextLine();
                System.out.println();

                try {
                    if (passengerChoice == 1) {
                        if (flight == null) {
                            throw new FlightNotFoundException("Seat map not initialized. Set seats in Admin mode\n");
                        }
                        flight.displaySeats();
                        System.out.println();

                    } else if (passengerChoice == 2) {
                        if (flight == null) {
                            throw new FlightNotFoundException("Seat map not initialized. Set seats in Admin mode\n");
                        }

                        if (flight.isFlightFull()) {
                            throw new SeatNotAvailableException("Flight is full");
                        } else {
                            String seat;
                            while (true) {
                                try {
                                    System.out.print("Enter Seat number to book: ");
                                    seat = input.nextLine().toUpperCase();
                                    if (seat.isEmpty()) {
                                        System.out.println("Seat number cannot be empty. Please try again.\n");
                                        continue;
                                    }
                                    if (seat.equals("-1")) {

                                    }
                                    if (!seat.matches("\\d+[A-Z]")) {
                                        throw new InvalidInputException("Invalid seat format");
                                    }
                                    int row = flight.getSeatMap().getRow(seat);
                                    char col = flight.getSeatMap().getSeatLetter(seat);

                                    if (row < 0 || row >= flight.getSeatMap().getRows()) {
                                        throw new InvalidInputException("Invalid seat row number\n");
                                    }
                                    if (col < 'A' || col > 'D') {
                                        throw new InvalidInputException("Invalid seat column number\n");
                                    }
                                    if (!flight.getSeatMap().isSeatAvailable(row, flight.getSeatMap().getColumn(seat))) {
                                        throw new SeatNotAvailableException("Seat " + seat + " is already booked");
                                    }
                                    break;
                                } catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                } catch (SeatNotAvailableException e) {
                                    System.out.println();
                                    flight.displaySeats();
                                    System.out.println(e.getMessage());
                                    flight.getSeatMap().getAvailableSeats();
                                    System.out.println();
                                }
                            }


                            String name;
                            while (true) {
                                System.out.print("Enter passenger name: ");
                                name = input.nextLine();
                                try {
                                    if (name.trim().isEmpty()) {
                                        throw new InvalidInputException("Name cannot be empty. Please try again.");
                                    }
                                    break;
                                } catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            String ssn;
                            while (true) {
                                System.out.print("Enter passenger SSN: ");
                                ssn = input.nextLine();
                                try {
                                    if (ssn.trim().isEmpty()) {
                                        throw new InvalidInputException("SSN cannot be empty. Please try again.");
                                    }
                                    break;
                                } catch (InvalidInputException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            String address;
                            while (true) {
                                System.out.print("Enter passenger address: ");
                                address = input.nextLine();
                                try {
                                    if (address.trim().isEmpty()) {
                                        throw new InvalidAddressException("Address cannot be empty. Please try again.");
                                    }
                                    break;
                                } catch (InvalidAddressException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            int age;
                            while (true) {
                                System.out.print("Enter passenger age: ");
                                try {
                                    age = input.nextInt();
                                    input.nextLine();
                                    if (age > 0) {
                                        break;
                                    } else {
                                        System.out.println("Age must be a positive number. Please try again.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid age.");
                                    input.nextLine();
                                }
                            }

                            String contact;
                            while (true) {
                                System.out.print("Enter passenger contact number: ");
                                contact = input.nextLine();
                                try {
                                    if (contact.trim().isEmpty()) {
                                        throw new InvalidPhoneException("Contact number cannot be empty. Please try again.");
                                    }
                                    break;
                                } catch (InvalidPhoneException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            Passenger p = new Passenger(name, ssn, address, age, contact, seat);
                            flight.reserveSeat(p, seat);
                            System.out.println("Seat " + seat + " booked successfully for " + p.getName() + ".\n");
                        }

                    } else if (passengerChoice == 3) {
                        System.out.println("Returning to main menu...\n");
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.\n");
                    }
                } catch (FlightNotFoundException | InvalidInputException e) {
                    System.out.println(e.getMessage());
                } catch (SeatNotAvailableException e) {
                    System.out.println();
                    flight.displaySeats();
                    System.out.println(e.getMessage());
                    flight.getSeatMap().getAvailableSeats();
                    System.out.println();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number\n");
                input.nextLine();
                continue;
            }
        }
    }
}
