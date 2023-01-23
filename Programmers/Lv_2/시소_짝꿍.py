def solution(weights):
    answer = 0

    dt = {}  # weight별 개수
    for w in weights:
        if w in dt:
            dt[w] += 1
        else:
            dt[w] = 1

    ratio = [[2, 3], [1, 2], [3, 4]]  # 비율

    for i in dt:
        if dt[i] > 1:  # 중복
            answer += (dt[i] * (dt[i] - 1)) / 2

        for a, b in ratio:
            if i * a / b in dt:
                answer += dt[i] * dt[i * a / b]

    return answer