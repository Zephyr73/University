#include <iostream>
#include <set>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    set<string> uniqueStrings;
    string input;

    cout << "Enter strings. type 'end' to finish:\n";

    while (true) {
        getline(cin, input);

        string lowerInput = input;
        transform(lowerInput.begin(), lowerInput.end(), lowerInput.begin(), ::tolower);

        if (lowerInput == "end") {
            break;
        }

        uniqueStrings.insert(input); 
    }

    cout << "\nUnique strings in lexicographical order:\n";
    for (const string& str : uniqueStrings) {
        cout << str << endl;
    }

    return 0;
}
