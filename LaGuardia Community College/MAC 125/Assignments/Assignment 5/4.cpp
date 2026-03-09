#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> numbers;
    int input;

    cout << "Enter 5 integers:\n";
    for (int i = 0; i < 5; ++i) {
        cin >> input;
        numbers.push_back(input);
    }

    sort(numbers.begin(), numbers.end());

    cout << "Sorted numbers: ";
    for (vector<int>::iterator it = numbers.begin(); it != numbers.end(); ++it) {
        cout << *it << " ";
    }
    cout << endl;

    return 0;
}
