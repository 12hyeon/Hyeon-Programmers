import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int ly = maps.length;
        int lx = maps[0].length;
        int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new LinkedList<>();
        int[][] vst = new int[ly][lx]; // 0

        q.add(new int[]{0,0,1});
        vst[0][0] = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == ly-1 && p[1] == lx-1) {
                return p[2];
            }
            //System.out.print(p[0] + "" +  p[1]);

            for (int dr[] : d) {
                int y = p[0] + dr[0];
                int x = p[1] + dr[1];

                if (0 <= y && y < ly && 0 <= x && x < lx && maps[y][x] == 1 && vst[y][x] == 0) {
                    vst[y][x] = 1;
                    q.add(new int[]{y, x, p[2]+1});
                }
            }
        }

        return answer;
    }
}