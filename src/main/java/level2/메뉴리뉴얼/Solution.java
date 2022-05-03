package level2.메뉴리뉴얼;

import java.util.*;

public class Solution {
    static boolean v[];
    static Map<String, Integer> comb = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        HashSet<String> result = new HashSet<>();

        for (String order : orders) {
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            order = String.valueOf(orderChar);
        }

        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            v = new boolean[order.length()];
            for (int j = 0; j < course.length; j++) {
                int courseCount = course[j];
                makeAllCombination(0, 0, courseCount, order.length(), order);
            }
        }

        for (int i = 0; i < course.length; i++) {
            int courseCnt = course[i];
            int max = 1;
            int count = 0;
            for (String key : comb.keySet()) {
                if (key.length() == courseCnt && comb.get(key) > max) {
                    max = comb.get(key);
                }
            }
            for (String key : comb.keySet()) {
                if (key.length() == courseCnt && comb.get(key) == max && comb.get(key) >= 2) {
                    result.add(key);
                }
            }
        }

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    private static void makeAllCombination(int index, int count, int courseCount, int size, String order) {
        if (count == courseCount) {
            String temp = "";
            for (int i = 0; i < v.length; i++) {
                if (v[i]) {
                    temp += order.charAt(i);
                }
            }
            char[] tempToChar = temp.toCharArray();
            Arrays.sort(tempToChar);
            comb.put(String.valueOf(tempToChar), comb.getOrDefault(String.valueOf(tempToChar), 0) + 1);
            return;
        }

        if (index >= size) return;

        v[index] = true;
        makeAllCombination(index + 1, count + 1, courseCount, size, order);
        v[index] = false;
        makeAllCombination(index + 1, count, courseCount, size, order);

    }
}