#include <iostream>

template <typename T>
T findMax(T a, T b, T c) {
    T max = a;
    if (b > max) {
        max = b;
    }
    if (c > max) {
        max = c;
    }
    return max;
}

int main() {
    std::cout << "Max of 3, 5, 2: " << findMax(3, 5, 2) << "\n";
    std::cout << "Max of 3.5, 2.1, 4.8: " << findMax(3.5, 2.1, 4.8) << "\n";
    std::cout << "Max of 'apple', 'banana', 'cherry': " << findMax(std::string("apple"), std::string("banana"), std::string("cherry")) << "\n";
    return 0;
}