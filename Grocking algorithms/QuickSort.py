def quicksort(l):
    if len(l) < 2:
        return l
    else:
        pivot = l[0]
        low = [i for i in l[1:] if i <= pivot]
        high = [i for i in l[1:] if i > pivot]
        return quicksort(low) + [pivot] + quicksort(high)


print('Enter a list to sort')
lst = list(map(int, input().split()))
print(*quicksort(lst))
