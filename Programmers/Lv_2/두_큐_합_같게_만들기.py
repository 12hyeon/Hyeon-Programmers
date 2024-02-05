from collections import deque


def solution(q1, q2):
    answer = 0

    qu1 = deque(q1)
    qu2 = deque(q2)
    s1 = sum(q1)
    s2 = sum(q2)
    m = len(q1) * 4

    if (s1 + s2) % 2 == 1:
        return - 1

    while answer < m:
        if s1 < s2: # 둘 중 하나만 돌아갈 수 있게 if - elif 처리
            v = qu2.popleft()
            qu1.append(v)
            s1 += v
            s2 -= v
            answer += 1
        elif s1 > s2:
            v = qu1.popleft()
            qu2.append(v)
            s1 -= v
            s2 += v
            answer += 1
        else:
            return answer
    return -1