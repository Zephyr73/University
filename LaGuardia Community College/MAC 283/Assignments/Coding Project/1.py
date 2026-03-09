num1 = input("Enter the number: ")

length = len(num1)
num1 = int(num1)

for i in range(length, 0, -1):
    digit = num1 // (10 ** (i - 1))
    print(digit, end=" ")
    num1 = num1 % (10 ** (i - 1))
