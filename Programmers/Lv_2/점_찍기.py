def solution(k, d):
    answer = 0
    s = d * d
    std = (d + 1) // k + 1

    j = std  # k배 계산을 위한 y,x외 i,j 이용
    i = 0
    while i < std:
        y = i * k
        x = j * k
        while (y * y) + (x * x) > s:  # 원의 방정식
            j -= 1
            if j < 0:
                break
            x = j * k
        # print(y, x, j+1)
        answer += j + 1
        i += 1

    return answer