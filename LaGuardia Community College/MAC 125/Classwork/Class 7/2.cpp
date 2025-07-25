#include <iostream>

int main() {
    float num, denom;
    std::cout << "Enter numerator: ";
    std::cin >> num;
    std::cout << "Enter denominator: "; 
    std::cin >> denom;

    try {
        if (denom == 0) {
            throw std::runtime_error("Denominator cannot be zero.");
        }
        float result = num / denom;
        std::cout << "Result: " << result << "\n";
    }
    catch (const std::runtime_error& e) {
        std::cout << e.what() << "\n";
    }
    return 0;
}