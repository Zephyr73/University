import java.util.Scanner;

public class Pet {
    private String type;
    private String name;
    private String breed;
    private double weight;

    public Pet(String type, String name, String breed, double weight) {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String canFly(String type){
        if (type.equalsIgnoreCase("bird")) {
            return type + " can fly";
        } else {
            return type + " cannot fly";
        }
    }

    public String canBarkOrSing(String type) {
        if (type.equalsIgnoreCase("bird")) {
            return type + " can sing";
        } else if (type.equalsIgnoreCase("dog")) {
            return type + " can bark";
        } else {
            return type + " cannot bark or sing";
        }
    }

    public void printDetails() {
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Weight: " + weight + "Kg");
        System.out.println(canFly(type));
        System.out.println(canBarkOrSing(type));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pet[] pets = new Pet[4];
        for (int x = 0; x < 4; x++) {
            System.out.print("Enter Pet type: ");
            String type = input.nextLine();
            System.out.print("Enter Pet name: ");
            String name = input.nextLine();
            System.out.print("Enter Pet breed: ");
            String breed = input.nextLine();
            System.out.print("Enter Pet weight: ");
            double weight = input.nextDouble();
            input.nextLine();
            System.out.println();
            pets[x] = new Pet(type, name, breed, weight);
        }
        for (Pet pet : pets) {
            pet.printDetails();
        }
    }
}