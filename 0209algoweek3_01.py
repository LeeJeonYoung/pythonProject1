from sys import stdin
read = stdin.readline
n, m, v = map(int, read().split())
graph = [[0]*(N+1) for _ in range(N+1)]
visited = [False] * (N+1)

for _ in range(M):
    x, y = map(int, read().split())
    graph[x][y] = 1
    graph[y][x] = 1

def dfs(v):
    visited[v] = True
    print(v, end=" ")
    for i in range(1, n+1):
        if not visited[i] and graph[v][i] == 1:
            dfs(i)

def bfs(v):
    visited[v]= False
    queue = [v]
    while queue:
        v= queue.pop(0)
        print(v, end=" ")
        for i in range(1,n+1):
            if visited[i] and graph[v][i] ==1:
                queue.append(i)
                visited[i] = False
dfs(v)
print()
bfs(v)


