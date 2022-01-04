def solution(s):
    a = s.split(' ')
    ans =[]
    for i in range(len(a)):
        for j in range(len(a[i])):
            if j % 2 ==0:
                ans += a[i][j].upper()
            else:
                ans += a[i][j]
        if i < len(a)-1:
            ans = "".join(ans)
            ans += " "
        else :
            ans = "".join(ans)
    return ans