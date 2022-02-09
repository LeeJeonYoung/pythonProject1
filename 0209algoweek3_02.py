from sys import stdin

read = stdin.readline
n = int(input())
m = int(input())
v = 1
graph = [[0] * (n + 1) for _ in range(n + 1)]
visited = [False] * (n + 1)
array = []
for _ in range(m):
    x, y = map(int, read().split())
    graph[x][y] = 1
    graph[y][x] = 1


def dfs(v):
    visited[v] = True
    array.append(v)
    for i in range(1, n + 1):
        if not visited[i] and graph[v][i] == 1:
            dfs(i)


dfs(v)
print(len(array) - 1)
