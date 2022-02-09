stack=[1]

    arr=[[1,2],[1,3],[1,4],[2,4],[3,4]]
    arr1=[]
for i of arr:
    if i[0] ==1:
        arr1=stack.pop(0)
        stack.append(i[1])
        v=i[1]
    elif i[1] == 1:
        arr1=stack.pop(0)
        stack.append(i[0])
        v=i[0]
    print(arr1)
    return arr1