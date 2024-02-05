def solution(picks, minerals):
    cnt = 0
    n = []
    v  = [0,0,0]
    for m in minerals: # 문자를 숫자화
        if cnt== 5: # 처리 단위별 분리
            n.append(v)
            v = [0,0,0]
            cnt = 0
        if m == "diamond":
            v[0] += 1
        elif m == "iron":
            v[1]+= 1
        else:
            v[2] += 1
        cnt += 1
    if cnt > 0:
        n.append(v)

    if len(n) <= sum(picks):
        n.sort(reverse = True)
    else: # 최대 막대기의 개수만큼 내용 정렬
        n = sorted(n[:sum(picks) ], reverse = True)

    answer = 0
    p = 0
    m = 0
    while m < len(n):
        while p < 3 and picks[p] == 0 :
            p += 1
        if p == 3:
            break
        picks[p] -= 1
        for i in range(3):
            x = n[m][i]
            if p > i:
                answer += 5**(p-i)*x
            else:
                answer += 1*x
        m += 1
    return answer