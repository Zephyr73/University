#include <iostream>

int main() { 
    std::string usr_input;
    std::cout << "Enter a string: ";
    std::getline(std::cin, usr_input);

    for (int x = 0; x < usr_input.length(); x++) {
        if (usr_input[x] == 'x') {
            usr_input[x] = 'a';
        }
    }
    std::cout << "Modified string: " << usr_input << std::endl;
}