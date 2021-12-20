package level2.N배열자르기;

import java.util.ArrayList;

public class Solution {

    public static int[] solution(int n, long left, long right) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int startIndex = (int) (left / n);
        int endIndex = (int) (right / n);
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = startIndex; i <= endIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                arrayList.add(i + 1);
            }
            for (int j = i + 2; j <= n; j++)
                arrayList.add(j);
        }

        int index = 0;
        for (int i = (int) (left % n); i <= (right - left) + (int) (left % n); i++) {
            answer[index] = arrayList.get(i);
            index++;
        }

        return answer;
    }
}
