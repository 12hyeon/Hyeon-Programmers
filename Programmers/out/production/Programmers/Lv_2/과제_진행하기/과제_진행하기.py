# hour + minute은 분으로 통일
# while문에서 비교 후 처리 꼼꼼히!

def solution(plans):
    p = [[str(n), int(t[:2]) * 60 + int(t[3:]), int(d)] for n, t, d in plans]
    p.sort(key=lambda x: x[1])  # 시간은 분으로

    q = []
    answer = []
    leng = len(plans)

    for i in range(0, leng - 1):
        df = p[i + 1][1] - p[i][1]
        if (df < p[i][2]):  # 미완료
            q.append([p[i][0], p[i][2] - df])
        else:
            df -= p[i][2]
            answer.append(p[i][0])
            while df > 0 and len(q) > 0:  # 남은 시간
                if df >= q[-1][1]:
                    df -= q[-1][1]  # 필요
                    answer.append(q.pop()[0])
                else:
                    q[-1][-1] -= df
                    break
    answer.append(p[-1][0])
    while q:
        answer.append(q.pop()[0])
    return answer