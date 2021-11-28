package level2.프렌즈4블록;

public class Solution {

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            boolean[][] check = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    //check 2x2 block
                    if (map[i][j] != ' ')
                        checkBlock(i, j, map, check);
                }
            }
            int count = removeBlock(m, n, map, check);
            if (count == 0) break;
            else answer += count;
            fillBlank(map);
        }

        return answer;
    }

    private static void checkBlock(int x, int y, char[][] map, boolean[][] check) {
        if (canRemove(x, y, map)) {
            check[x][y] = check[x][y + 1] = check[x + 1][y] = check[x + 1][y + 1] = true;
        }
    }

    public static boolean canRemove(int x, int y, char[][] map) {
        char c = map[x][y];
        return map[x][y + 1] == c && map[x + 1][y] == c && map[x + 1][y + 1] == c;
    }

    public static int removeBlock(int m, int n, char[][] map, boolean[][] check) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    map[i][j] = ' ';
                    count++;
                }
            }
        }
        return count;
    }

    public static void fillBlank(char[][] map) {
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = map[i].length - 1; j >= 0; j--) {
                if (map[i][j] == ' ') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != ' ') {
                            map[i][j] = map[k][j];
                            map[k][j] = ' ';
                            break; //중요
                        }
                    }
                }
            }
        }
    }

}
