package level2.최댓값과최솟값;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Solution {
    public static String solution(String s) {
        String answer = "";

        String[] values = s.split(" ");

        int max = Arrays.stream(values).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(values).mapToInt(Integer::parseInt).min().getAsInt();
        answer = min + " " + max;
        return answer;
    }
}
