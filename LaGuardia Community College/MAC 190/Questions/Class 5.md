# **Project 1**

This Java program defines a `Car` class with private members for the make, model, and year of the car. It includes constructors, accessor and mutator methods, a method to print the car details, and an `isEqual` method to compare two `Car` objects.



## Class: Car

### Private Members:
- `make` (String): Brand of the car.
- `model` (String): Model of the car.
- `year` (int): Manufacturing year.

### Constructors:
- `Car(String make, String model, int year)`: Parameterized constructor to initialize all fields.
- `Car()`: Default constructor initializing fields to empty or zero values.

### Methods:
- `isEqual(Car other)`: Returns `true` if the current car's make, model, and year are the same as the other car's.
- `print()`: Prints the details of the car.
- `setMake(String make)`: Sets the car's make.



## Program Flow (`main` method):

1. Prompts the user to input car details for three car objects.
2. Prints details of each car.
3. Compares the cars pairwise using the `isEqual` method and prints the comparison results (`true` or `false`).



## Example Interaction:
```
Enter Car Brand: Toyota
Enter Car Model: Camry
Enter Car Year: 2010

Car Brand: Toyota
Car Model: Camry
Car Year: 2010

Enter Car brand: Honda

Car Brand: Honda
Car Model:
Car Year: 0

Enter Car Brand: Toyota
Enter Car Model: Camry
Enter Car Year: 2010

Car Brand: Toyota
Car Model: Camry
Car Year: 2010

false
true
false
```

---

# **Project 2**

This Java program defines a `Pet` class with properties and behaviors for different types of pets. It allows the user to enter details for multiple pets, then prints information about each pet including whether it can fly or bark/sing based on its type.


## Class: Pet

### Private Members:
- `type` (String): The type of the pet (e.g., bird, dog).
- `name` (String): The name of the pet.
- `breed` (String): The breed of the pet.
- `weight` (double): The weight of the pet in kilograms.

### Constructor:
- `Pet(String type, String name, String breed, double weight)`: Initializes a pet object with the given details.

### Methods:
- `canFly(String type)`: Returns a string indicating if the pet can fly. Returns "`<type> can fly`" if the pet is a bird, else "`<type> cannot fly`".
- `canBarkOrSing(String type)`: Returns a string indicating if the pet can bark or sing:
  - Birds can sing.
  - Dogs can bark.
  - Other pets cannot bark or sing.
- `printDetails()`: Prints all the pet details along with the results from `canFly()` and `canBarkOrSing()`.



## Program Flow (`main` method):

1. Creates an array to store 4 `Pet` objects.
2. For each pet, prompts the user to input:
   - Pet type
   - Pet name
   - Pet breed
   - Pet weight
3. Instantiates each `Pet` object using the input.
4. Prints the details of all entered pets.



## Example Interaction:
```
Enter Pet type: bird
Enter Pet name: Tweety
Enter Pet breed: Canary
Enter Pet weight: 0.5

Enter Pet type: dog
Enter Pet name: Max
Enter Pet breed: Labrador
Enter Pet weight: 25

... (and so on for 4 pets)
```