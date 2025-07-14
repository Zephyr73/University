#include <iostream>

int main() {
    int a[100], b[100], c[200];
    int n1, n2, i, j, k;

    std::cout << "Enter number of elements in first array: ";
    std::cin >> n1;
    std::cout << "Enter " << n1 << " sorted elements:\n";
    for (i = 0; i < n1; i++)
        std::cin >> a[i];

    std::cout << "Enter number of elements in second array: ";
    std::cin >> n2;
    std::cout << "Enter " << n2 << " sorted elements:\n";
    for (i = 0; i < n2; i++)
        std::cin >> b[i];

    i = 0;
    j = 0;
    k = 0;

    while (i < n1 && j < n2) {
        if (a[i] < b[j])
            c[k++] = a[i++];
        else
            c[k++] = b[j++];
    }

    while (i < n1)
        c[k++] = a[i++];

    while (j < n2)
        c[k++] = b[j++];

    std::cout << "Merged array in ascending order:\n";
    for (i = 0; i < k; i++) {
        std::cout << c[i];
        if (i != k - 1) std::cout << ", ";
    }
    std::cout << "\n";

    return 0;
}
