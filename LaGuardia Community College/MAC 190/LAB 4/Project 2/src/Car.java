import java.util.Scanner;

public class Car {
    private String make;
    private String model;
    private int year;

    public Car (String carMake, String carModel, int carYear) {
        this.make = carMake;
        this.model = carModel;
        this.year = carYear;
    }

    public Car () {
        this.make = "";
        this.model = "";
        this.year = 0;
    }

    public void print() {
        System.out.println();
        System.out.println("Car Brand: " +this.make);
        System.out.println("Car Model: " +this.model);
        System.out.println("Car Year: " +this.year);
        System.out.println();
    }

    public void setMake(String carMake) {
        this.make = carMake;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Car Brand: ");
        String make = input.nextLine();
        System.out.print("Enter Car Model: ");
        String model = input.nextLine();
        System.out.print("Enter Car Year: ");
        int year = input.nextInt();
        input.nextLine();

        Car myCar = new Car(make, model, year);
        myCar.print();

        Car myCar2 = new Car();
        System.out.print("Enter Car brand: ");
        myCar2.setMake(input.nextLine());
        myCar2.print();
    }
}