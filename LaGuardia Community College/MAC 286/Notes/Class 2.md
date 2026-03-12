# LowArray and HighArray

## LowArray

```java
public class LowArray {
    private long[] a; // reference to array a
    private int nElems; // number of data items

    public LowArray(int size) {
        a = new long[size]; // create the array
        nElems = 0; // no items yet
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) {
        return a[index];
    }
}
```

### Definition

- `LowArray` is a simple wrapper around a primitive array of type `long`.
- It provides two methods:
  - `setElem(int index, long value)`: This method allows you to set the value at a specific index in the array.
  - `getElem(int index)`: This method allows you to retrieve the value at a specific index in the array.

### Complexity

- Search: O(1) - Direct access to any index.
- Insertion: O(1) - Directly set the value at the specified index.
- Deletion: O(1) - Directly set the value at the specified index to a default value (e.g., 0 or -1) if needed.
- Max: O(n) - You would need to iterate through the entire array to find the maximum value.

---

## HighArray

```java
public class HighArray {
    private long[] a; // reference to array a
    private int nElems; // number of data items

    public HighArray(int size) {
        a = new long[size]; // create the array
        nElems = 0; // no items yet
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        return j != nElems; // found it if not at end of array
    }

    public void insert(long value) {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value) {
                break;
            }
        }
        if (j == nElems) { // can't find it
            return false;
        } else { // found it
            for (int k = j; k < nElems - 1; k++) { // move higher ones down
                a[k] = a[k + 1];
            }
            nElems--; // decrement size
            return true;
        }
    }
}
```

### Definition

- `HighArray` is a more complex array structure that allows for searching, inserting, and deleting elements.
- It provides three methods:
  - `find(long searchKey)`: This method searches for a specific value in the array and returns `true` if found, otherwise `false`.
  - `insert(long value)`: This method inserts a new value at the end of the array and increments the number of elements.
  - `delete(long value)`: This method deletes a specific value from the array. If the value is found, it shifts all subsequent elements down to fill the gap and decrements the number of elements.

### Complexity

- Search: O(n) - In the worst case, it may have to check every element.
- Insertion: O(1) - Inserting at the end of the array is constant time.
- Deletion: O(n) - In the worst case, it may have to shift all elements after the deleted element.
- Max: O(n) - To find the maximum value, it may have to check every element in the array.

---

## Ordered Array

```java
public class OrdArray {
    private long[] a; // reference to array a
    private int nElems; // number of data items

    public OrdArray(int size) {
        a = new long[size]; // create the array
        nElems = 0; // no items yet
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn; // found it
            } else if (lowerBound > upperBound) {
                return nElems; // can't find it
            } else { // divide range
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1; // it's in upper half
                } else {
                    upperBound = curIn - 1; // it's in lower half
                }
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) { // find where it goes
            if (a[j] > value) { // (linear search)
                break;
            }
        }
        for (int k = nElems; k > j; k--) { // move bigger ones up
            a[k] = a[k - 1];
        }
        a[j] = value; // insert it
        nElems++; // increment size
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) { // can't find it
            return false;
        } else { // found it
            for (int k = j; k < nElems - 1; k++) { // move bigger ones down
                a[k] = a[k + 1];
            }
            nElems--; // decrement size
            return true;
        }
    }
}
```

### Definition

- `OrdArray` is an array that maintains its elements in sorted order, allowing for efficient searching using binary search.
- It provides three methods:
  - `find(long searchKey)`: This method uses binary search to find the index of a specific value in the array. It returns the index if found, otherwise it returns the number of elements (indicating not found).
  - `insert(long value)`: This method inserts a new value into the array while maintaining sorted order. It first finds the correct position for the new value and then shifts larger values up to make space for it.
  - `delete(long value)`: This method deletes a specific value from the array. It first finds the index of the value using binary search, and if found, it shifts all subsequent elements down to fill the gap and decrements the number of elements.

### Complexity

- Search: O(log n) - Uses binary search to find the element.
- Insertion: O(n) - In the worst case, it may have to shift all elements to insert a new value.
- Deletion: O(n) - In the worst case, it may have to shift all elements after the deleted element.
- Max: O(1) - The maximum value is always at the end of the array.

---

## Simple Sorting
