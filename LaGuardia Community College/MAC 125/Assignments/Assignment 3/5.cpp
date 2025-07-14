#include <iostream>

int main() {
    std::string usr_input;
    std::string reversed_input;
    std::cout << "Enter a string: ";
    std::getline(std::cin, usr_input);

    for (int x = usr_input.length() - 1; x >= 0; x--) {
        reversed_input += usr_input[x];
    }
    if (usr_input == reversed_input) {
        std::cout << "The string is a palindrome." << std::endl;
    } else {
        std::cout << "The string is not a palindrome." << std::endl;
    }
}