package level2.n개의최소공배수;

public class Solution {

    public static int solution(int[] arr) {
        int answer = 1;

        for (;; answer++) {
            boolean isLeastCommon = true;

            for (int i = 0; i < arr.length; i++) {
                if(answer % arr[i] != 0) {
                    isLeastCommon = false;
                    break;
                }
            }
            if(isLeastCommon) break;
        }

        return answer;
    }
}
