import math


def solution(fees, records):
    in_ = dict()
    fee = dict()

    for x in records:
        a, b, c = x.split()
        h, m = a.split(':')
        time = int(h) * 60 + int(m)

        if c == 'IN':
            in_[b] = time
        else:
            fee[b] = fee.get(b, 0) + (time - in_[b])  # dict.get(key, 없는 경우 반환 값)
            del in_[b]

    for x in in_:  # out이 없는 경우
        fee[x] = fee.get(x, 0) + 23 * 60 + 59 - in_[x]

    answer = []
    for x, y in sorted(fee.items()):
        if y > fees[0]:
            answer.append(fees[1] + math.ceil((y - fees[0]) / fees[2]) * fees[3])
        else:
            answer.append(fees[1])

    return answer