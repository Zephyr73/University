#include <iostream>
using namespace std;

float add(float a, float b) {
    return a + b;
}

float subtract(float a, float b) {
    return a - b;
}

float multiply(float a, float b) {
    return a * b;
}

float divide(float a, float b) {
    if (b != 0)
        return a / b;
    else {
        cout << "Error" << endl;
        return 0;
    }
}

int main() {
    float num1, num2, result;
    char op;

    cout << "Enter expression: ";
    cin >> num1 >> op >> num2;

    switch (op) {
        case '+':
            result = add(num1, num2);
            cout << "Result: " << result;
            break;
        case '-':
            result = subtract(num1, num2);
            cout << "Result: " << result;
            break;
        case '*':
            result = multiply(num1, num2);
            cout << "Result: " << result;
            break;
        case '/':
            result = divide(num1, num2);
            cout << "Result: " << result;
            break;
        default:
            cout << "Invalid operator";
    }

    return 0;
}
