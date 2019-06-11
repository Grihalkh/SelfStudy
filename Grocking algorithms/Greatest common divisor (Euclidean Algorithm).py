def gcd(a: int, b: int) -> int:
    if (a == 0) or (b == 0):
        return a + b
    elif a >= b:
        return gcd(b, a % b)
    else:
        return gcd(a, b % a)


a = int(input('A: '))
b = int(input('B: '))
print('GCD: ', gcd(a, b))
