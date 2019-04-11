def count(l:list)->int:
    if l==[]:
        return 0
    else:
        return 1 + count(l[1:])
    
l = [1,2,3,4,5]

print(count(l))