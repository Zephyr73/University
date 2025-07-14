#ifndef complex_h
#define complex_h
#include <iostream>

class Complex {
private:
    double real;
    double imag;
public:
    Complex();
    Complex(double r, double i);

    Complex operator+(const Complex& other) const;
    Complex operator*(const Complex& other) const;
    
    friend std::ostream& operator<<(std::ostream& os, const Complex& c);
    #endif
};