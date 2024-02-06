package level2.할인_행사;

import java.util.*;
import java.util.stream.Collectors;

class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> w = new HashMap<String, Integer>();
        for (int i=0; i<number.length; i++) {
            w.put(want[i], number[i]);
        }
        // 문자열 : substring(), split()
        // 문자열 리스트 :Arrays.copyOfRange(arr, 0, position);
        // List -> [] : a.toArray(new String[size]);
        // Array [] -> List : Arrays.asList();
        List<String> d = Arrays.asList(discount);

        // String[] 도 length
        for (int i=0; i<discount.length-9; i++) {
            // List 일부 : subList()
            List<String> de = d.subList(i, i+10);

            Map<String, Integer> cmp = new HashMap<String, Integer>(); // [] x, for문 o
            for (String e : de) {
                // Map : getOrDefault(get의 인자, 없을때 사용할 값)
                cmp.put(e, cmp.getOrDefault(e,0)+1);
            }

            if (w.equals(cmp)) {
                answer += 1;
            }
        }

        return answer;
    }
}