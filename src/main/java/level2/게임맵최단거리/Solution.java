package level2.게임맵최단거리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int INF = 987654321;
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {-1, 1, 0, 0};

    public static int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        Queue<Location> queue = new LinkedList<>();
        int[][] distance = new int[row][col];
        for (int[] d : distance)
            Arrays.fill(d, INF);
        distance[0][0] = 1;
        queue.add(new Location(0, 0));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.x;
            int y = location.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isInside(newX, newY, row, col) && maps[newX][newY] == 1) {
                    if (distance[x][y] + 1 < distance[newX][newY]) {
                        queue.add(new Location(newX, newY));
                        distance[newX][newY] = distance[x][y] + 1;
                    }
                }
            }

        }
        return distance[row - 1][col - 1] == INF ? -1 : distance[row - 1][col - 1];
    }

    static boolean isInside(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
