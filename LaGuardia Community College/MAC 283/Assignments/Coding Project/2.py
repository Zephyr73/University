def binDigits(num):
    if num > 255 or num < 0:
        return "Error: Input must be between 0 and 255"
    else:
        binString = ""
        while num != 0:
            if num % 2 == 0:
                binString = "0 " + binString
            else:
                binString = "1 " + binString
            num = num // 2
        while len(binString.replace(" ", "")) < 8:
            binString = "0 " + binString
            
    return binString

print("Test 1:", binDigits(75))    
print("Test 2:", binDigits(5))     
print("Test 3:", binDigits(200))  
