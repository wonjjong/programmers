package level2.쿼드압축후개수세기;

public class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        checkSquare(arr, 0, 0, arr.length, answer);
        return answer;
    }

    public void checkSquare(int arr[][], int x, int y, int size, int[] answer) {
        int value = arr[x][y];
        boolean isSameValue = true;

        for (int i = x; i < x + size && isSameValue; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != arr[i][j]) {
                    isSameValue = false;
                    break;
                }
            }
        }

        if (isSameValue) {
            if (value == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        } else {
            int nextSize = size / 2;
            checkSquare(arr, x, y, nextSize, answer);
            checkSquare(arr, x, y + nextSize, nextSize, answer);
            checkSquare(arr, x + nextSize, y, nextSize, answer);
            checkSquare(arr, x + nextSize, y + nextSize, nextSize, answer);
        }
    }
}
