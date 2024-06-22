package level1.가장많이받은선물;

public class Solution {
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        int giftsLength = gifts.length;

        int[][] b = new int[friendsLength][friendsLength];
        int[] c = new int[friendsLength];
        int[] d = new int[friendsLength];

        for (int i = 0; i < giftsLength; i++) {
            String[] gift = gifts[i].split(" ");
            int from = findIndex(gift[0], friends);
            int to = findIndex(gift[1], friends);

            b[from][to]++;
        }

        for (int i = 0; i < friendsLength; i++) {
            for (int j = 0; j < friendsLength; j++) {
                c[i] += b[i][j];
                c[i] -= b[j][i];
            }
        }

        for (int i = 0; i < friendsLength; i++) {
            for (int j = 0; j < friendsLength; j++) {
                if (i == 0 && j == 0) continue;

                if (b[i][j] > b[j][i]) {
                    d[i]++;
                }

                if (b[i][j] == b[j][i]) {
                    if (c[i] > c[j]) {
                        d[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < friendsLength; i++) {
            if (answer < d[i]) {
                answer = d[i];
            }
        }

        return answer;
    }

    private static int findIndex(String gift, String[] friends) {
        int index = 0;
        for (int i = 0; i < friends.length; i++) {
            if (gift.equals(friends[i])) {
                index = i;
                break;
            }
        }

        return index;
    }
}
