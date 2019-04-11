objects = [1, 2, 1, 2, 3, True]

res = [objects[0]]

for obj in objects:
    skip = False
    for setObj in res:
        if obj is setObj:
            skip = True
            break
    if not skip:
        res.append(obj)

print(len(res))
