def solution(n):
    answer = 0
    for i in range(9,0,-1):
        if n // (10**i) !=0:
            answer += n // (10**i)
            n = n % (10**(i))
            print(i)
    answer += n // (1)
    return answer