# Class 5: Recursion

**Date:** March 19, 2026

---

## What is Recursion?

Recursion is a programming technique where a function calls itself in order to solve a problem. It typically involves a base case that stops the recursion and a recursive case that breaks the problem into smaller subproblems.

## Example: Factorial Function

The factorial of a non-negative integer n is the product of all positive integers less than or equal to n. It can be defined recursively as follows:

$$
\text{factorial}(n) = \begin{cases}
    1 & \text{if } n = 0 \\
    n \cdot \text{factorial}(n-1) & \text{if } n > 0
\end{cases}
$$  

Pseudocode for the factorial function:

```pseudocode
function factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)
```

## Example: Fibonacci Sequence

The Fibonacci sequence is defined as follows:
$$
\text{fib}(n) = \begin{cases}
    0 & \text{if } n = 0 \\
    1 & \text{if } n = 1 \\
    \text{fib}(n-1) + \text{fib}(n-2) & \text{if } n > 1
\end{cases}
$$

Pseudocode for the Fibonacci function:

```pseudocode
function fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib(n - 1) + fib(n - 2)
```

## Palindrome Check

A palindrome is a string that reads the same backward as forward. We can check if a string is a palindrome using recursion:

```pseudocode
function isPalindrome(s):
    if length of s <= 1:
        return true
    else:
        return (s[0] == s[length of s - 1]) and isPalindrome(s[1:length of s - 1])
```

---

## Quick Sort Algorithm

Example:
List = [8, 2, 1, 9, 7, 15, 3, 4, 11]
Pivot = 8
New List = [2, 1, 7, 3, 4]  [8]  [9, 15, 11]

```
Sorting left side:
    List = [2, 1, 7, 3, 4]
    Pivot = 2
    New List = [1]  [2]  [7, 3, 4]
    Sorting right side:
    List = [7, 3, 4]
    Pivot = 7
    New List = [3, 4]  [7]  []
    Sorting left side:
        List = [3, 4]
        Pivot = 3
        New List = []  [3]  [4]
Sorted Left Side = [1, 2, 3, 4, 7]

Sorting right side:
    List = [9, 15, 11]
    Pivot = 9
    New List = []  [9]  [15, 11]
    Sorting right side:
        List = [15, 11]
        Pivot = 15
        New List = [11]  [15]  []
Sorted Right Side = [9, 11, 15]

Final Sorted List = [1, 2, 3, 4, 7, 8, 9, 11, 15]
```

Pseudocode for Quick Sort:

```pseudocode
QuickSort(A,i,j):
    pivotVal = A[i]
    pivotLoc = i
    bottomLoc = j
    while (pivotLoc < bottomLoc)
        if(a[pivotLoc] < pivotVal)
            a[pivotLoc] = a[bottomLoc]
            pivotLoc = pivotLoc + 1
            a[bottomLoc] = a[pivotLoc]
            a[bottomLoc] = pivotVal
        else
            bottomLoc = bottomLoc - 1
    if (i < pivotLoc) Call QuickSort(A,i,pivotLoc-1)
    if (pivotLoc < j) Call QuickSort(A,pivotLoc+1,j)
```

### Choosing a Pivot

- First element
- Last element
- Random element
- Median element (Median of the first, middle, and last elements, Highly recommended)
