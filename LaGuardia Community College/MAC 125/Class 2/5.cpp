#include <iostream>

int main() {
    int M, N, P;
    std::cout << "Enter number of rows for first matrix (M): ";
    std::cin >> M;
    std::cout << "Enter number of columns for first matrix / rows for second matrix (N): ";
    std::cin >> N;
    std::cout << "Enter number of columns for second matrix (P): ";
    std::cin >> P;

    int first[M][N];
    int second[N][P];
    int result[M][P];

    std::cout << "Enter elements of first matrix (" << M << "x" << N << "):" << std::endl;
    for (int x = 0; x < M; x++) {
        for (int y = 0; y < N; y++) {
            std::cin >> first[x][y];
        }
    }

    std::cout << "Enter elements of second matrix (" << N << "x" << P << "):" << std::endl;
    for (int x = 0; x < N; x++) {
        for (int y = 0; y < P; y++) {
            std::cin >> second[x][y];
        }
    }

    for (int x = 0; x < M; x++) {
        for (int y = 0; y < P; y++) {
            result[x][y] = 0;
        }
    }

    for (int x = 0; x < M; x++) {
        for (int y = 0; y < P; y++) {
            for (int z = 0; z < N; z++) {
                result[x][y] += first[x][z] * second[z][y];
            }
        }
    }

    std::cout << "Resulting matrix (" << M << "x" << P << "):" << std::endl;
    for (int x = 0; x < M; x++) {
        for (int y = 0; y < P; y++) {
            std::cout << result[x][y] << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}
