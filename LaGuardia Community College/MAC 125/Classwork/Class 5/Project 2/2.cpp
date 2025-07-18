#include <iostream>
#include <fstream>

class Shape {
    protected:
    std::string shape;
    public:
    Shape(const std::string& s) {
        shape = s;
    }
    virtual ~Shape(){
        std::cout << "Shape destrctor\n";
    }
    virtual double area() const = 0;
    virtual std::string getInfo() const = 0;
};

class Circle : public Shape {
    double radius;
    public:
        Circle(const std::string& s, double radius) : Shape(s) {
            this->radius = radius;
        }
        double area() const override {
            return 3.14*(radius * radius);
        }
        std::string getInfo() const override {
            return "Circle radius: " + std::to_string(radius) + "\n" +
                    "Area: " + std::to_string(area());
        }
};

class Rectangle : public Shape {
    double side;
    double length;
    public:
        Rectangle(const std::string& s, double side, double length) : Shape(s) {
            this->side = side;
            this->length = length;
        }
        double area() const override {
            return side * length;
        }
        std::string getInfo() const override {
            return "Rectangle side: " + std::to_string(side) + "\n" +
                    "Rectangle length: " + std::to_string(length) + "\n" +
                    "Area: " + std::to_string(area());
        }
};

int main() {
    std::ifstream infile("shapes.txt");
    std::ofstream outfile("areas.txt");

    if (!infile || !outfile) {
        std::cerr << "Error opening files." << std::endl;
        return 1;
    }

    Shape** shapes= nullptr;
    int capacity = 0;
    int count = 0;

    std::string shape;
    while(infile >> shape) {
        Shape* shp = nullptr;
        if (shape == "Circle") {
            double radius;
            if (!(infile >> radius)) {
                std::cout << "Couldnt find radius";
                continue;
            }
            shp = new Circle(shape, radius);
        } else if (shape == "Rectangle") {
            double side;
            double length;
            if (!(infile >> side >> length)) {
                std::cout << "Couldnt find side or length";
                continue;
            }
            shp = new Rectangle(shape, side, length);
        } else {
            std::cout << "Unknown shape";
            continue;
        }
        if (shp != nullptr) {
            if (count >= capacity) {
                int newCapacity;
                if (capacity == 0) {
                    newCapacity = 2;
                } else {
                    newCapacity = capacity * 2;
                }
                Shape** newArr = new Shape*[newCapacity];
                for (int x = 0; x < count; ++x) {
                    newArr[x] = shapes[x];
                }
                delete[] shapes;
                shapes = newArr;
                capacity = newCapacity;
            }
            shapes[count++] = shp;
        }
    }
    for (int x = 0; x < count; ++x) {
        outfile << (*shapes[x]).getInfo() << "\n";
    }
    for (int x = 0; x < count; ++x) {
        delete shapes[x];
    }
    delete[] shapes;
    infile.close();
    outfile.close();
    return 0;
}
