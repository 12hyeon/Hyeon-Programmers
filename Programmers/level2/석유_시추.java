import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int c = land.length;
        int r = land[0].length;
        int[] cmp = new int[r];

        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        int[][] vst = new int[c][r];

        for (int i=0; i<c; i++) {
            for (int j=0; j<r; j++) {

                if (land[i][j] == 1 && vst[i][j] == 0) {
                    int cnt = 0;
                    int[] st = new int[r];

                    Deque<int[]> d = new LinkedList<int[]>();
                    d.offer(new int[] {i,j});
                    vst[i][j] = 1;
                    cnt += 1;

                    while (!d.isEmpty()) {
                        int[] n = d.poll();
                        st[n[1]] = 1;
                        for (int q=0; q<4; q++) {
                            int y = dy[q] + n[0];
                            int x = dx[q] + n[1];

                            if (0<=y && y<c && 0<=x && x<r && vst[y][x] == 0 && land[y][x] == 1) {
                                d.offer(new int[] {y,x});
                                cnt += 1;
                                vst[y][x] = 1;
                            }
                        }
                    }

                    for (int s=0; s<r; s++) {
                        if (st[s] == 1) {
                            cmp[s] += cnt;
                            if (cmp[s] > answer)
                                answer = cmp[s];
                        }
                        //System.out.print(cmp[s]+", ");
                    }
                    //System.out.println();

                }
            }
        }

        return answer;
    }
}