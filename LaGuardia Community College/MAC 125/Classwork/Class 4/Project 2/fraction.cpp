#include "fraction.h"
#include <iostream>

Fraction::Fraction() {
    numerator = 0;
    denominator = 1;
}
Fraction::Fraction(int num, int denom) {
    if (denom == 0) {
        std::cout << "Denominator cannot be zero. Setting to 1.\n";
        denominator = 1;
        numerator = num;
    } else {
        numerator = num;
        denominator = denom;
    }
    simplify();
}

int Fraction::gcd(int a, int b) const {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

void Fraction::simplify() {
    if (denominator < 0) {
        numerator = -numerator;
        denominator = -denominator;
    }
    int divisor = gcd(abs(numerator), abs(denominator));
    numerator = numerator / divisor;
    denominator = denominator / divisor;
}

bool isEqual(const Fraction& f1, const Fraction& f2) {
    Fraction a = f1;
    Fraction b = f2;
    a.simplify();
    b.simplify();
    return (a.numerator == b.numerator && a.denominator == b.denominator);
}

std::ostream& operator<<(std::ostream& out, const Fraction& f) {
    out << f.numerator << "/" << f.denominator;
    return out;
}