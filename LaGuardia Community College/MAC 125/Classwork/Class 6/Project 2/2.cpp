#include <iostream>
#include <fstream>

class MediaItem {
    protected:
        std::string title;
    public:
        MediaItem(const std::string& title) {
            this->title = title;
        }
        virtual ~MediaItem() {};
        virtual double getLateFee(int daysLate) const = 0;
        virtual std::string getInfo(int daysLate) const = 0;
};

class Book : public MediaItem {
    public:
        Book(const std::string& title) : MediaItem(title) {}
        double getLateFee(int daysLate) const override {
            return daysLate * 0.50;
        }
        std::string getInfo(int daysLate) const override {
            return "Book: " + title + 
                    "\nLate Fee: $" + std::to_string(getLateFee(daysLate));
        }
};

class DVD : public MediaItem {
    public:
        DVD(const std::string& title) : MediaItem(title) {}
        double getLateFee(int daysLate) const override {
            return daysLate * 1.00;
        }
        std::string getInfo(int daysLate) const override {
            return "DVD: " + title + 
                    "\nLate Fee: $" + std::to_string(getLateFee(daysLate));
        }
};

int main() {
    std::ifstream infile("media.txt");
    std::ofstream outfile("late_fees.txt");

    if (!infile || !outfile) {
        std::cerr << "Error opening files." << std::endl;
        return 1;
    }

    MediaItem** items = nullptr;
    int capacity = 0;
    int count = 0;

    std::string type, title;
    int daysLate;

    while (infile >> type >> title >> daysLate) {
        MediaItem* item = nullptr;
        if (type == "Book") {
            item = new Book(title);
        } else if (type == "DVD") {
            item = new DVD(title);
        } else {
            std::cout << "Unknown media type: " << type << std::endl;
            continue;
        }
        if (item != nullptr) {
            if (count >= capacity) {
                int newCapacity;
                if (capacity == 0) {
                    newCapacity = 2;
                } else {
                    newCapacity = capacity * 2;
                }
                MediaItem** newItems = new MediaItem*[newCapacity];
                for (int x = 0; x < count; ++x) {
                    newItems[x] = items[x];
                }
                delete[] items;
                items = newItems;
                capacity = newCapacity;
            }
            items[count++] = item;
        }
    }

    for (int i = 0; i < count; ++i) {
        outfile << items[i]->getInfo(daysLate) << "\n";
        delete items[i];
    }

    delete[] items;
    infile.close();
    outfile.close();

    return 0;
}