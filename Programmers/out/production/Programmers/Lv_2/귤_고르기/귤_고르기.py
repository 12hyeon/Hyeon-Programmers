import heapq

# 우선순위 큐 사용
def solution(k, tangerine):
    answer = 0
    dt = {}
    for t in tangerine:
        if t not in dt:
            dt[t] = 1
        else:
            dt[t] += 1
    hq = []
    for x in dt.keys():
        heapq.heappush(hq, -dt[x])

    x = 0
    while x < k:
        x += -heapq.heappop(hq)
        answer += 1

    return answer