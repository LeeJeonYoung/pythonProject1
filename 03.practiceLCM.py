def solution(n, m):
    answer = []

    def GCD(x, y):
        while (y):
            x, y = y, x % y
        return x

    def LCM(x, y):
        result = (x * y) // GCD(x, y)
        return result

    answer = [GCD(n, m), LCM(n, m)]
    return answer