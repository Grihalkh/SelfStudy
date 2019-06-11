def merge(lst1_inp, lst2_inp):

    if type(lst1_inp) != type(list()):
        lst1 = [lst1_inp]
    else:
        lst1 = lst1_inp
    if type(lst2_inp) != type(list()):
        lst2 = [lst2_inp]
    else:
        lst2 = lst2_inp

    i = 0
    lim_i = len(lst1)
    j = 0
    lim_j = len(lst2)


    new_lst = []

    while i < lim_i and j < lim_j:
        if lst1[i] < lst2[j]:
            new_lst.append(lst1[i])
            i += 1
        else:
            new_lst.append(lst2[j])
            j += 1

    # add what is left
    while i < lim_i:
        new_lst.append(lst1[i])
        i += 1
    while j < lim_j:
        new_lst.append(lst2[j])
        j += 1

    return new_lst


def merge_sort(lst, log=False):
    merges = lst.copy()
    step = 0
    while len(merges) > 1:
        new_merges = []

        for i in range(0, len(merges)-1, 2):
            new_merges.append(merge(merges[i], merges[i+1]))

        if len(merges) % 2 != 0:
            new_merges.append(merges[-1])

        merges = new_merges
        if log:
            print('Step #{}\nMerges: {}'.format(step, merges))
        step += 1
    return merges[0]

print('Enter your list to sort by merging')
lst = list(map(int, input().split()))
print(*merge_sort(lst, log=True))
