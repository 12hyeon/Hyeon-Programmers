class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length()/2; i++) {
            String target = s.substring(0, i); // 시작
            String cur = ""; //현재
            int cnt = 1;

            StringBuilder sb = new StringBuilder();

            for(int start = i; start <= s.length(); start += i) {
                if (start + i >= s.length()) { // 남는 부분
                    cur = s.substring(start, s.length());
                }
                else {
                    cur = s.substring(start, start + i);
                }

                // 압축
                if(cur.equals(target)) {
                    cnt++;
                }
                // 달라서 비교 대상 변경
                else if (cnt == 1) {
                    sb.append(target);
                    target = cur;
                }
                else {
                    sb.append(cnt).append(target);
                    target = cur;
                    cnt = 1;
                }
            }
            // 남은 것
            if (i != target.length()) sb.append(target);

            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}
