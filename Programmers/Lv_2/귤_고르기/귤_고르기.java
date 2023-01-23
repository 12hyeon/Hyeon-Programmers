import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 배열(고정 길이) [] <-> List <> / 실제 값 {} 담기
        // Dict -> Map<key, entry>, List 부류는 뒤에 <>, int는 Integer
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        // 기본 자료형은 length <-> size()
        for (int t : tangerine) {
            if (m.containsKey(t)) { // HashMap.containKeys() 존재
                m.put(t, m.get(t)+1);
            } else {
                m.put(t, 1);
            }
        }

        // Queue : offer(), poll()
        Queue<Integer> p = new PriorityQueue<Integer>();
        int[] a = new int[m.size()];
        int i = 0;
        for(int x : m.keySet()) { // key, entry + Set()
            p.offer(-m.get(x));
        }

        int v = 0;
        while (v < k) {
            v += -p.poll();
            answer += 1;
        }

        return answer;
    }
}