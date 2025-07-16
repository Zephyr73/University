#include <iostream>
#include <fstream>

class Employee {
    protected:
        std::string name;
    public:
        Employee(const std::string& n) {
            name = n;
        }
        virtual ~Employee() {
            std::cout << "Employee destructor called for " << name << std::endl;
        }
        virtual double calculateSalary() const = 0;
        virtual std::string getInfo() const = 0;
};

class FullTimeEmployee : public Employee {
    double monthlySalary;
    public:
        FullTimeEmployee(const std::string& n, double salary) : Employee(n) {
            monthlySalary = salary;
        }
        double calculateSalary() const override {
            return monthlySalary;
        }
        std::string getInfo() const override {
            return "Full time salary of " + name + ": " + std::to_string(calculateSalary());
        }
};

class PartTimeEmployee : public Employee {
    double hourlyRate;
    double hoursWorked;
    public:
        PartTimeEmployee(const std::string& n, double rate, double hours) : Employee(n) {
            hourlyRate = rate;
            hoursWorked = hours;
        }
        double calculateSalary() const override {
            return hourlyRate * hoursWorked;
        }
        std::string getInfo() const override {
            return "Part time salary of " + name + ": " + std::to_string(calculateSalary());
        }
};

int main() {
    std::ifstream infile("employees.txt");
    std::ofstream outfile("salaries.txt");

    if (!infile || !outfile) {
        std::cerr << "Error opening files." << std::endl;
        return 1;
    }

    Employee** employees = nullptr;
    int capacity = 0;
    int count = 0;

    std::string type, name;;
    while(infile >> type >> name) {
        Employee* emp = nullptr;
        if (type == "FullTime") {
            double salary;
            if (!(infile >> salary)) {
                std::cerr << "Error reading salary for full-time employee." << std::endl;
                continue;
            }
            emp = new FullTimeEmployee(name, salary);
        }
        else if (type == "PartTime") {
            double rate, hours;
            if (!(infile >> rate >> hours)) {
                std::cerr << "Error reading rate and hours for part-time employee." << std::endl;
                continue;
            }
            emp = new PartTimeEmployee(name, rate, hours);
        }
        else {
            std::cerr << "Unknown employee type: " << type << std::endl;
            continue;
        }
        if (emp != nullptr) {
            if (count >= capacity) {
                int newCapacity;
                if (capacity == 0) {
                    newCapacity = 2;
                } else {
                    newCapacity = capacity * 2;
                }
                Employee** newArr = new Employee*[newCapacity];
                for (int x = 0; x < count; ++x) {
                    newArr[x] = employees[x];
                }
                delete[] employees;
                employees = newArr;
                capacity = newCapacity;
            }
            employees[count++] = emp;
        }
    }
    for (int x = 0; x < count; ++x) {
        outfile << (*employees[x]).getInfo() << std::endl;
    }
    for (int x = 0; x < count; ++x) {
        delete employees[x];
    }
    delete[] employees;
    infile.close();
    outfile.close();
    return 0;
}