#include <iostream>

class BankAccount {
    private:
        int accountNumber;
        std::string accountHolder;
        double balance;

    public:
        BankAccount(int accNumber, std::string holderName, double initialBalance = 0.0) {
            accountNumber = accNumber;
            accountHolder = holderName;
            balance = initialBalance;
        }
        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                std::cout << "Deposited: " << amount << "\n";
            } else {
                std::cout << "Deposit amount must be positive.\n";
            }
        }
        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                std::cout << "Withdrawn: " << amount << "\n";
            } else if (amount > balance) {
                std::cout << "Insufficient funds for withdrawal.\n";
            } else {
                std::cout << "Withdrawal amount must be positive.\n";
            }
        }
        void display() {
            std::cout << "Account Number: " << accountNumber << "\n";
            std::cout << "Account Holder: " << accountHolder << "\n";
            std::cout << "Balance: " << balance << "\n";
        }
};

int main() {
    BankAccount account1(1, "john"), account2(2, "doe", 1500.0);
    account1.deposit(1000);
    account1.withdraw(500);
    account1.display();

    account2.deposit(2000);
    account2.withdraw(2500); 
    account2.display();

    return 0;
}