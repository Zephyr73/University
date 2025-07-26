public class SeatMap {
    private Passenger[][] seats;
    private int rows;

    public SeatMap(int rows) {
        this.rows = rows;
        this.seats = new Passenger[rows][4];
    }

    public void assignPassenger(int row, int col, Passenger passenger) {
        seats[row][col] = passenger;
    }
    public void clearSeat(int row, int col) {
        seats[row][col] = null;
    }
    public boolean isSeatAvailable(int row, int col) {
        return seats[row][col] == null;
    }

    public int getRows() {
        return rows;
    }
    public int getRow(String seatNumber) {
        if (seatNumber == null || seatNumber.length() < 2 ) {
            throw new InvalidInputException("Invalid seat format.");
        }
        return Integer.parseInt(seatNumber.substring(0, seatNumber.length() - 1)) - 1;
    }
    public int getColumn(String seatNumber) {
        if (seatNumber == null || seatNumber.length() < 2 ) {
            throw new InvalidInputException("Invalid seat format.");
        }
        return (int) getSeatLetter(seatNumber) - 'A';
    }
    public char getSeatLetter(String seatNumber) {
        if (seatNumber == null || seatNumber.length() < 2 ) {
            throw new InvalidInputException("Invalid seat format.");
        }
        return seatNumber.charAt(seatNumber.length() - 1);
    }
    public void getAvailableSeats() {
        int count = 0;
        System.out.print("Available Seats:\n");
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < 4; y++) {
                if (isSeatAvailable(x, y)) {
                    System.out.print(String.valueOf(x+1) + (char) ('A' + y) + " ");
                    count++;
                    if (count % 3 == 0) {
                        System.out.println();
                    }
                }
            }
        }
        System.out.println();
    }

    private int maxLength() {
        int maxLength = 2;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < 4; y++) {
                if (seats[x][y] != null && seats[x][y].name.length() > maxLength) {
                    maxLength = seats[x][y].name.length();
                }
            }
        }
        return Math.max(maxLength, 2);
    }

    public void displaySeats() {
        System.out.printf("%-5s| %s%n", "Row", "Seats");
        System.out.println("--------------------");
        for (int x = 0; x < rows; x++) {
            System.out.printf("%-5d| ", x + 1);
            for (int y = 0; y < 4; y++) {
                if (seats[x][y] == null) {
                    System.out.printf("%-3s", (char) ('A' + y));
                } else {
                    System.out.printf("%-3s", "X");
                }
                if (y == 1) {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }

    public void displayAdmin() {
        System.out.printf("%-5s| %s%n", "Row", "Seats");
        System.out.println("-".repeat(5 + 2 + ((maxLength()+1) * 4) + 3));
        for (int x = 0; x < rows; x++) {
            System.out.printf("%-5d| ", x + 1);
            for (int y = 0; y < 4; y++) {
                if (seats[x][y] != null) {
                    System.out.printf("%-" + (maxLength()+1) + "s", seats[x][y].name + " ");
                } else {
                    System.out.printf("%-" + (maxLength()+1) + "s", (char) ('A' + y));
                }
                if (y == 1) {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }
}
