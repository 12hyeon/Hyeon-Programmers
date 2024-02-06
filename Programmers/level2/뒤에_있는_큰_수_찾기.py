def solution(numbers):
    stack = []
    answer = [-1] * len(numbers)

    # 넣기 전에, 이전 stack보다 크면 stack 값 처리
    for i in range(len(numbers)):
            while stack and numbers[stack[-1]] < numbers[i]:
                answer[stack.pop()] = numbers[i]
            stack.append(i)

    return answer