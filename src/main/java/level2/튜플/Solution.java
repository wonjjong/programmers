package level2.튜플;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {


    public static int[] solution(String s) {
        int[] answer = {};
        Set<Integer> set = new LinkedHashSet<>();
        HashMap<Integer, int[]> tuples = new HashMap<>();

        s = s.substring(1, s.length() - 1);
        int open = 0;
        int close = 0;
        int count = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '{' ) {
                open = i;
            } else if(s.charAt(i) == '}') {
                count++;
                close =i;
                int[] tuple = Arrays.stream(s.substring(open + 1, close).split(",")).
                        mapToInt(Integer::parseInt).toArray();

                tuples.put(tuple.length, tuple);
            }
        }

        for(int i=1; i<=count;i++) {
            int[] tuple = tuples.get(i);
            for (int value : tuple) {
                set.add(value);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
