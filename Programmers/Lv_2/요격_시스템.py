# hint : 가능한 경우가 아니라 범위로 비교

def solution(targets):
    answer = 0
    targets.sort(key = lambda x: [x[1], x[0]])
    e = 0
    for t in targets: # 시작과 끝 비교
        if t[0] >= e: # == : 요격 불가
            e = t[1]
            answer += 1
    return answer