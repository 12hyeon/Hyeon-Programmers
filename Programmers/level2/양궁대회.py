from itertools import combinations_with_replacement

# 각 상황별로 == / < / > / 0인 경우 분리
def solution(n, info):
    answer = [-1]
    max_gap = 0  # 점수 차

    for combi in combinations_with_replacement(range(11), n):  # 중복 조합
        info2 = [0] * 11

        for i in combi:
            info2[10 - i] += 1

        apeach, lion = 0, 0
        for idx in range(11):
            if info[idx] == info2[idx] == 0:
                continue
            elif info[idx] >= info2[idx]:
                apeach += 10 - idx
            else:
                lion += 10 - idx

        if lion > apeach and lion - apeach > max_gap:  # 기존보다 더 큰 점수 차인 경우
                max_gap = lion - apeach
                answer = info2
    return answer