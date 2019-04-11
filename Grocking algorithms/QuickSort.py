def quicksort(l:list)->list:
    if len(l) < 2:
        return l
    else:
        pivot = l[0]
        low = [i for i in l[1:] if i<=pivot]
        high = [i for i in l[1:] if i>pivot]
        return quicksort(low) + [pivot] + quicksort(high)

l = [1,4,4,5,4,68,4,9,6,4]
print(quicksort(l))