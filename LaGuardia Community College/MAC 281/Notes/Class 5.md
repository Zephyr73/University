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
