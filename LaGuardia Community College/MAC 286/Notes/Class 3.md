# Class 3: Data Structures & Algorithms
**Date:** March 12, 2026

---

This document covers the implementation and complexity analysis of three types of array-based data structures: **LowArray**, **HighArray**, and **Ordered Array (OrdArray)**, as well as a basic sorting algorithm.

---

## 1. LowArray (Basic Wrapper)
`LowArray` is a thin wrapper around a primitive `long[]`. It shifts the responsibility of index management to the **user** of the class.

### Implementation
```java
public class LowArray {
    private long[] a; 
    private int nElems;

    public LowArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) {
        return a[index];
    }
}
```

### Complexity Analysis
| Operation | Complexity | Description |
| :--- | :--- | :--- |
| **Search** | $O(1)$ | Direct access via index. |
| **Insertion** | $O(1)$ | Direct assignment at an index. |
| **Deletion** | $O(1)$ | Setting a value to a default (e.g., 0). |
| **Max** | $O(n)$ | Must iterate through the entire array. |

---

## 2. HighArray (Encapsulated Operations)
`HighArray` hides the index logic from the user. The class itself handles searching, inserting at the end, and shifting elements during deletion.

### Implementation
```java
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) break;
        }
        return j != nElems; 
    }

    public void insert(long value) {
        a[nElems] = value; 
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) break;
        }
        if (j == nElems) return false;
        
        for (int k = j; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
        return true;
    }

    public long getMax() {
        if (nElems == 0) return -1;
        long max = a[0];
        for (int j = 1; j < nElems; j++) {
            if (a[j] > max) max = a[j];
        }
        return max;
    }
}
```

### Complexity Analysis
| Operation | Complexity | Description |
| :--- | :--- | :--- |
| **Search** | $O(n)$ | Linear search through used elements. |
| **Insertion** | $O(1)$ | Always appends at the end (`nElems`). |
| **Deletion** | $O(n)$ | Requires search + shifting elements left. |
| **Max** | $O(n)$ | Must check every element one by one. |

---

## 3. Ordered Array (OrdArray)
`OrdArray` keeps data sorted. This enables **Binary Search**, making lookups significantly faster.

### Implementation
```java
public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public int find(long searchKey) {
        int lower = 0;
        int upper = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lower + upper) / 2;
            if (a[curIn] == searchKey) return curIn;
            else if (lower > upper) return nElems; // Not found
            else {
                if (a[curIn] < searchKey) lower = curIn + 1;
                else upper = curIn - 1;
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) { // Linear search for position
            if (a[j] > value) break;
        }
        for (int k = nElems; k > j; k--) { // Shift bigger ones up
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value); // Binary search for index
        if (j == nElems) return false;
        
        for (int k = j; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
        return true;
    }
}
```

### Complexity Analysis
| Operation | Complexity | Description |
| :--- | :--- | :--- |
| **Search** | $O(\log n)$ | **Binary Search** (splitting range in half). |
| **Insertion** | $O(n)$ | Must search for spot + shift elements right. |
| **Deletion** | $O(n)$ | Search ($O(\log n)$) + shift ($O(n)$). |
| **Max** | $O(1)$ | Max is simply `a[nElems-1]`. |

---

## 4. Sorting Algorithms
### Bubble Sort
A simple but inefficient sort that works by repeatedly swapping adjacent elements if they are in the wrong order.

```java
public static void bubbleSort(long[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                long temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break; // Optimization: Stop if already sorted
    }
}
```

**Complexity:** $O(n^2)$ (Average and Worst Case).
