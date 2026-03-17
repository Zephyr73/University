# Class 4: Searching and Sorting

**Date:** March 17, 2026

---

## Sorted Data Array

| Index | Value |
| :--- | :--- |
| [1] | B |
| [2] | F |
| [3] | G |
| [4] | K |
| [5] | M |
| [6] | P |
| [7] | S |
| [8] | T |
| [9] | V |
| [10] | X |
| [11] | Y |

---

## Binary Search Examples

### Example 1: Find (V)

1. **Range: [1, 11]**
    * $\text{Mid} = \frac{1 + 11}{2} = 6$
    * $\text{Value at [6]} = P$
    * $P < V \implies$ Search right half.
2. **New Range: [7, 11]**
    * $\text{Mid} = \frac{7 + 11}{2} = 9$
    * $\text{Value at [9]} = V$
    * **Result:** Found at index 9!

### Example 2: Find (J)

1. **Range: [1, 11]**
    * $\text{Mid} = \frac{1 + 11}{2} = 6$
    * $\text{Value at [6]} = P$
    * $P > J \implies$ Search left half.
2. **New Range: [1, 5]**
    * $\text{Mid} = \frac{1 + 5}{2} = 3$
    * $\text{Value at [3]} = G$
    * $G < J \implies$ Search right half.
3. **New Range: [4, 5]**
    * $\text{Mid} = \frac{4 + 5}{2} = 4.5 \rightarrow 4$
    * $\text{Value at [4]} = K$
    * $K > J \implies$ Search left half.
4. **Final Range: [4, 3]**
    * Range is invalid (Low > High).
    * **Result:** Not found.

---

## Sort Methods

### Selection Sort

```
 For i = 1 to n
    Loc <- FindMinLoc(A)
    B[i] <- A[Loc]
    A[Loc] <- ∞
```
O(n^2) time complexity due to nested loops.

### Swap Sort

```
 For i = 1 to n
    Loc <- FindMinLoc(A)
    Swap A[i] and A[Loc]
```
O(n^2) time complexity due to nested loops.