#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void readSortAndPrintDescending() {
    int num;
    cout << "Enter the number of integers: ";
    cin >> num;

    vector<int> numbers(num);

    cout << "Enter " << num << " integers:\n";
    for (int x = 0; x < num; ++x) {
        cin >> numbers[x];
    }


    sort(numbers.begin(), numbers.end(), greater<int>());

    cout << "Sorted elements in descending order:\n";
    for (int number : numbers) {
        cout << number << " ";
    }
    cout << endl;
}

int main() {
    readSortAndPrintDescending();
    return 0;
}