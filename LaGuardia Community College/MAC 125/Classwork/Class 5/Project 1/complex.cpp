#include "complex.h"
#include <complex.h>

Complex::Complex() {
    real = 0.0;
    imag = 0.0;
}

Complex::Complex(double r, double i) {
    real = r;
    imag = i;
}

Complex Complex::operator+(const Complex& other) const {
    return Complex(real + other.real, imag + other.imag);
}
Complex Complex::operator*(const Complex& other) const {
    double r = real * other.real - imag * other.imag;
    double i = real * other.imag + imag * other.real;
    return Complex(r, i);
}

std::ostream& operator<<(std::ostream& out, const Complex& c) {
    out << c.real;
    if (c.imag >= 0) {
        out << " + " << c.imag << "i";
    } else {
        out << " - " << -c.imag << "i";
    }
    return out;
}