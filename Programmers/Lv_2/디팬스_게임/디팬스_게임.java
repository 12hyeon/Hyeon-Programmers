// 비교 되야하는 범위를 알수 없으면, 앞부터 우선순위 q 후 초과마다 검사하게

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (k >= enemy.length) {
            return enemy.length;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int e : enemy) {
            q.offer(e);
            if (q.size() > k) {
                int x = q.poll();
                if (n >= x) {
                    n -= x;
                    answer += 1;
                }
                else {
                    return answer + k;
                }
            }
        }

        return answer + k;
    }
}