def closest_mod_5(x):
    for i in range(5):
        if (x+i) % 5 == 0:
            return x+i
    return "idk :("


print(closest_mod_5(3))
print(closest_mod_5(4))
print(closest_mod_5(5))
print(closest_mod_5(6))
