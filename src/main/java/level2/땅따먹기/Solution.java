package level2.땅따먹기;

public class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int row = land.length;
        int col = land[0].length;
        int[][] dist = new int[row][col];

        for (int i = 0; i < col; i++) {
            dist[0][i] = land[0][i];
        }
        for (int i = 1; i < row; i++) {
            dist[i][0] = Math.max(Math.max(dist[i - 1][1] + land[i][0], dist[i - 1][2] + land[i][0]), dist[i - 1][3] + land[i][0]);
            dist[i][1] = Math.max(Math.max(dist[i - 1][0] + land[i][1], dist[i - 1][2] + land[i][1]), dist[i - 1][3] + land[i][1]);
            dist[i][2] = Math.max(Math.max(dist[i - 1][0] + land[i][2], dist[i - 1][1] + land[i][2]), dist[i - 1][3] + land[i][2]);
            dist[i][3] = Math.max(Math.max(dist[i - 1][0] + land[i][3], dist[i - 1][1] + land[i][3]), dist[i - 1][2] + land[i][3]);
        }

        for (int j = 0; j < col; j++)
            answer = Math.max(answer, dist[row - 1][j]);

        return answer;
    }
}
