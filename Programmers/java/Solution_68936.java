/**
 * 쿼드압축 후 개수 세기 - Level 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */

class Solution_68936 {

    private int[][] a;
    private int m = 0;

    private void check(int y1, int x1, int y2, int x2) {
        if (y1 + 1 == y2) {
            return;
        }
        if (isUniform(y1, x1, y2, x2) == 0) {
            int s = (y2 - y1) / 2;
            check(y1, x1, y1 + s, x1 + s);
            check(y1, x1 + s, y1 + s, x2);
            check(y1 + s, x1, y2, x1 + s);
            check(y1 + s, x1 + s, y2, x2);
        } else {
            int value = a[y1][x1];
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    a[i][j] = 2;
                }
            }
            a[y1][x1] = value;
        }
    }

    private int isUniform(int y1, int x1, int y2, int x2) {
        int cmp = a[y1][x1];
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                if (a[i][j] != cmp) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};

        int ny = arr.length;
        int nx = arr[0].length;
        m = ny;

        a = new int[ny][nx];
        for (int j = 0; j < ny; j++) {
            for (int i = 0; i < nx; i++) {
                a[j][i] = arr[j][i];
            }
        }

        if (isUniform(0, 0, ny, nx) == 1) {
            if (a[0][0] == 0) {
                return new int[] {1, 0};
            } else {
                return new int[] {0, 1};
            }
        }

        check(0, 0, ny, nx);

        for (int j = 0; j < ny; j++) {
            for (int i = 0; i < nx; i++) {
                if (a[j][i] == 0) {
                    answer[0] += 1;
                } else if (a[j][i] == 1) {
                    answer[1] += 1;
                }
            }
        }

        return answer;
    }
}