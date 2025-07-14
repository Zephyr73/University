#include "shapes.h"
#include <iostream>

using namespace shapes;

int main() {
    Circle c(5.0);
    Square s(4.0);

    std::cout << "Area of Circle with radius 5.0: " << c.area() << std::endl;
    std::cout << "Area of Square with side 4.0: " << s.area() << std::endl;
    return 0;   
}