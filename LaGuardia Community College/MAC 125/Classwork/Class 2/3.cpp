#include <iostream>

int main() {
	int N;
	std::cout << "Enter how many integers you want to input: ";
	std::cin >> N;

	int array1[N];
	int odd = 0;
	int even = 0;
	
	for (int x = 0; x < N; x++) {
		std::cout << "Enter number " << x + 1 << ": ";
		std::cin >> array1[x];
		if (array1[x]%2 == 0) {
		    even = even + 1;
		} else {
		    odd = odd + 1;
		}
	}
    
    std::cout << "Total odd numbers: " << odd << "\n"
        << "Total even numbers: " << even;

	return 0;
}
