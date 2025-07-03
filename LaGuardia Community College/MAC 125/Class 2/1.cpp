#include <iostream>

int main() {
	int N;
	std::cout << "Enter how many integers you want to input: ";
	std::cin >> N;

	int array1[N];
	int sum = 0;
	for (int x = 0; x < N; x++) {
		std::cout << "Enter number " << x + 1 << "\n";
		std::cin >> array1[x];
		sum = sum + array1[x];
	}

	std::cout << "Sum of numbers: " << sum << "\n"
		<< "Average of numbers: " << sum / N;

	return 0;
}
