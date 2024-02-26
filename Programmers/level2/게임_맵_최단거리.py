from collections import deque


def solution(maps):
    x = [0, 0, -1, 1]
    y = [1, -1, 0, 0]
    col = len(maps)
    row = len(maps[0])
    vst = [[1] * row for _ in range(col)]
    vst[0][0] = 0

    b = deque([[0, 0, 1]])
    while b:  # bfs
        ny, nx, n = b.pop()
        if ny == col - 1 and nx == row - 1:
            return n
        for i in range(4):
            my = ny + y[i]
            mx = nx + x[i]
            if my < 0 or mx < 0 or my == col or mx == row:
                continue
            if maps[my][mx] == 1 and vst[my][mx] == 1:
                b.append([my, mx, n + 1])
                vst[my][mx] = 0
        #print(b)
    return -1