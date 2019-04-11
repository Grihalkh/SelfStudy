x = [1,2,3]
y = x
print('X and id(x) = {} ::: {}'.format(x,id(x)))
print('y and id(y) = {} ::: {}'.format(y,id(y)))
x.append(4)
print('X and id(x) = {} ::: {}'.format(x,id(x)))
print('y and id(y) = {} ::: {}'.format(y,id(y)))
##########################################################
x = 5
y = x
print('X and id(x) = {} ::: {}'.format(x,id(x)))
print('y and id(y) = {} ::: {}'.format(y,id(y)))
x = 4
print('X and id(x) = {} ::: {}'.format(x,id(x)))
print('y and id(y) = {} ::: {}'.format(y,id(y)))
##########################################################
x = 100000000
y = x
print('X and id(x) = {} ::: {}'.format(x,id(x)))
print('y and id(y) = {} ::: {}'.format(y,id(y)))
x = 100000001
print('X and id(x) = {} ::: {}'.format(x,id(x)))
print('y and id(y) = {} ::: {}'.format(y,id(y)))