import java.util.Scanner;

public class CountPoor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of families: ");
        int k = input.nextInt();
        System.out.println();

        Family[] families = new Family[k]; //Creates array for families
        for (int x = 0; x < k; x++) {
            System.out.print("Enter family income: $");
            double income = input.nextDouble();
            System.out.print("Enter family size: ");
            int size = input.nextInt();
            families[x] = new Family(income, size);
            System.out.println();
        }

        System.out.print("Enter average housing cost: $");
        double housingCost = input.nextDouble();
        System.out.print("Enter food cost per person: $");
        double foodCost = input.nextDouble();

        System.out.println("\nPoor Families: ");
        for (Family family : families) {
            if (family.isPoor(housingCost, foodCost)) {
                System.out.println(family.toString());
            }
        }
    }
}