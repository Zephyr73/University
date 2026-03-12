# Class 3: Algorithms

**Date:** 03/12/2026

---

## Common Search Algorithms

### 1. MaxLoc($x_1, \dots, x_n$)

- **Purpose:** Finds the index of the first occurrence of the maximum value in a list.

### 2. FindLoc($target, x_1, \dots, x_n$)

- **Purpose:** Finds the first instance of a target value.
- **Input:** Works on **unordered** lists.
- **Returns:**
  - The index if the target is present.
  - `-1` if the target is not present.

---

## Ordered Search (Alternative FindLoc)

This approach is used specifically for **ordered lists**. It returns both the existence of the element and its position (or intended position).

**Returns:** `YES/NO` at location `[i]`

- If **YES**: `[i]` is the current location.
- If **NO**: `[i]` is the location where it *would* be inserted to maintain order.

### Example 1: Ordered List

| Index | Value |
| :--- | :--- |
| [1] | B |
| [2] | F |
| [3] | Q |
| [4] | T |
| [5] | Z |

- **Find (T):** Yes, `[4]`
- **Find (A):** No, `[1]` (where it would go)
- **Find (S):** No, `[4]` (where it would go)
- **Find (Z):** No, `[6]` (where it would go at the end)

### Example 2: Unordered Target Search

| Index | Value |
| :--- | :--- |
| [1] | Q |
| [2] | L |
| [3] | A |
| [4] | A |
| [5] | F |

- **Find (A):** `[3]`, Yes
- **Find (R):** `[-1]`, No
- **Note:** In an unordered list, new values generally go to the bottom regardless of value.

---

## Linear Search in Unordered List

### Data Example

| Index | Value |
| :--- | :--- |
| [1] | K |
| [2] | F |
| [3] | R |
| [4] | A |
| [5] | W |
| [6] | P |

### Logic 1: Find Last Instance

This version continues searching through the entire list and will return the **last** index where the target was found.

```pseudocode
Loc <- -1
For i = 1 to n
    if a[i] == TARGET
        Loc <- i
Return Loc 
```

### Logic 2: Find First Instance (using Flag)

This version uses a "Found" flag to ensure only the **first** match is recorded.

```pseudocode
Loc <- -1
Found <- FALSE
For i = 1 to n
    if (NOT Found) AND (A[i] == TARGET)
        Loc <- i
        Found <- TRUE
Return Loc
```

### Logic 3: Find First Instance (Optimized While Loop)

The most efficient version — it stops immediately and **jumps out** of the loop once the target is found.

```pseudocode
Loc <- -1
Found <- FALSE
i <- 1
WHILE i <= n AND NOT Found
    if A[i] == TARGET
        Loc <- i
        Found <- TRUE
    else
        i <- i + 1
Return Loc
```

### Complexity

- **Best Case:** O(1) (if the target is at the first position)
- **Worst Case:** O(n) (if the target is at the last position or not found)
- **Average Case:** O(n/2) (on average, it will check half the elements)

## Linear Search in Ordered List

When we want to stop:

- When target <= A[k]

### Example

| Index | Value |
| :--- | :--- |
| [1] | B |
| [2] | F |
| [3] | Q |
| [4] | V |
| [5] | W |

```pseudocode
i <- 1
Found <- FALSE
WHILE i <= n AND Target >= A[i]
    if A[i] == Target
        Found <- TRUE
    else
        i <- i + 1
Return Found, i
```

Target: R

- **Output:** `NO`, `[3]` (where it would go)

---

## Sequential access

Suppose we have ordered list AND direct access to elements
We can jump to the middle of the list. Every step, we can jump to the middle of the remaining list.
