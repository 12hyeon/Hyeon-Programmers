def solution(N, road, K):
    answer = 0

    goal = []
    d = [[10 ** 10] * (N + 1) for _ in range(N + 1)]
    for a, b, c in road:
        d[a][b] = min(c, d[a][b])
        d[b][a] = min(c, d[b][a])
    for i in range(1, N + 1):
        d[i][i] = 0

    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if i != j:
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j])

    for i in d[1][1:]:
        if i <= K:
            answer += 1

    return answer