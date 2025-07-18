#include <iostream>
#include <fstream>

class Student {
protected:
    std::string name;

public:
    Student(const std::string& name) {
        this->name = name;
    }
    virtual ~Student() {}
    virtual double calculateGPA(int numCourses, double* grades) const = 0;
    virtual std::string getTranscript(int numCourses, double* grades) const = 0;
};

class Undergraduate : public Student {
public:
    Undergraduate(const std::string& name) : Student(name) {}
    double calculateGPA(int numCourses, double* grades) const override {
        double total = 0;
        for (int x = 0; x < numCourses; ++x) {
            total += grades[x];
        }
        return total / numCourses;
    }
    std::string getTranscript(int numCourses, double* grades) const override {
        return "Undergraduate: " + name + "\nGPA: " + std::to_string(calculateGPA(numCourses, grades)) + "\n";
    }
};

class Graduate : public Student {
public:
    Graduate(const std::string& name) : Student(name) {}
    double calculateGPA(int numCourses, double* grades) const override {
        double total = 0;
        for (int x = 0; x < numCourses; ++x) {
            total += grades[x] * 1.1;
        }
        return total / numCourses;
    }
    std::string getTranscript(int numCourses, double* grades) const override {
        return "Graduate: " + name + "\nGPA: " + std::to_string(calculateGPA(numCourses, grades)) + "\n";
    }
};

int main() {
    std::ifstream infile("students.txt");
    std::ofstream outfile("transcripts.txt");

    if (!infile || !outfile) {
        std::cerr << "Error opening files." << std::endl;
        return 1;
    }

    Student** students = nullptr;
    int capacity = 0, count = 0;
    std::string type, name;
    int numCourses;

    while (infile >> type >> name >> numCourses) {
        double* grades = new double[numCourses];
        for (int x = 0; x < numCourses; ++x) {
            infile >> grades[x];
        }

        Student* s = nullptr;
        if (type == "Undergraduate") {
            s = new Undergraduate(name);
        } else if (type == "Graduate") {
            s = new Graduate(name);
        } else {
            std::cerr << "Unknown student type: " << type << std::endl;
            delete[] grades;
            continue;
        }
        
        if (s != nullptr) {
            if (count >= capacity) {
                int newCapacity;
                if (capacity == 0) {
                    newCapacity = 2;
                } else {
                    newCapacity = capacity * 2;
                }
                Student** newStudents = new Student*[newCapacity];
                for (int x = 0; x < count; ++x) {
                    newStudents[x] = students[x];
                }
                delete[] students;
                students = newStudents;
                capacity = newCapacity;
            }
        }
        students[count++] = s;
        outfile << s->getTranscript(numCourses, grades) << "\n";
        delete[] grades;
    }

    for (int i = 0; i < count; ++i) {
        delete students[i];
    }
    delete[] students;
    infile.close();
    outfile.close();
    return 0;
}
