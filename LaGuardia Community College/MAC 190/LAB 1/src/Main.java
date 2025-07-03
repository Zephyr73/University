import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner usr_input = new Scanner(System.in);

        //Part 1 - Convert Fahrenheit to Celcius
        System.out.print("Enter temperature in Fahrenheit: ");
        float temp = usr_input.nextInt();
        System.out.println("Temperature in Celcius: " + ((temp-32)*5/9));

        //Part 2 - Swap values of A and B
        int a = 5, b = 10, temp1 = a;
        System.out.println("A = " + a);
        System.out.println("B = " + b);

        a = b;
        b = temp1;

        System.out.println("A = " + a);
        System.out.println("B = " + b);
    }
}