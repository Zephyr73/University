### **Project: BOOK Class**

**Objective:**  
Define a class `BOOK` with encapsulated data members and methods for managing book details and purchases.

---

### **Class Specification:**

**Private Members:**

- `BOOK_NO` (integer): Book number.
- `BOOKTITLE` (String): Book title (limit to 20 characters).
- `PRICE` (float): Price per copy.
- `TOTAL_COST(int N)`: Function that calculates the total cost for `N` copies, where `N` is passed as an argument.

**Public Members:**

- `INPUT()`: Method to read `BOOK_NO`, `BOOKTITLE`, and `PRICE` from user input.
- `PURCHASE()`: Method to ask the user to input the number of copies to be purchased; it then invokes `TOTAL_COST()` and prints the total cost.
- `BOOK()`: Default constructor.
- `BOOK(int bookNo, String title, float price)`: Parameterized constructor.

---

### **Requirements:**

- Implement the class `BOOK` with the members and methods specified.
- Write a test program that:
  - Creates a `BOOK` object with:
    - `BOOK_NO`: 1234659
    - `BOOKTITLE`: "Absolute Java"
    - `PRICE`: 79.99
  - Uses the `INPUT()` method to read or confirm book information.
  - Uses the `TOTAL_COST()` method to calculate the total cost for 4 copies.
  - Prints the following details:
    - Book Number
    - Book Title
    - Price per copy
    - Number of copies
    - Total cost to be paid


