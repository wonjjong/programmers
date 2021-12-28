package level3.야근지수;

import java.util.*;

public class Solution {

    public static long solution(int n, int[] works) {
        long answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int i=0; i<works.length;i++) {
            map.put(works[i], map.getOrDefault(works[i],0) +1);
        }

        while( n > 0 ) {

            if(map.firstEntry().getValue() >0) {
                map.put(map.firstKey(), map.firstEntry().getValue()-1);

                if(map.firstEntry().getKey() >0)
                map.put(map.firstKey()-1, map.getOrDefault(map.firstKey()-1, 0) + 1);

                if(map.firstEntry().getValue() == 0){
                    map.remove(map.firstKey());
                }
            }

            if(map.size() == 0) break;
            n--;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer += ((long) Math.pow(entry.getKey(), 2)) * entry.getValue();
        }

        return answer;
    }
}
