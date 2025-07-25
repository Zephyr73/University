import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
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
                if (choice == 1) {
                    while (true) {
                        System.out.println("Admin Mode");
                        System.out.println("|__ 1. Set Seat Rows");
                        System.out.println("|__ 2. View Seat Rows");
                        System.out.println("|__ 3. Cancel Seats");
                        System.out.println("|__ 4. View CustomerDetails.txt");
                        System.out.println("|__ 5. Go Back");
                        System.out.print("Choice: ");
                        
                        try {
                            int adminChoice = input.nextInt();
                            input.nextLine();
                            System.out.println();

                            if (adminChoice == 1) {
                                System.out.print("Enter number of Rows: ");
                                int rows = input.nextInt();
                                input.nextLine();
                                if (flight == null) {
                                    flight = new Flight(rows);
                                    System.out.println("Seat rows set to " + rows + "\n");
                                } else {
                                    System.out.println("Seat rows already set\n");
                                }
                            } else if (adminChoice == 2) {
                                if (flight == null) {
                                    throw new FlightNotFoundException("Flight not found. Please set seat rows first\n");
                                } else {
                                    admin.displayAdmin(flight.getSeatMap());
                                    System.out.println();
                                }
                            } else if (adminChoice == 3) {
                                if (flight == null) {
                                    System.out.println("Seat map not initialized\n");
                                } else {
                                    System.out.print("Enter row number to cancel: ");
                                    String cancelSeat = input.nextLine().toUpperCase();
                                    admin.cancelReservation(cancelSeat, flight);
                                }
                            } else if (adminChoice == 4) {
                                continue;
                            } else if (adminChoice == 5) {
                                System.out.println("Returning to main menu...\n");
                                break;
                            } else {
                                System.out.println("Invalid choice. Please try again.\n");
                            }
                        } catch (FlightNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            input.nextLine();
                            continue;
                        }
                    }
                    //------------------------------------------------------------------------------------
                
                //--------------------------------[Passenger Menu Choices]--------------------------------
                } else if (choice == 2) {
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
                                        throw new FlightNotFoundException("Seat map not initialized. Please set seat rows first\n");
                                    }
                                    flight.displaySeats();
                                    System.out.println();

                                } else if (passengerChoice == 2) {
                                    if (flight == null) {
                                        throw new FlightNotFoundException("Seat map not initialized. Please set seat rows first\n");
                                    }

                                    System.out.print("Enter seat row to book: ");
                                    String seat = input.nextLine().toUpperCase();
                                    if (seat.isEmpty()) {
                                        System.out.println("Seat row cannot be empty. Please try again.\n");
                                        continue;
                                    }
                                    if (seat.length() < 2) {
                                        System.out.println("Invalid seat format. Please enter a valid seat row\n");
                                        continue;
                                    }
                                    int row = flight.getSeatMap().getRow(seat);
                                    char seatLetter = flight.getSeatMap().getSeatLetter(seat);
                                    
                                    if ("ABCD".indexOf(seatLetter) == -1) {
                                        throw new InvalidInputException("Invalid seat letter. Please enter a valid seat row\n");
                                    }
                                    if (row < 0 || row >= flight.getSeatMap().getRows()) {
                                        throw new InvalidInputException("Invalid seat row number. Please enter a valid seat row\n");
                                    }
                                    if (!flight.getSeatMap().isSeatAvailable(row, flight.getSeatMap().getColumn(seat))) {
                                        throw new InvalidInputException("Seat " + seat + " is already booked. Please choose another seat\n");
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
                                    flight.reserveSeat(p, row, seatLetter);
                                    System.out.println("Seat " + seat + " booked successfully for " + p.getName() + ".\n");

                                } else if (passengerChoice == 3) {
                                    System.out.println("Returning to main menu...\n");
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Please try again.\n");
                                }
                            } catch (FlightNotFoundException | InvalidInputException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.\n");
                            input.nextLine();
                            continue;
                        }
                    }
                //------------------------------------------------------------------------------------
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
                continue;
            }
        }
    }
}