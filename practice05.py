def solution(x, n):
    if x >=0:
        a = list(range(x,x*n+1,x))
    else:
        a = list(range(x,x*n-1,x))
    return a