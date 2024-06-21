import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        // n을 k 진법으로 변환
        String binary = convertToKBase(n, k);

        // 0을 기준으로 문자열 분리
        String[] nums = binary.split("0");

        // 각 분리된 문자열을 소수 여부 체크
        for (String str : nums) {
            if (!str.isEmpty()) {
                long checkNum = Long.parseLong(str);
                if (isPrime(checkNum)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static String convertToKBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long checkNum) {
        if (checkNum <= 1) return false;
        if (checkNum == 2 || checkNum == 3) return true;
        if (checkNum % 2 == 0 || checkNum % 3 == 0) return false;

        // 6k ± 1 규칙 사용
        for (long i = 5; i * i <= checkNum; i += 6) {
            if (checkNum % i == 0 || checkNum % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}