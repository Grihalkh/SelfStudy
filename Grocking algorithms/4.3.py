def fmax(l:list)->int:
    if len(l) == 2:
        return l[0] if l[0] > l[1] else l[1]
    submax = max(l[1:])
    return l[0] if l[0] > submax else submax

l = [1,5,1,4,6,4,1,5]

print (fmax(l))