import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary to convert to decimal: ");
        String usr_input = input.nextLine();
        int decimal = 0;

        for (int x = 0; x < usr_input.length(); x++) {
            Character ch = usr_input.charAt(x);
            int integer = Character.getNumericValue(ch);
            decimal = decimal + (integer * (int)Math.pow(2, (usr_input.length() - 1) - x));
        }
        System.out.println("Decimal: " + decimal);
    }
}