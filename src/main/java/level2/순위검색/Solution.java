package level2.순위검색;

import java.util.*;

public class Solution {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");

            makeAllCombination("-", split, 1);
            makeAllCombination(split[0], split, 1);
        }
        for (ArrayList<Integer> list : map.values()) {
            list.sort(Comparator.naturalOrder());
        }

        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", "");
            String key = q.split(" ")[0];
            int value = Integer.parseInt(q.split(" ")[1]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            ArrayList<Integer> values = map.get(key);
            int minIndex = binarySearch(values, value);
            answer[i] = values.size() - minIndex;

        }

        return answer;
    }

    public static int binarySearch(ArrayList<Integer> values, int value) {
        int start = 0, end = values.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (values.get(mid) < value)
                start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }

    public static void makeAllCombination(String temp, String[] split, int count) {
        if (count == 4) {
            map.computeIfAbsent(temp, k -> new ArrayList<>()).add(Integer.parseInt(split[4]));
            return;
        }
        makeAllCombination(temp + "-", split, count + 1);
        makeAllCombination(temp + split[count], split, count + 1);
    }
}

