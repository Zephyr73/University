#include <iostream>
#include <cmath>
using namespace std;


class Shape {
public:
    virtual double area() const = 0;
    virtual ~Shape() {} 
};

class Rectangle : public Shape {
private:
    double length, width;

public:
    Rectangle(double l, double w) : length(l), width(w) {}

    double area() const override {
        return length * width;
    }
};


class Circle : public Shape {
private:
    double radius;

public:
    Circle(double r) : radius(r) {}

    double area() const override {
        return M_PI * radius * radius;
    }
};


int main() {
    Shape* shape;

    Rectangle rectangle(5.0, 3.0);
    Circle circle(4.0);

    shape = &rectangle;
    cout << "Area of Rectangle: " << shape->area() << endl;

    shape = &circle;
    cout << "Area of Circle: " << shape->area() << endl;

    return 0;
}
