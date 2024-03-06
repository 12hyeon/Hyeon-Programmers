import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = checkDistancing(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkDistancing(String[] p) {
        for (int k = 0; k < p.length; k++) {
            String s = p[k];
            for (int i = 0; i < s.length(); i++) {
                char t = s.charAt(i);

                if (t == 'P') {
                    Queue<int[]> q = new LinkedList<>();
                    boolean[][] visited = new boolean[p.length][s.length()]; // 속도
                    int[] dy = {0, 0, 1, -1};
                    int[] dx = {1, -1, 0, 0};
                    q.offer(new int[]{k, i});
                    visited[k][i] = true;

                    while (!q.isEmpty()) {
                        int[] n = q.poll();

                        if (n[2] > 0 && p[n[0]].charAt(n[1]) == 'P') {
                            return false;
                        }

                        for (int j = 0; j < 4; j++) {
                            int y = n[0] + dy[j];
                            int x = n[1] + dx[j];
                            if (isValid(y, x, p.length, s.length()) && !visited[y][x] && p[y].charAt(x) != 'X' && Math.abs(k - y) + Math.abs(i - x) <= 2) {
                                visited[y][x] = true; // Math.abs()
                                q.offer(new int[]{y, x});
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    // 성능 개선을 위함
    private boolean isValid(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
