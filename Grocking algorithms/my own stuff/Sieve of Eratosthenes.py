def clear_lst(lst):
    n = len(lst)
    i = 0
    while i < n:
        if lst[i] is None:
            del lst[i]
            n -= 1
        else:
            i += 1
    return lst


def eratosthenes(n):
    if n < 2:
        return
    nums = list(range(n+1))
    curnum = 2
    todel = 1
    while curnum is not None:
        todel = curnum ** 2
        if todel > n:
            break
        while todel <= n:
            nums[todel] = None
            todel += curnum

        tocheck = curnum + 1
        curnum = None
        while curnum is None and tocheck <= n:
            curnum = nums[tocheck]
            tocheck += 1

    return clear_lst(nums)[2:]


n = int(input('Input n: '))
print('Primes that are <= n:')
print(*eratosthenes(n))
