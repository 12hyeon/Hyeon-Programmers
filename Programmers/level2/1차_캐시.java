import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) { // 예외
            return cities.length * 5;
        }

        List<String> s = new ArrayList<>();
        for(String ct : cities) {
            String c = ct.toUpperCase();
            if (s.remove(c)) { // true
                s.add(c);
                answer += 1;
            } else { // false
                if (s.size() >= cacheSize && !s.isEmpty()) {
                    s.remove(0);
                }
                s.add(c);
                answer += 5;
            }
            //System.out.print(Integer.toString(answer) + " ");
        }

        return answer;
    }
}
