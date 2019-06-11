def binsearch(lst, item):
    left = 0 
    right = len(lst) - 1
    
    while left <= right:
        mid = (right+left)//2
        guess = lst[mid]
        if guess < item:
            left = mid + 1
        elif guess > item:
            right = mid - 1
        else:
            return mid
    return None


lst = list(range(0, 100))
item = int(input('Your item in the range from 0 to 99: '))
print('Your item is №', binsearch(lst, item))

