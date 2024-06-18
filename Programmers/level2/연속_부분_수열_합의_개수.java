import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        int s = 0;
        for (int e : elements) {
            s += e;
        }

        int[] can = new int[s+1];
        int l = elements.length;
        for (int i=0; i<l; i++) {
            int v = elements[i];
            int now = i+1;

            while (v < s) {
                can[v] = 1;
                v += elements[(now%l)];
                now += 1;
            }
        }

        for (int x : can) {
            if (x == 1) answer += 1;
        }

        return answer+1; // sum = 0
    }
}