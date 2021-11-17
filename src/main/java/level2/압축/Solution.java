package level2.압축;

import java.util.*;

class Solution {
    public static final String[] UPPER_ALPHA = {
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};

    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<String> dictionary = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            dictionary.add(UPPER_ALPHA[i - 1]);
        }

        for (int i = 0; i < msg.length(); i++) {
            for (int j = dictionary.size() - 1; j >= 0; j--) {
                String word = dictionary.get(j);

                if (msg.substring(i).startsWith(word)) {
                    if (i + word.length() < msg.length()) {
                        dictionary.add(word + msg.charAt(i + word.length()));
                    }

                    answer.add(j + 1);

                    i += word.length() - 1;
                    break;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
