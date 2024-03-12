import java.util.*;

// String -> char[] : s.toCharArray();
// char 혹은 int (기본형) 비교는 ==

class Solution {

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] base = new char[m][n];
        int t = 0;
        for (String b : board) {
            base[t] = b.toCharArray();
            t++;
        }

        int count = -1;
        while (count != 0) {
            count = 0;
            int[][] vst = new int[m][n]; // 0
            for (int y = m-2; y >= 0; y--) {
                for (int x = 0; x < n-1; x++) {
                    char v = base[y][x];
                    if (v != '-' && base[y][x+1] == v && v == base[y+1][x] && v == base[y+1][x+1]) {
                        for(int[] q : new int[][] {{y,x},{y,x+1},{y+1,x},{y+1,x+1}}) {
                            if (vst[q[0]][q[1]] != 1) {
                                vst[q[0]][q[1]] = 1;
                                count += 1;
                            }
                        }
                    }
                }
            }

            // 표시 및 개수 세기
            for (int y = m-1; y >= 0; y--) {
                for (int x = 0; x < n; x++) {
                    if (vst[y][x] > 0) {
                        base[y][x] = '-';
                        vst[y][x] = -1; // 제거된 자리, 존재, 삭제될 예정
                    }
                }
                //System.out.println(Arrays.toString(base[y]));
            }

            // 본인 한칸만 내리기
            for (int x = 0; x < n; x++) {
                for (int y = m-1; y >= 0; y--) {
                    int ny = y;
                    if (base[y][x] == '-') {
                        while (ny > 0) {
                            if (base[ny-1][x] != '-') {
                                base[y][x] = base[ny-1][x];
                                base[ny-1][x] = '-';
                                break;
                            }
                            ny--;
                        }
                        if (ny == 0 && base[y][x] == '-')
                            base[y][x] = '-';
                    }
                    //System.out.println(Arrays.toString(base[y]));
                }
                //System.out.println();
            }
            answer += count;
        }

        return answer;
    }
}