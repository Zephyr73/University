#include "shapes.h"

namespace shapes {
    Circle::Circle(double r) {
        radius = r;
    }
    double Circle::area() const {
        return 3.14159 * radius * radius;
    }

    Square::Square(double s) {
        side = s;
    }
    double Square::area() const {
        return side * side;
    }
}