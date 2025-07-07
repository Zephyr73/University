#include <iostream>

int main() {
    int M, N;
    std::cout << "Enter number of rows (M): ";
    std::cin >> M;
    std::cout << "Enter number of columns (N): ";
    std::cin >> N;

    int matrix[M][N];

    std::cout << "Enter elements of the matrix:" << std::endl;
    for (int x = 0; x < M; x++) {
        for (int y = 0; y < N; y++) {
            std::cin >> matrix[x][y];
        }
    }

    std::cout << "Row sums:" << std::endl;
    for (int x = 0; x < M; x++) {
        int rowSum = 0;
        for (int y = 0; y < N; y++) {
            rowSum += matrix[x][y];
        }
        std::cout << "Row " << x << ": " << rowSum << std::endl;
    }

    std::cout << "Column sums:" << std::endl;
    for (int y = 0; y < N; y++) {
        int colSum = 0;
        for (int x = 0; x < M; x++) {
            colSum += matrix[x][y];
        }
        std::cout << "Column " << y << ": " << colSum << std::endl;
    }

    return 0;
}
