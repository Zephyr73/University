#include <iostream>
#include <string>
using namespace std;


template <typename T>
T getMax(T arr[], int size) {
    T max = arr[0];
    for (int i = 1; i < size; ++i) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

int main() {

    int intArr[] = {3, 7, 2, 9, 5};
    int intSize = sizeof(intArr) / sizeof(intArr[0]);
    cout << "Max (int): " << getMax(intArr, intSize) << endl;


    double doubleArr[] = {1.2, 3.4, 0.9, 4.8, 2.1};
    int doubleSize = sizeof(doubleArr) / sizeof(doubleArr[0]);
    cout << "Max (double): " << getMax(doubleArr, doubleSize) << endl;


    string strArr[] = {"apple", "banana", "orange", "grape"};
    int strSize = sizeof(strArr) / sizeof(strArr[0]);
    cout << "Max (string): " << getMax(strArr, strSize) << endl;

    return 0;
}
