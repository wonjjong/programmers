package level2.캐시;

import java.util.LinkedList;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> q = new LinkedList<>();
        ignoreCase(cities);
        int answer = 0;

        if (cacheSize == 0) return answer += (cities.length * 5);

        for (int i = 0; i < cities.length; i++) {
            int index = q.indexOf(cities[i]);

            if (index != -1) {
                q.remove(index);
                q.addFirst(cities[i]);
                answer += 1;
            } else {
                if (q.size() >= cacheSize) {
                    q.removeLast();
                }
                q.addFirst(cities[i]);
                answer += 5;
            }
        }
        return answer;
    }

    public void ignoreCase(String[] cities) {
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
    }
}
