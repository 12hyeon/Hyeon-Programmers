/**
 * 이진 변환 반복하기 - Level 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

import java.util.*;

class Solution {

    public int[] answer = new int[2];

    private String check(String s) {
        char [] a = s.toCharArray();
        int cnt = 0;
        for(int i : a) {
            if (i == '1') cnt += 1;
            else answer[1] += 1;
        }
        return Integer.toBinaryString(cnt);
    }

    public int[] solution(String s) {
        answer[0] = 1;
        String std = s;
        while (true) {
            String v = check(std);
            System.out.println(v);
            if (v.equals("1")) {
                break;
            } else {
                std = v;
            }
            answer[0] += 1;
        }

        return answer;
    }
}