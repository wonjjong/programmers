package level2.이모티콘할인행사;

public class Solution {
    public int ans1 = 0;
    public int ans2 = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] emoticonPercent = new int[emoticons.length];

        dfs(0, emoticons.length, users, emoticons, emoticonPercent);

        int[] answer = new int[2];
        answer[0] = ans1;
        answer[1] = ans2;

        return answer;
    }

    public void dfs(int startIndex, int baseIndex, int[][] users, int[] emoticons, int[] emoticonPercent) {
        if (startIndex == baseIndex) {
            int sub = 0;
            int amount = 0;
            for (int i = 0; i < users.length; i++) {
                int up = users[i][0];
                int ua = users[i][1];
                int sum = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    int ep = emoticonPercent[j];
                    int ea = emoticons[j] - ((emoticons[j] * ep) / 100);
                    if (up <= ep) {
                        sum += ea;
                    }
                }
                if (sum >= ua) {
                    sub++;
                } else {
                    amount += sum;
                }

                if (sub > ans1) {
                    ans1 = sub;
                    ans2 = amount;
                }
                if (sub == ans1) {
                    if (amount > ans2) {
                        ans2 = amount;
                    }
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int percent = (i + 1) * 10;
            emoticonPercent[startIndex] = percent;
            dfs(startIndex + 1, baseIndex, users, emoticons, emoticonPercent);
        }
    }
}
