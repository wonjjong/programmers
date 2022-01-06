package level3.불량사용자;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    static HashSet<String> answerSet = new HashSet<>();
    static ArrayList<ArrayList<String>> list = new ArrayList<>();

    public static int solution(String[] user_id, String[] banned_id) {

        for (int i = 0; i < banned_id.length; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < banned_id.length; i++) {
            String bannedId = banned_id[i];
            for (int j = 0; j < user_id.length; j++) {
                String userId = user_id[j];
                boolean result = true;
                if (userId.length() != bannedId.length()) continue;

                for (int x = 0; x < userId.length(); x++) {
                    if (bannedId.charAt(x) == '*' || userId.charAt(x) == bannedId.charAt(x)) continue;
                    else {
                        result = false;
                        break;
                    }
                } //loop
                if (result) list.get(i).add(userId);
            } //loop

        } //loop

        Set<String> combinationSet = new HashSet<>();
        bruteForce(0, 0, banned_id.length, combinationSet);
        return answerSet.size();
    }

    public static void bruteForce(int index, int size, int len, Set<String> combinationSet) {
        if (index == len) {
            String combinationString = combinationSet.stream().sorted().collect(Collectors.joining(""));
            answerSet.add(combinationString);
            return;
        }

        for (int i = 0; i < list.get(index).size(); i++) {
            if (combinationSet.contains(list.get(index).get(i))) continue;
            else {
                combinationSet.add(list.get(index).get(i));
            }
            bruteForce(index + 1, size + 1, len, combinationSet);
            combinationSet.remove(list.get(index).get(i));
        }

    }

}
