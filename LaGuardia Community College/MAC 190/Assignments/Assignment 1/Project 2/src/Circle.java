import java.util.Scanner;

public class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * (radius * radius);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Boolean contains(double x, double y) {
        //Formula to check if coordinates are within the circle
        if ((Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2))) <= this.radius) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean overlaps(Circle other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double distance = Math.sqrt((dx * dx) + (dy * dy)); //Formula to find distance between two centers
        return distance <= (this.radius + other.radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2, 2, 5.5);
        System.out.println("Coordinates of C1: " + "(" + c1.getX() + ", " + c1.getY() + ") ");
        System.out.println("Radius of C1: " + c1.getRadius());
        System.out.println("Area of C1: " + c1.getArea());
        System.out.println("Perimeter of C1: " + c1.getPerimeter());
        System.out.println("Does C1 contain coordinates?: " + c1.contains(3, 3));
        System.out.println("Does C1 overlap with new circle?: " +c1.overlaps(new Circle(3, 5, 2.3)));
    }
}


