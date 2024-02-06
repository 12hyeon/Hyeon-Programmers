def solution(cap, n, deliveries, pickups):
    d_val, p_val = 0, 0
    answer = 0

    for i in range(n):  # 누적시키면서 초과 여부 확인
        d_val += deliveries[n - i - 1]
        p_val += pickups[n - i - 1]

        while p_val > 0 or d_val > 0:  # 작업이 있는 경우
            d_val -= cap
            p_val -= cap
            answer += 2 * (n - i)  # 작업의 위치

    return answer