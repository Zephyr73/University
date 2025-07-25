import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num, denom;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        num = input.nextInt();
        System.out.print("Enter denominator: ");
        denom = input.nextInt();

        try {
            int result = num / denom;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cant divide by zero");
        }
    }
}