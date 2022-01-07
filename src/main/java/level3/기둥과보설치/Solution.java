package level3.기둥과보설치;

import java.util.ArrayList;

class Solution {
    static boolean[][] columns;
    static boolean[][] beams;
    static int size;

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        columns = new boolean[n + 1][n + 1];
        beams = new boolean[n + 1][n + 1];
        size = columns.length;

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0], y = build_frame[i][1];
            int a = build_frame[i][2]; // 0이면 기둥, 1이면 보
            int b = build_frame[i][3]; // 0이면 삭제, 1이면 설치
            int row = size - y - 1, col = x;
            if (b == 0) {
                if (a == 0) columns[row][col] = false;
                else beams[row][col] = false;

                if (canRemove()) continue;
                else {
                    if (a == 0) columns[row][col] = true;
                    else beams[row][col] = true;
                }

            } else {
                //설치
                if (a == 0) {
                    //기둥
                    columns[row][col] = canConstructColumn(row, col);
                } else {
                    //보
                    beams[row][col] = canConstructBeam(row, col);
                }
            }


        }

        ArrayList<int[]> answers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (beams[i][j]) {
                    answers.add(new int[]{j, size - i - 1, 1});
                }
                if (columns[i][j]) {
                    answers.add(new int[]{j, size - i - 1, 0});
                }
            }
        }

        answers.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return Integer.compare(o1[2], o2[2]);
                else return Integer.compare(o1[1], o2[1]);
            } else
                return Integer.compare(o1[0], o2[0]);
        });

        answer = new int[answers.size()][3];
        for (int i = 0; i < answers.size(); i++) {
            for (int j = 0; j < 3; j++)
                answer[i][j] = answers.get(i)[j];
        }
        return answer;
    }

    public static boolean canRemove() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (beams[i][j]) {
                    if (!canConstructBeam(i, j)) return false;
                }
                if (columns[i][j]) {
                    if (!canConstructColumn(i, j)) return false;
                }
            }
        }
        return true;
    }


    public static boolean canConstructColumn(int row, int col) {
        return row == size - 1 || columns[row + 1][col] || isThereBeam(row, col) || isThereBeam(row, col - 1);
    }

    public static boolean isThereBeam(int row, int col) {
        return isInside(row, col) && beams[row][col];
    }

    public static boolean canConstructBeam(int row, int col) {
        return isThereColumn(row + 1, col) || isThereColumn(row + 1, col + 1) || (isThereBeam(row, col - 1) && isThereBeam(row, col + 1));

    }

    public static boolean isThereColumn(int row, int col) {
        return isInside(row, col) && columns[row][col];
    }

    public static boolean isInside(int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }
}