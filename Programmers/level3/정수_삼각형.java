import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        // 한 개의 최대 값으로 모이게
        for (int i = n - 2; i >= 0; i--) { // 아래 2번째 단에서 위로
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
