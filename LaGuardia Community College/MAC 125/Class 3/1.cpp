#include <iostream>

struct Student {
    std::string name;
    int roll;
    float marks;
};

int main() {
    Student students[3];
    std::cout << "Enter details of 3 students (name, roll number, marks):\n";
    for (int x = 0; x < 3; x++) {
        std::cout << "Student " << (x + 1) << ":\n";
        std::cout << "Name: ";
        std::cin >> students[x].name;
        std::cout << "Roll Number: ";
        std::cin >> students[x].roll;
        std::cout << "Marks: ";
        std::cin >> students[x].marks;
    }

    std::cout << "\nStudents with marks greater than 50:\n";
    for (int x = 0; x < 3; x++) {
        if (students[x].marks > 50) {
            std::cout << "\nStudent " << (x + 1) << " Details:\n";
            std::cout << "Name: " << students[x].name << "\n";
            std::cout << "Roll Number: " << students[x].roll << "\n";
            std::cout << "Marks: " << students[x].marks << "\n";
        }
    }
}