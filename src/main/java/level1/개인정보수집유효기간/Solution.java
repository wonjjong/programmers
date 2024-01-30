package level1.개인정보수집유효기간;

import java.util.ArrayList;

/*"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
        "2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]*/
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans = new ArrayList<>();

        int todayNumber = convertDateToNumber(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] privacySplit = privacies[i].split(" ");
            String privacyDate = privacySplit[0];
            String privacyType = privacySplit[1];
            int privacyDateNumber = convertDateToNumber(privacyDate);

            for (int j = 0; j < terms.length; j++) {
                String[] termSplit = terms[j].split(" ");
                String termsType = termSplit[0];
                Integer termsPeriod = Integer.valueOf(termSplit[1]);

                if (privacyType.equals(termsType)) {
                    if ((privacyDateNumber + (termsPeriod * 28)) <= todayNumber) {
                        ans.add(i + 1);
                    }
                }
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    private int convertDateToNumber(String date) {
        String[] dateSplit = date.split("\\.");
        Integer y = Integer.valueOf(dateSplit[0]);
        Integer m = Integer.valueOf(dateSplit[1]);
        Integer d = Integer.valueOf(dateSplit[2]);

        return (28 * 12 * y) + (m * 28) + d;
    }
}
