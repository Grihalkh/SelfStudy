def __fact(n:int,a:int) -> int:
    return a if n==0 else __fact(n-1,n*a)

def fact(n:int) -> int:
    return __fact(n,1)
    
n = int(input('N: '))
print('N! = ',fact(n))
