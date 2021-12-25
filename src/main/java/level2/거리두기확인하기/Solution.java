package level2.거리두기확인하기;

public class Solution {
    public static boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;

    }

    public static boolean checkAdjacent(int x, int y, char[][] map) {
        boolean result = true;
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isInside(nx, ny) && map[nx][ny] == 'P') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkUDLR(int x, int y, char[][] map) {
        boolean result = true;
        int dx[] = {0, 0, -2, 2};
        int dy[] = {-2, 2, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isInside(nx, ny) && map[nx][ny] == 'P'
                    && map[x + dx[i] / 2][y + dy[i] / 2] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkCross(int x, int y, char[][] map) {
        boolean result = true;
        int dx[] = {-1, -1, 1, 1};
        int dy[] = {-1, 1, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isInside(nx, ny) && map[nx][ny] == 'P'
                    && (map[nx][y] == 'O' || map[x][ny] == 'O')) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int testCase = 0; testCase < places.length; testCase++) {
            char map[][] = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = places[testCase][i].charAt(j);
                }
            }
            answer[testCase] = check(map) ? 1 : 0;
        }

        return answer;

    }

    private static boolean check(char[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (!checkAdjacent(i, j, map) || !checkUDLR(i, j, map) || !checkCross(i, j, map))
                        return false;
                }
            }
        }
        return true;
    }
}
