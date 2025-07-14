### **Project 1: Student Gradebook Application**

**Objective:**
Create a simple gradebook application that allows a user to manage information for a single student. The application will store the student's name, ID, and three scores (quiz, mid-term, and final exam). It will then calculate the final grade based on a weighted average.

**Core Requirements:**

1.  **`Student` Class Design (Encapsulation):**
    *   Create a class named `Student`.
    *   Declare private instance variables for the student's name (`String`), student ID (`int`), quiz score (`double`), mid-term score (`double`), and final exam score (`double`).
    *   Implement **accessor (get)** and **mutator (set)** methods for all instance variables. The mutator methods should ensure that scores cannot be set to a negative value.

2.  **Custom Methods:**
    *   Inside the `Student` class, create a public method `calculateFinalAverage()` that calculates the weighted average. The weighting is: Quiz (25%), Mid-Term (35%), and Final Exam (40%). The method should return the final average as a `double`.
    *   Create another public method `getFinalLetterGrade()` that uses the final average. It should return a `char` representing the letter grade based on this scale:
        *   90.0 and above: 'A'
        *   80.0 - 89.9: 'B'
        *   70.0 - 79.9: 'C'
        *   60.0 - 69.9: 'D'
        *   Below 60.0: 'F'
        *(Hint: Use a multi-branch `if-else` statement.)*

3.  **Driver Class (`GradebookApp`):**
    *   Create a separate class with a `main` method.
    *   Inside `main`, create an instance (object) of your `Student` class.
    *   Use the `Scanner` class to prompt the user to enter the student's name, ID, and the three scores. Use the mutator methods of your `Student` object to store this data.
    *   Call the object's methods to calculate the final average and letter grade.
    *   Print a summary to the console, neatly displaying all the student's information, their final numeric average, and their final letter grade.

---

### **Project 2: Simple Bank Account Manager**

**Objective:**
Develop a console application that simulates basic interactions with a bank account. The program should allow the user to deposit money, withdraw money, and check their balance.

**Core Requirements:**

1.  **`BankAccount` Class Design (Encapsulation):**
    *   Create a class named `BankAccount`.
    *   Declare private instance variables for the account holder's name (`String`), account number (`long`), and balance (`double`).
    *   Create a constructor that initializes the account holder's name and account number, and sets the initial balance to a value provided by the user.

2.  **Custom Methods:**
    *   Create a public `deposit(double amount)` method. This method should add the `amount` to the balance. It should include an `if` statement to prevent a negative `amount` from being deposited.
    *   Create a public `withdraw(double amount)` method. This method should check if the `amount` is valid (not negative) and if there are sufficient funds in the account (`amount <= balance`).
        *   If the withdrawal is successful, update the balance and print a confirmation.
        *   If there are insufficient funds, print an "Insufficient funds" error message and do not change the balance.
    *   Implement a public `getBalance()` accessor method that returns the current balance.
    *   Create a `displayAccountInfo()` method that prints the account holder's name, number, and current balance.

3.  **Driver Class (`BankApp`):**
    *   In a separate class with a `main` method, create a `BankAccount` object, asking the user for the initial details (name, number, starting balance).
    *   Use a `do-while` loop to create a persistent menu that runs until the user chooses to exit.
    *   The menu should display the following options:
        1.  Deposit
        2.  Withdraw
        3.  Check Balance
        4.  Display Account Info
        5.  Exit
    *   Use a `switch` statement to handle the user's menu choice, calling the appropriate methods on your `BankAccount` object.

---

### **Project 3: Command-Line Text Adventure Game**

**Objective:**
Create a very simple text-based adventure game where a player navigates between rooms. This project will heavily utilize control flow, loops, and string comparison.

**Core Requirements:**

1.  **Game Logic in the `main` Method:**
    *   No custom classes are needed for this one; all logic can be inside the `main` method to focus on control flow.
    *   Create variables to keep track of the player's state, such as `currentRoom` (`String`), `hasKey` (`boolean`), and a `gameIsRunning` (`boolean`) flag.

2.  **Game World & Puzzles:**
    *   Design a small map of 3-4 rooms (e.g., "Hallway", "Library", "Kitchen", "Locked Room"). The player starts in the "Hallway".
    *   In the "Library", the player can find a key. Set your `hasKey` boolean to `true` if they search there.
    *   The "Locked Room" can only be entered if `hasKey` is `true`. If the player tries to enter without the key, tell them the door is locked.

3.  **User Interaction and Control Flow:**
    *   Use a `while(gameIsRunning)` loop to run the game.
    *   Inside the loop, tell the player which room they are in and what they can do (e.g., "go north", "go south", "get key", "unlock door").
    *   Use a `Scanner` to get the player's command. Use the `.toLowerCase()` and `.equals()` string methods to process the input.
    *   Use nested `if-else` or `switch` statements to handle the game's logic based on the `currentRoom` and the player's command.
        *   **Example Logic:**
            ```java
            if (currentRoom.equals("Hallway")) {
                if (command.equals("go north")) {
                    currentRoom = "Library";
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (currentRoom.equals("Library")) {
                // ... handle library commands
            }
            ```    *   The game ends when the player enters a specific room (e.g., the "Locked Room" with the key) or types an "exit" command. When the game ends, set `gameIsRunning` to `false` to exit the loop.