def c(n, k):
    if k == 0:
        return 1
    if k > n:
        return 0
    return c(n-1, k) + c(n-1, k-1)


def true_c(n, k):

    def fact(n):
        if n == 1 or n == 0:
            return 1
        return n * fact(n - 1)

    return fact(n) // (fact(k) * fact(n-k))


n, k = map(int, input().split())

print(c(n, k))
print(true_c(n, k))
