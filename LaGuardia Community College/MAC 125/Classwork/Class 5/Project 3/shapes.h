#ifndef shapes_h
#define shapes_h
#include <iostream>

namespace shapes {
    class Circle {
    private:
        double radius;
    public:
        Circle(double r);
        double area() const;
    };
    class Square {
    private:
        double side;
    public:
        Square(double s);
        double area() const;
    };
}
#endif