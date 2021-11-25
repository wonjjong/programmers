package level2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Solution {

    public static int solution(String str1, String str2) {
        double answer = 0;

        //대소문자 무시
        str1 = str1.toUpperCase(Locale.ROOT);
        str2 = str2.toUpperCase(Locale.ROOT);
        HashMap<String, Integer> strings1 = makeMultipleMap(str1);
        HashMap<String, Integer> strings2 = makeMultipleMap(str2);

        //교집합
        int intersect = 0;
        for (String s : strings1.keySet()) {
            if (strings2.containsKey(s)) {
                intersect += Math.min(strings1.get(s), strings2.get(s));
            }
        }

        //합집합
        int union = 0;
        for (String s : strings1.keySet()) {
            if (strings2.containsKey(s)) {
                union += Math.max(strings1.get(s), strings2.get(s));
            } else union += strings1.get(s);
        }
        for (String s : strings2.keySet()) {
            if (!strings1.containsKey(s)) {
                union += strings2.get(s);
            }
        }

       double similarity = intersect / (double) union;

        if (strings1.size() == 0 && strings2.size() == 0) answer = 1;
        else
            answer = similarity * 65536;

        return (int) answer;
    }

    public static HashMap<String, Integer> makeMultipleMap(String str) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                String element = str.substring(i, i + 2);
                map.put(element, map.containsKey(element) ? map.get(element) + 1 : 1);
            }
        }
        return map;
    }
}
