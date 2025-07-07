import java.util.Scanner;

public class Driving {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter age: ");
        int usr_input = input.nextInt();

        if (usr_input >= 16 && usr_input <= 80) {
            System.out.println("You are eligible for the DL test");
        } else if (usr_input == 15) {
            System.out.println("Come back next year");
        } else if (usr_input <= 14) {
            System.out.printf("Come back in %s years", 16-usr_input);
        } else if (usr_input > 80 && usr_input < 100) {
            System.out.println("You are not eligible");
        } else {
            System.out.println("Enter a valid age");
        }
    }
}