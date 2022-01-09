package level3.합승택시요금;

public class Solution {

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                map[i][j] = 987654321;
            }
        }

        for (int i = 0; i < fares.length; i++) {
            int p1 = fares[i][0] - 1;
            int p2 = fares[i][1] - 1;
            int value = fares[i][2];
            map[p1][p2] = map[p2][p1] = value;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (map[s - 1][i] == 987654321) continue;
            answer = Math.min(map[s - 1][i] + map[i][a - 1] + map[i][b - 1], answer);
        }

        return answer;
    }
}
