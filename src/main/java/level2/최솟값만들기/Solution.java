package level2.최솟값만들기;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            int multiValue = A[i] * B[B.length - i - 1];
            sum += multiValue;
        }

        answer = sum;

        return answer;
    }
}
