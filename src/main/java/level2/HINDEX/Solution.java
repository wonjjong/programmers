package level2.HINDEX;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i <= citations.length; i++) {
            int j = 0;
            for (; j < citations.length; j++) {
                if (citations[j] >= i) break;
            }
            if (citations.length - j >= i && j <= i) {
                answer = i;
            }
        }

        return answer;
    }
}
