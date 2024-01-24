def solution(want, number, discount):
    answer = 0

    lw = len(want)
    ld = len(discount)
    n = len(number)

    # 숫자로 매칭
    pd = []
    p = []
    dsc = []
    for d in discount:
        if d not in pd:
            pd.append(d)
        dsc.append(pd.index(d))
    wnt = []
    for w in want:
        if w not in pd:
            pd.append(w)
        wnt.append(pd.index(w))

    # 목표 숫자로
    goal = [0] * len(pd)
    for i, w in enumerate(want):
        idx = pd.index(w)
        goal[idx] += number[i]

    # print(pd, goal)
    # print(dsc, wnt)

    def cmp(a, b):  # now, goal
        for i in range(len(a)):
            if a[i] < b[i]:
                return 0
        return 1

    # 첫날 결재
    now = [0] * len(pd)
    for i in range(min(ld, 10)):
        now[dsc[i]] += 1
    answer += cmp(now, goal)
    # print(pd)
    # print(now)

    s = 0  # 미포함
    end = 10  # 포함
    for _ in range(ld - 10):
        now[dsc[s]] -= 1
        if end < ld:
            now[dsc[end]] += 1
        answer += cmp(now, goal)
        # print(now, goal)

        s += 1
        end += 1
    return answer