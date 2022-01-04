def solution(s):
    a = list(s)
    a.sort(reverse=True)
    b = ''.join(a)
    return b
