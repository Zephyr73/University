def toBinaryString(num):
    if num < 0 or num > 255:
        return "Error: Input must be between 0 and 255"
    
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

def mod2Subtraction(np, mp):
    result_list = [(np[i] - mp[i]) % 2 for i in range(8)]
    
    result_int = 0
    for bit in result_list:
        result_int = result_int * 2 + bit
    
    result_bin = ""
    temp = result_int
    while temp != 0:
        if temp % 2 == 0:
            result_bin = "0 " + result_bin
        else:
            result_bin = "1 " + result_bin
        temp = temp // 2
    
    while len(result_bin.replace(" ", "")) < 8:
        result_bin = "0 " + result_bin
    
    print(result_bin)

def toBinaryList(num):
    bits = []
    while num > 0:
        bits.insert(0, num % 2)
        num = num // 2
    while len(bits) < 8:
        bits.insert(0, 0)
    return bits

tests = [(12, 7), (25, 18), (255, 170)]

for n, m in tests:
    np = toBinaryList(n)
    mp = toBinaryList(m)
    print(f"n = {n} ({' '.join(str(bit) for bit in np)})")
    print(f"m = {m} ({' '.join(str(bit) for bit in mp)})")
    print("n - m mod 2 = ", end="")
    mod2Subtraction(np, mp)
    print()
