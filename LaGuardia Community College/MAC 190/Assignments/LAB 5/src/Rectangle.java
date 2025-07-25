public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void displayShape() {
        System.out.println("Shape: Rectangle");
    }

    public double getArea() {
        return width * height;
    }
}
