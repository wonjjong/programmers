package level3.경주로건설;

import java.util.PriorityQueue;

public class Solution {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean[][][] v;
    static int answer = Integer.MAX_VALUE;

    public static void bfs(int x, int y, int d, int[][] board, boolean[][][] v, int n) {
        PriorityQueue<Track> pq = new PriorityQueue<>();
        pq.add(new Track(x, y, d, 0));

        while (!pq.isEmpty()) {
            Track track = pq.poll();
            if (track.x == n - 1 && track.y == n - 1) {
                answer = Math.min(answer, track.sum);
                continue;
            }
            if (v[track.x][track.y][track.dir]) continue;
            v[track.x][track.y][track.dir] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nx = track.x + dx[dir];
                int ny = track.y + dy[dir];

                if (isInside(nx, ny, n) && board[nx][ny] == 0) {
                    if (!v[nx][ny][dir]) {
                        if (track.dir == dir) {
                            pq.add(new Track(nx, ny, dir, track.sum + 100));
                        } else {
                            pq.add(new Track(nx, ny, dir, track.sum + 600));
                        }
                    }
                }
            }

        }
    }

    public static int solution(int[][] board) {
        int n = board.length;

        v = new boolean[n][n][4];
        bfs(0, 0, 3, board, v, n);
        v = new boolean[n][n][4];
        bfs(0, 0, 1, board, v, n);

        return answer;
    }

    public static boolean isInside(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static class Track implements Comparable<Track> {
        int x, y, dir, sum;

        public Track(int x, int y, int dir, int sum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sum = sum;
        }

        @Override
        public int compareTo(Track o) {
            return Integer.compare(this.sum, o.sum);
        }
    }
}
