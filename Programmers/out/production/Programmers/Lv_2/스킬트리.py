def solution(skill, skill_trees):
    answer = 0
    leng = len(skill)
    for em in skill_trees:
        i = 0
        st = 1 # 가능한 경우
        for e in em:
            if e in skill[i+1:]: # 뒤 skill 먼저
                st = 0
                break
            elif e == skill[i]: # skill 바견
                i += 1 # 다음 skill을 비교하게
                if i == leng:
                    break
        if st == 1:
            answer += 1
    return answer