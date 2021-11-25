package level2.행렬의곱셈;

public class Solution {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int rowLength = arr1.length;
        int colLength = arr2[0].length;
        int[][] answer = new int[rowLength][colLength];

        for(int i=0;i<rowLength;i++) {
            for(int j=0; j<colLength;j++) {
                answer[i][j] = calculateMatrix(arr1,arr2,i,j);
            }
        }
        return answer;
    }

    private static int calculateMatrix(int[][] arr1, int[][] arr2, int row, int col) {
        int sum =0 ;
        for(int i=0;i<arr1[row].length;i++) {
            sum += (arr1[row][i] * arr2[i][col]);
        }
        return sum;
    }
}
