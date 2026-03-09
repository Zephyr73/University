#include <iostream>
#include <map>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    map<string, string> nameColorMap;
    string name, color;

    cout << "Enter name and favorite color pairs. type 'end' as name to stop:\n";

    while (true) {
        cout << "Name: ";
        getline(cin, name);

        string lowerName = name;
        transform(lowerName.begin(), lowerName.end(), lowerName.begin(), ::tolower);

        if (lowerName == "end") {
            break;
        }

        cout << "Favorite Color: ";
        getline(cin, color);

        nameColorMap[name] = color;
    }

    cout << "\nName and Favorite Color:\n";
    for (const auto& pair : nameColorMap) {
        cout << pair.first << " : " << pair.second << endl;
    }

    return 0;
}
