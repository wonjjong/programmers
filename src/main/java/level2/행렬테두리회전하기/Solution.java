package level2.행렬테두리회전하기;

import java.util.ArrayList;

public class Solution {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = (i * columns) + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = lotate(x1, y1, x2, y2, arr);
        }

        return answer;
    }

    public static int lotate(int x1, int y1, int x2, int y2, int[][] arr) {
        int min = Integer.MAX_VALUE;
        int temp = arr[x1][y2];
        ArrayList<Integer> rightDir = new ArrayList<>();
        ArrayList<Integer> downDir = new ArrayList<>();
        ArrayList<Integer> leftDir = new ArrayList<>();
        ArrayList<Integer> upDir = new ArrayList<>();

        for (int i = y1; i <= y2; i++) {
            rightDir.add(arr[x1][i]);
            min = Math.min(min, arr[x1][i]);
        }
        for (int i = x1; i <= x2-1; i++) {
            downDir.add(arr[i][y2]);
            min = Math.min(min, arr[i][y2]);
        }
        for (int i = y1 + 1; i <= y2; i++) {
            leftDir.add(arr[x2][i]);
            min = Math.min(min, arr[x2][i]);
        }
        for (int i = x1 + 1; i <= x2; i++) {
            upDir.add(arr[i][y1]);
            min = Math.min(min, arr[i][y1]);
        }

        rightDir.remove(rightDir.size() - 1);
        rightDir.add(0, upDir.get(0));

        for (int i = y1, index = 0; i <= y2; i++, index++)
            arr[x1][i] = rightDir.get(index);
        for (int i = x1 + 1, index = 0; i <= x2; i++, index++)
            arr[i][y2] = downDir.get(index);
        for (int i = y1, index = 0; i <= y2 - 1; i++, index++)
            arr[x2][i] = leftDir.get(index);
        for (int i = x1, index = 0; i <= x2 - 1; i++, index++)
            arr[i][y1] = upDir.get(index);

        return min;
    }
}
