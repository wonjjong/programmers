package level1.성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    static String answer = "";
    public static String solution(String[] survey, int[] choices) {
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);

            int num = choices[i];
            switch (num) {
                case 1:
                    map.put(a, map.get(a) + 3);
                    break;
                case 2:
                    map.put(a, map.get(a) + 2);
                    break;
                case 3:
                    map.put(a, map.get(a) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(b, map.get(b) + 1);
                    break;
                case 6:
                    map.put(b, map.get(b) + 2);
                    break;
                case 7:
                    map.put(b, map.get(b) + 3);
                    break;

            }
        }

        addAnswer('R','T');
        addAnswer('C','F');
        addAnswer('J','M');
        addAnswer('A','N');

        return answer;
    }

    public static void addAnswer(char a, char b) {
        if((int)map.get(a) > (int)map.get(b)) {
            answer += a;
        } else if((int)map.get(a) == (int)map.get(b)) {
            answer += a;
        } else {
            answer += b;
        }
    }
}
