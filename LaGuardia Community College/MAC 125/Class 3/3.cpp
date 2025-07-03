#include <iostream>

class Rectangle {
    public:
        Rectangle(int l, int w) {
            length = l;
            width = w;
        } 

        Rectangle() {
            length = 1;
            width = 1;
        }

        int area() {
            return length * width;
        }

    private:
        int length;
        int width;
};

int main() {
    int l, w;
    
    std::cout << "Enter length and width of the rectangle: ";
    std::cin >> l >> w;
    Rectangle rect1(l, w);
    std::cout << "created rectangle 1 with length " << l << " and width " << w << "\n";
    std::cout << "Area of rectangle 1: " << rect1.area() << "\n";

    Rectangle rect2;
    std::cout << "created rectangle 2 with default values\n";
    std::cout << "Area of rectangle 2 (default): " << rect2.area() << "\n";
    return 0;
}