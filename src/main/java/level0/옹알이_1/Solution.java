package level0.옹알이_1;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] babbling) {
        String[] possiblePronunciation = new String[]{"aya", "ye", "woo", "ma"};

        // 가능한 모든 조합 생성
        Set<String> allCombination = new HashSet<>();

        int length = 4;
        for (int i = 0; i < length; i++) {
            allCombination.add(possiblePronunciation[i]);
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                allCombination.add(possiblePronunciation[i] + possiblePronunciation[j]);
                for (int k = 0; k < length; k++) {
                    if (i == k || j == k) continue;
                    allCombination.add(possiblePronunciation[i] + possiblePronunciation[j] + possiblePronunciation[k]);
                    for (int l = 0; l < length; l++) {
                        if (i == l || j == l || k == l) continue;
                        allCombination.add(possiblePronunciation[i] + possiblePronunciation[j] + possiblePronunciation[k] + possiblePronunciation[l]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (allCombination.contains(babbling[i])) {
                ++answer;
            }
        }

        return answer;
    }
}

