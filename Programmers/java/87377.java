/**
 * 교점에 별 만들기 - Level 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */


import java.util.*;

class Solution {

    public String[] solution(int[][] line) {
        List<Long> ylist = new ArrayList<>();
        List<Long> xlist = new ArrayList<>();

        // 교차점 계산
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long gr = a * d - b * c;
                if (gr != 0) {
                    double x = (double) (b * f - e * d) / gr;
                    double y = (double) (e * c - a * f) / gr;

                    // 정수 좌표 확인
                    if (isInteger(x) && isInteger(y)) {
                        long intX = (long) x;
                        long intY = (long) y;

                        ylist.add(intY);
                        xlist.add(intX);
                    }
                }
            }
        }

        // 교차점이 없는 경우
        if (ylist.isEmpty()) {
            return new String[] {""};
        }

        // 최소, 최대 좌표 계산
        long ny = Collections.min(ylist);
        long my = Collections.max(ylist);
        long nx = Collections.min(xlist);
        long mx = Collections.max(xlist);

        // 결과 배열 구성
        int height = (int) (my - ny + 1);
        int width = (int) (mx - nx + 1);
        char[][] result = new char[height][width];
        for (char[] row : result) {
            Arrays.fill(row, '.');
        }

        // 교차점 표시
        for (int j = 0; j < ylist.size(); j++) {
            int y = (int) (ylist.get(j) - ny);
            int x = (int) (xlist.get(j) - nx);
            result[height - y - 1][x] = '*'; // 인덱스 조정하여 '*' 설정
            // 음수인 경우, 처리하기 위해서 height 이용
        }

        // 결과 문자열 배열 생성
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(result[i]);
        }

        return answer;
    }

    private boolean isInteger(double num) {
        return Math.floor(num) == num;
    }
}
