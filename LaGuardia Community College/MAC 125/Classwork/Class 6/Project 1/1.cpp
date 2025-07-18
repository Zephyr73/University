#include <iostream>
#include <fstream>

class Account {
    protected:
        std::string name;
        double balance;

    public:
        Account(const std::string& name, double balance) {
            this->name = name;
            this->balance = balance;
        } 
        virtual ~Account() {}
        virtual void applyInterestOrFees() = 0;
        virtual std::string getInfo() const = 0;
};

class SavingsAccount : public Account {
    public:
        SavingsAccount(std::string& name, double balance) : Account(name, balance) {}
        void applyInterestOrFees() override {
            balance = balance + (balance * (2.0/ 100.0));
        }
        std::string getInfo() const override {
            return "Savings Account: " + name +
                    "\nBalance: " + std::to_string(balance) + "\n";
        }
};

class CheckingAccount : public Account {
    double fee;

    public:
        CheckingAccount(std::string& name, double balance, double fee) : Account(name, balance) {
            this->fee = fee;
        }
        void applyInterestOrFees() override {
            balance = balance - fee;
        }
        std::string getInfo() const override {
            return "Savings Account: " + name +
                    "\nBalance: " + std::to_string(balance) + "\n";
        }
};

int main() {
    std::ifstream infile("accounts.txt");
    std::ofstream outfile("updated_accounts.txt");

    if (!infile || !outfile) {
        std::cerr << "Error opening files." << std::endl;
        return 1;
    }

    Account** accounts = nullptr;
    int capacity = 0;
    int count = 0;

    std::string type, name;

    while (infile >> type >> name) {
        Account* acc = nullptr;
        if (type == "Savings") {
            double balance, rate;
            if (!(infile >> balance)) {
                std::cerr << "Error reading Savings account data." << std::endl;
                continue;
            }
            acc = new SavingsAccount(name, balance);
        } else if (type == "Checking") {
            double balance, fee;
            if (!(infile >> balance >> fee)) {
                std::cerr << "Error reading Checking account data." << std::endl;
                continue;
            }
            acc = new CheckingAccount(name, balance, fee);
        }
        else {
            std::cerr << "Unknown account type: " << type << std::endl;
            continue;
        }
        if (acc != nullptr) {
            if (count >= capacity) {
                int newCapacity;
                if (capacity == 0) {
                    newCapacity = 2;
                } else {
                    newCapacity = capacity * 2;
                }
                Account** newAccounts = new Account*[newCapacity];
                for (int x = 0; x < count; ++x) {
                    newAccounts[x] = accounts[x];
                }
                delete[] accounts;
                accounts = newAccounts;
                capacity = newCapacity;
            }
            accounts[count++] = acc;
        }
    }
    for (int x = 0; x < count; ++x) {
        accounts[x]->applyInterestOrFees();
        outfile << accounts[x]->getInfo() << "\n";
        delete accounts[x];
    }
    delete[] accounts;
    infile.close();
    outfile.close();
    return 0;
}