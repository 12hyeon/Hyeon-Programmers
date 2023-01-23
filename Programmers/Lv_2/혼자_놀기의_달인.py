def solution(cards):
    global cnt
    vst = [False for i in range(len(cards) + 1)]
    tmp = [0]

    for i in range(1, len(cards) + 1):
        cnt = 1
        if vst[i] == False:
            vst[i] = True
            find(i, vst, cards)  # 해당 위치를 인덱스로 시작한 cycle 탐색
            tmp.append(cnt)
    t = sorted(tmp, reverse=True)
    return t[0] * t[1]


def find(i, vst, cards):  # 받은 인덱스의 값을 확인 : cards[i-1]
    global cnt
    if vst[cards[i - 1]] == False:
        vst[cards[i - 1]] = True
        cnt += 1
        find(cards[i - 1], vst, cards)