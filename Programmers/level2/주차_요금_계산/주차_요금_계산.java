import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> m = new TreeMap<String, Integer>(); // key 이름에 따라 정렬
        Map<String, Integer> input = new HashMap<String, Integer>();

        for (String r : records) {
            String[] v = r.split(" "); // t, car, state
            String[] t = v[0].split(":");
            int time = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);

            if (v[2].equals("IN")) { // .equals()
                input.put(v[1], time); // map.put()
            } else {
                int tm = time - input.get(v[1]);
                if (m.containsKey(v[1])) { // 출차 기록
                    m.put(v[1], m.get(v[1]) + tm);
                } else {
                    m.put(v[1], tm);
                }
                input.remove(v[1]);
            }
        }

        // 수정: 아직 출차하지 않은 차량 처리
        for(String c : input.keySet()) {
            int time = 23 * 60 + 59 - input.get(c);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + time);
            } else {
                m.put(c, time);
            }
        }

        int[] answer = new int[m.size()];
        int i = 0;

        for (String c : m.keySet()) {
            int tm = fees[1];
            int rest = m.get(c) - fees[0];
            if (rest > 0) {
                if (rest % fees[2] != 0) {
                    tm += fees[3];
                }
                tm += fees[3] * (rest / fees[2]);
            }
            answer[i] = tm;
            i++;
        }

        // Arrays.sort(answer); 값 정렬 방법
        return answer;
    }
}
