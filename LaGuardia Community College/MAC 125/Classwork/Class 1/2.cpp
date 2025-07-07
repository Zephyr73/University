#include <iostream>
using namespace std;

int main() {
    int week;
    cout << "Enter week number: ";
    cin >> week;
    if (week == 1) {
        cout << "This day is Monday";
    }
    else if (week == 2) {
        cout << "This day is Tuesday";
    }
    else if (week == 3) {
        cout << "This day is Wednesday";
    }
    else if (week == 4) {
        cout << "This day is Thursday";
    }
    else if (week == 5) {
        cout << "This day is Friday";
    }
    else if (week == 6) {
        cout << "This day is Saturday";
    }
    else if (week == 7) {
        cout << "This day is Sunday";
    }
    else {
        cout << "enter a number between 1 and 7";
    }
    return 0;
}
