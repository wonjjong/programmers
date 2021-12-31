package level3.자물쇠와열쇠;

public class Solution {

    public static boolean solution(int[][] key, int[][] lock) {

        int m = key.length;
        int n = lock.length;
        int[][] map = new int[2 * (m - 1) + n][2 * (m - 1) + n];

        for (int i = m - 1; i < (m - 1 + n); i++) {
            for (int j = m - 1; j < (m - 1 + n); j++) {
                map[i][j] = lock[i - (m - 1)][j - (m - 1)];
            }
        }

        //brute force
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j < m + n - 1; j++) {
                if (canUnlock(map, key, i, j, n))
                    return true;
            }
        }

        return false;
    }

    public static boolean canUnlock(int[][] map, int[][] key, int startRow, int startCol, int n) {

        for (int count = 0; count < 4; count++) {
            key = lotate(key);
            if (isCorrespond(map, key, startRow, startCol, n))
                return true;
        }

        return false;
    }

    public static boolean isCorrespond(int[][] map, int[][] key, int startRow, int startCol, int n) {
        int[][] copy = new int[map.length][map.length];

        //배열 복사
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                copy[i][j] = map[i][j];
            }
        }


        //key값 넣어주기
        for (int i = startRow; i < startRow + key.length; i++) {
            for (int j = startCol; j < startCol + key.length; j++) {

                //key 값이 1이고 copy[i][j]가 1인 경우 돌기부분이 겹치므로 맞지 않음
                if (copy[i][j] == 1 && key[i - startRow][j - startCol] == 1) return false;
                else {
                    copy[i][j] = copy[i][j] == 1 ? 1 : key[i - startRow][j - startCol];
                }
            }
        }

        //자물쇠 부분 확인
        int m = key.length;
        for (int i = m - 1; i < m + n - 1; i++) {
            for (int j = m - 1; j < m + n - 1; j++) {
                if (copy[i][j] == 0) return false;
            }
        }

        return true;
    }

    public static int[][] lotate(int[][] key) {
        int len = key.length;
        int[][] lotate = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                lotate[i][j] = key[len - 1 - j][i];
            }
        }
        return lotate;
    }
}
