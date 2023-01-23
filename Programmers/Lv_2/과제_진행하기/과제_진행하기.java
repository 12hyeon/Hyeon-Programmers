import java.util.*;

class Solution {
    public ArrayList<String> solution(String[][] plans) {
        ArrayList<String[]> p = new ArrayList<>(); // import & String[]로 타입 지정

        for (String[] plan : plans) {
            int time = Integer.parseInt(plan[1].substring(0, 2)) * 60
                + Integer.parseInt(plan[1].substring(3)); // 인덱스 : [], 문자 : [].substring(i)
            p.add(new String[]{plan[0], Integer.toString(time), plan[2]});
            // 숫자 : Integer.parseInt() & 문자 : Integer.toString()
            // 문자 리스트 : new String[] {}
        }

        p.sort((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        // 정렬 : new Comparator<String[]>() -> compare 함수 재정의

        ArrayList<String[]> q = new ArrayList<>(); // queue : new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        int length = plans.length;

        for (int i = 0; i < length - 1; i++) {
            int df = Integer.parseInt(p.get(i + 1)[1]) - Integer.parseInt(p.get(i)[1]);

            if (df < Integer.parseInt(p.get(i)[2])) {
                int remaining = Integer.parseInt(p.get(i)[2]) - df;
                q.add(new String[]{p.get(i)[0], Integer.toString(remaining)});
            } else {
                df -= Integer.parseInt(p.get(i)[2]);
                answer.add(p.get(i)[0]);

                while (df > 0 && !q.isEmpty()) { // 비었는지 : .isEmpty()
                    if (df >= Integer.parseInt(q.get(q.size() - 1)[1])) { // ArrayList -> .get(i)로 접근 & 문자는 []
                        df -= Integer.parseInt(q.get(q.size() - 1)[1]);
                        answer.add(q.get(q.size() - 1)[0]);
                        q.remove(q.size() - 1);
                    } else {
                        int remaining = Integer.parseInt(q.get(q.size() - 1)[1]) - df;
                        q.get(q.size() - 1)[1] = Integer.toString(remaining);
                        // ArrayList<String[]> 인경우 set : a.get(i)[j] = x;
                        // 여러 타입 저장시, 객체(인자, 생성자) 이용
                        break;
                    }
                }
            }
        }

        answer.add(p.get(p.size() - 1)[0]);

        while (!q.isEmpty()) {
            answer.add(q.get(q.size() - 1)[0]);
            q.remove(q.size() - 1);
        }

        return answer;
    }
}
