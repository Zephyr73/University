import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalPrice = 0.0;
        try {

            FileWriter writer = new FileWriter("output.txt", true);
            // I used 3 inputs only
            for (int x = 0; x < 3; x++) {
                System.out.print("Enter Item name: ");
                String item = input.nextLine();
                System.out.print("Enter item price: ");
                double price = input.nextDouble();
                System.out.print("Enter item quantity: ");
                int quantity = input.nextInt();
                input.nextLine();
                totalPrice = totalPrice + (price * quantity);

                writer.write("Item name: " + item + " Price: $" + price + " Quantity: " + quantity + "\n");
            }
            writer.write("Total Price: " + totalPrice + "\n");
            writer.close();
            System.out.println("Total Price: " + totalPrice + "\n");
        } catch (IOException e) {
            System.out.println("Couldnt write");
        }
    }
}