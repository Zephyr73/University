public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(4, 5);
        rect.displayShape();
        System.out.println("Area: " + rect.getArea() + "\n");

        Shape circle = new Circle(5.5) ;
        circle.displayShape();
        System.out.println("Area: " + circle.getArea());
    }
}