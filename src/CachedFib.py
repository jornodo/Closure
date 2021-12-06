def cache(func):
    cache = {}

    def wrapper(*args):
        if args not in cache:
            result = func(*args)
            print("putting " + str(*args) + " in cache as " + str(result))
            cache[args] = result
        return cache[args]

    return wrapper


@cache
def fib(n):
    if n < 2:
        return n
    return fib(n - 1) + fib(n - 2)


def main():
    print(fib(5))


if __name__ == '__main__':
    main()

# Output:
# putting 1 in cache as 1
# putting 0 in cache as 0
# putting 2 in cache as 1
# putting 3 in cache as 2
# putting 4 in cache as 3
# putting 5 in cache as 5
# 5
