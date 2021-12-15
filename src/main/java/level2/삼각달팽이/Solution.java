package level2.삼각달팽이;

import java.util.ArrayList;

public class Solution {

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int value = 1;
        int count = n;
        int x = -1, y = 0;

        int dir = 0;
        int dx[] = {1, 0, -1};
        int dy[] = {0, 1, -1};

        while (count != 0) {
            for (int i = 0; i < count; i++) {
                x += dx[dir];
                y += dy[dir];
                arr[x][y] = value;
                value++;
            }
            dir = (dir + 1) % 3;
            count--;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                temp.add(arr[i][j]);
            }
        }
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
