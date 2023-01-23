def solution(users, emoticons):
    answer = [0, 0]
    per = [10, 20, 30, 40]
    com = []

    # 이모티콘 할인율 구하기 : 런타임
    def dfs(temp, depth):
        if depth == len(temp):
            com.append(temp[:])
            return
        for d in per:
            temp[depth] += d
            dfs(temp, depth + 1)
            temp[depth] -= d

    dfs([0] * len(emoticons), 0)
    # 완전 탐색
    for comb in com:
        num = 0
        price = [0] * len(users)
        for u in range(len(users)):
            for e in range(len(emoticons)):
                if users[u][0] <= comb[e]:  # 할인률 조건
                    price[u] += emoticons[e] * (100 - comb[e]) / 100

        #  플러스 서비스 가입자 계산
        for u in range(len(users)):
            if users[u][1] <= price[u]:  # 가격 이상
                num += 1
                price[u] = 0

        # 최대 가입자, 최대 판매액 : 런타임
        if num == answer[0]:
            answer[1] = max(answer[1], sum(price))
            answer[0] = num
        elif num > answer[0]:
            answer[1] = sum(price)
            answer[0] = num

    return answer