#include <iostream>
#include <string>
using namespace std;


class Vehicle {
protected:
    string brand;
    string model;

public:
    Vehicle(string b, string m) : brand(b), model(m) {}

    virtual void displayDetails() {
        cout << "Brand: " << brand << ", Model: " << model << endl;
    }
};


class Car : public Vehicle {
private:
    int numDoors;

public:
    Car(string b, string m, int doors) : Vehicle(b, m), numDoors(doors) {}

    void displayDetails() override {
        cout << "Brand: " << brand << ", Model: " << model << ", Number of Doors: " << numDoors << endl;
    }
};


int main() {
    Vehicle v("Toyota", "Camry");
    Car c("Honda", "Civic", 4);

    cout << "Vehicle details:\n";
    v.displayDetails();

    cout << "\nCar details:\n";
    c.displayDetails();

    return 0;
}
