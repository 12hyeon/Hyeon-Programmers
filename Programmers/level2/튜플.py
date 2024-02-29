def solution(s):
    std = []
    n = ""
    for i in s:
        if i == '{':
            v = []
        elif i == '}':
            if n != '-1':
                v.append(int(n))
                n = '-1'
            std.append(v)
            v = []
        elif i == ',':
            v.append(int(n))
            n = ""
        else:
            n += i
    std = sorted(std[:-1], key=lambda x: len(x))

    answer = []
    for i in range(len(std)):
        x = std[i]
        if len(x) == 1:
            answer.append(x[0])
        else:
            for j in std[i]:
                if j not in std[i - 1]:
                    answer.append(j)
                    break

    return answer