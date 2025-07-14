#include <iostream>

int** createMatrix(int rows, int cols) {
    int** matrix = new int*[rows];
    for (int i = 0; i < rows; i++)
        matrix[i] = new int[cols];
    return matrix;
}

void deleteMatrix(int** matrix, int rows) {
    for (int i = 0; i < rows; i++)
        delete[] matrix[i];
    delete[] matrix;
}

int** multiply(int** A, int** B, int m, int n, int p) {
    int** C = createMatrix(m, p);
    for (int i = 0; i < m; i++)
        for (int j = 0; j < p; j++) {
            *(*(C + i) + j) = 0;
            for (int k = 0; k < n; k++)
                *(*(C + i) + j) += *(*(A + i) + k) * *(*(B + k) + j);
        }
    return C;
}

int main() {
    int m, n, p;
    std::cout << "Enter rows and columns of first matrix: ";
    std::cin >> m >> n;
    std::cout << "Enter columns of second matrix: ";
    std::cin >> p;

    int** A = createMatrix(m, n);
    int** B = createMatrix(n, p);

    std::cout << "Enter elements of first matrix:\n";
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            std::cin >> *(*(A + i) + j);

    std::cout << "Enter elements of second matrix:\n";
    for (int i = 0; i < n; i++)
        for (int j = 0; j < p; j++)
            std::cin >> *(*(B + i) + j);

    int** C = multiply(A, B, m, n, p);

    std::cout << "Result matrix:\n";
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < p; j++)
            std::cout << *(*(C + i) + j) << " ";
        std::cout << "\n";
    }

    deleteMatrix(A, m);
    deleteMatrix(B, n);
    deleteMatrix(C, m);

    return 0;
}
