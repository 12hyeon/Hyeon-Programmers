def solution(storey):
    answer = 0

    while storey:
        n = storey % 10
        # 6 ~ 9
        if n > 5:
            answer += (10 - n)
            storey += 10
        # 0 ~ 4
        elif n < 5:
            answer += n
        # 5
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += n
        storey //= 10

    return answer
