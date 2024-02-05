from collections import Counter

# list -> map : Counter로 각 인자의 개수
def solution(want, number, discount):
    answer = 0
    dic = {}
    for i in range(len(want)):
        dic[want[i]] = number[i] # want -> key-value

    for i in range(len(discount)-9): # 10개 묶음 수
        if dic == Counter(discount[i:i+10]): # 각 내용을 dict으로 생성
            answer += 1

    return answer