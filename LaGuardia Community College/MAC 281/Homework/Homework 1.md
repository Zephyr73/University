# Write the pseudo-code for a function that finds the sum of the largest and smallest items in a list of values having size n, where n >= 0. If n is 0 or 1 the function should return appropriate value

---

```pseudo
FUNCTION FindExtremeSum(list, n)
    If n == 0 THEN
        RETURN 0
    ELSE IF n == 1 THEN
        RETURN list[0] + list[0]
    END IF

    SET minVal = list[0]
    SET maxVal = list[0]

    FOR i FROM 1 TO n-1 DO
        IF list[i] < minVal THEN
            minVal = list[i]
        END IF
        IF list[i] > maxVal THEN
            maxVal = list[i]
        END IF
    END FOR
    RETURN minVal + maxVal
END FUNCTION
```
