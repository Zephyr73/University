#include "fraction.h"
#include <iostream>

int main() {
    Fraction f1(3, 4);
    Fraction f2(7, 8);
    
    std::cout << "Fraction 1: " << f1 << std::endl;
    std::cout << "Fraction 2: " << f2 << std::endl;

    if (isEqual(f1, f2)) {
        std::cout << "The fractions are equal." << std::endl;
    } else {
        std::cout << "The fractions are not equal." << std::endl;
    }

    return 0;
}