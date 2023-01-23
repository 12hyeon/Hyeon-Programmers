def solution(sequence, k):
    answers = []
    sum = 0
    l = 0
    r = 0

    # 시작점과 끝점 이동으로
    while True:
        if sum < k:
            if r >= len(sequence):
                break
            sum += sequence[r]
            r += 1
        else:
            sum -= sequence[l]
            if l >= len(sequence):
                break
            l += 1
        if sum == k:
            answers.append([l, r-1])

    answers.sort(key=lambda x: (x[1]-x[0], x[0]))
    return answers[0]