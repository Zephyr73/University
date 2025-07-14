// This code added a function "isEqual" to compare two objects. Most of the code is the same as Class 3/Project 2

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

    public boolean isEqual(Car other) {
        return(this.make.equals(other.make) && this.model.equals(other.model) && this.year == other.year);
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

        System.out.print("Enter Car Brand: ");
        make = input.nextLine();
        System.out.print("Enter Car Model: ");
        model = input.nextLine();
        System.out.print("Enter Car Year: ");
        year = input.nextInt();
        input.nextLine();

        Car myCar3 = new Car(make, model, year);
        myCar3.print();

        System.out.println(myCar.isEqual(myCar2));
        System.out.println(myCar.isEqual(myCar3));
        System.out.println(myCar2.isEqual(myCar3));
    }
}