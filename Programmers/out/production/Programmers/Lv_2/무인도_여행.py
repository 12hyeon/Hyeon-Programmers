from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def solution(maps):
    col, row = len(maps), len(maps[0])
    ground = []
    vst = [[0] * row for _ in range(col)]  # 주의

    def bfs(c, r):
        q = deque([[c, r]])
        result = 0

        while q:
            a, b = q.popleft()
            result += int(maps[a][b])

            for i in range(4):
                if 0 <= a + dy[i] < col and 0 <= b + dx[i] < row and maps[a + dy[i]][b + dx[i]] != 'X' and \
                        vst[a + dy[i]][b + dx[i]] == 0:
                    q.append([a + dy[i], b + dx[i]])
                    vst[a + dy[i]][b + dx[i]] = 1
        ground.append(result)

    for c in range(col):
        for r in range(row):
            if maps[c][r] != 'X' and vst[c][r] == 0:
                vst[c][r] = 1
                bfs(c, r)

    if len(ground) == 0:
        return [-1]
    ground.sort()
    return ground