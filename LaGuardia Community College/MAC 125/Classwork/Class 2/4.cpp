#include <iostream>

int main() {
    
    int M;
	int N;
	std::cout << "Enter how many rows you want to input: ";
	std::cin >> M;
	std::cout << "Enter how many columns you want to input: ";
	std::cin >> N;

	int matrix[M][N];
	int transponse[N][M];
	
	std::cout << "Enter values for matrix: " << "\n";
	for (int x = 0; x < M; x++) {
	    for (int y = 0; y < N; y++) {
	        std::cin >> matrix[x][y];
	    }
	}
    
    for (int x = 0; x < M; x++) {
        for (int y = 0; y < N; y++) {
            transponse[y][x] = matrix[x][y];
        }
    }
    
    for (int x = 0; x < N; x++) {
        for (int y = 0; y < M; y++) {
            std::cout << transponse[x][y] << " ";
        }
        std::cout << "\n";
    }
	return 0;
}