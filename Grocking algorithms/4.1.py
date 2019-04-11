def sumlist(l:list)->int:
    if(l==[]):
        return 0
    else:
        return l[0] + sumlist(l[1:])
    
l = [1,2,3,4]
print(sumlist(l))
