# 해결 : heap 삽입시, 가장 빨리 끝나는 방 확인

from heapq import heappop, heappush

def solution(book_time):
    answer = 1

    book_time_ref = []
    for b in book_time:
        now1 = list(map(int,b[0].split(':')))
        now2 = list(map(int,b[1].split(':')))
        book_time_ref.append([now1[0]*60 + now1[1], now2[0]*60 + now2[1]])
    book_time_ref.sort()

    heap = []
    for s, e in book_time_ref:
        if not heap:
            heappush(heap,e)
            continue
        if heap[0] <= s: # 가장 빨리 끝나는 대실 -> 다음 손님
            heappop(heap)
        else:
            answer += 1
        heappush(heap,e+10)

    return answer