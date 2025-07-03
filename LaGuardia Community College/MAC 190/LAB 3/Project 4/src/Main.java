import java.util.Scanner;

class Circle {
    private double radius;

    public Circle() {
        this.radius = 0;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Circle circle = new Circle();

        System.out.print("Enter radius: ");
        circle.setRadius(input.nextDouble());

        System.out.println();
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Circumference: " + circle.getCircumference());
    }
}

