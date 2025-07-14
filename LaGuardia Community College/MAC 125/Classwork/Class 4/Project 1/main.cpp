#include <complex.h>
#include <iostream>
#include "complex.h"

int main() {
    Complex c1(3.0, 4.0);
    Complex c2(1.0, 2.0);
    Complex sum = c1 + c2;
    Complex product = c1 * c2;

    std::cout << "Sum: " << sum << std::endl;
    std::cout << "Product: " << product << std::endl;
    return 0;
}