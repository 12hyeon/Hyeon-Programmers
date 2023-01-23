import heapq

def solution(n, k, enemy):
    if k >= len(enemy):
        return len(enemy)
    pq = []

    for i in range(len(enemy)):
        heapq.heappush(pq, enemy[i])
        if len(pq) > k:
            last = heapq.heappop(pq)
            if last > n:
                return i
            n -= last
    return len(enemy)