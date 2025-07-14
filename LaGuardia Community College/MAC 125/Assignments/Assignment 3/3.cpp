#include <iostream>

int main() {
    std::string usr_input;
    std::cout << "Enter a string: ";
    std::getline(std::cin, usr_input);

    int word_count = 0;
    bool flag = false;
    for (int x = 0; x < usr_input.length(); x++) {
        if (usr_input[x] != ' ' && usr_input[x] != '\0' && usr_input[x] != '\n' && usr_input[x] != '\t' ) {
            if (!flag) {
                word_count++;
                flag = true;
            }
        } else {
            flag = false;
        }
    }
    std::cout << "Number of words: " << word_count << std::endl;
    return 0;
}