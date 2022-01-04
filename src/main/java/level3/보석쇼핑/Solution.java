package level3.보석쇼핑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemSet = new HashSet<>();

        for (String gem : gems) {
            gemSet.add(gem);
        }

        int gemCount = gemSet.size();

        int startIndex = 0;
        int endIndex = 0;
        int diff = Integer.MAX_VALUE;
        Map<String, Integer> shoppingList = new HashMap<>();

        while (endIndex < gems.length) {
            shoppingList.put(gems[endIndex], shoppingList.getOrDefault(gems[endIndex], 0) + 1);
            endIndex++;

            if (shoppingList.size() == gemCount) {

                while (shoppingList.size() == gemCount) {
                    if (shoppingList.get(gems[startIndex]) == 1) {
                        break;
                    } else {
                        shoppingList.put(gems[startIndex], shoppingList.get(gems[startIndex]) - 1);
                    }
                    startIndex++;
                }
                int d = endIndex - startIndex;
                if (d < diff) {
                    diff = d;
                    answer[0] = startIndex+1 ;
                    answer[1] = endIndex;
                }
            }
        }

        if (shoppingList.size() == gemCount) {

            while (shoppingList.size() == gemCount) {
                if (shoppingList.get(gems[startIndex]) == 1) {
                    break;
                } else {
                    shoppingList.put(gems[startIndex], shoppingList.get(gems[startIndex]) - 1);
                }
                startIndex++;
            }
            int d = endIndex - startIndex;
            if (d < diff) {
                diff = d;
                answer[0] = startIndex+1 ;
                answer[1] = endIndex;
            }

        }
        return answer;

    }
}
