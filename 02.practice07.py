def solution(arr):
    for i in range(len(arr) - 1):
        for j in range(max(arr[i], arr[i + 1]), (arr[i] * arr[i + 1] + 1)):
            if ((j % arr[i] == 0) and (j % arr[i + 1] == 0)):
                arr[i + 1] = j
                break

    return arr[len(arr) - 1]