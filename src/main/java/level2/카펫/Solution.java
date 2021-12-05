package level2.카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int row = 3;
        while (true) {
            for (int col = 0; col <= row; col++) {
                if (row * 2 + col * 2 - 4 == brown && row * col - brown == yellow) {
                    return new int[]{row, col};
                }
            }
            row++;
        }
    }
}
