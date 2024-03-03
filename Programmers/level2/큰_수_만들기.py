def solution(number, k):
    answer = []  # Stack

    for num in number:
        if not answer:
            answer.append(num)
            continue
        if k > 0: # 시작 가능한 값 범위에서 탐색 => 누적 : stack
            while answer[-1] < num:
                answer.pop()
                k -= 1
                if not answer or k <= 0:
                    break
        answer.append(num)

    answer = answer[:-k] if k > 0 else answer
    return ''.join(answer)