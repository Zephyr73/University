#include <iostream>

int main() {
	int N;
	std::cout << "Enter how many integers you want to input: ";
	std::cin >> N;

	int array1[N];
	for (int x = 0; x < N; x++) {
		std::cout << "Enter number " << x + 1 << ": ";
		std::cin >> array1[x];
	}

	int fnd;
	std::cout << "Enter which number to find: ";
	std::cin >> fnd;
	
	for (int x = 0; x < N; x++) {
	    if (array1[x] == fnd) {
	        std::cout << "Number found in index: " << x << "\n";
	    }
	}

	return 0;
}
