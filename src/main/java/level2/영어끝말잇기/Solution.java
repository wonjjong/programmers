package level2.영어끝말잇기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> checkDuplicateList = new ArrayList<>();
        checkDuplicateList.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() == 1) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)
                    && !checkDuplicateList.contains(words[i])) {
                checkDuplicateList.add(words[i]);
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

        }

        return answer;
    }


}
