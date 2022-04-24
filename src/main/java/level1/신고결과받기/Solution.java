package level1.신고결과받기;

import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> id = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();

        for (String s : id_list) {
            id.put(s, 0);
        }

        for (String rep : report) {
            String[] split = rep.split(" ");
            String a = split[0];
            String b = split[1];

            if (map.containsKey(b)) {
                map.get(b).add(a);
            } else {
                Set<String> strings = new HashSet<>();
                strings.add(a);
                map.put(b, strings);
            }
        }

        for (String key : map.keySet()) {
            Set<String> value = map.get(key);
            if (value.size() >= k) {
                for (String v : value) {
                    id.put(v, id.get(v) + 1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = id.get(id_list[i]);
        }

        return answer;
    }
}