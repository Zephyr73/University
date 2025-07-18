public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void displayShape() {
        System.out.println("Shape: Circle");
    }

    public double getArea() {
        return Math.PI * (radius * radius);
    }
}
