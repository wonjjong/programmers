package level2.이진변환반복하기;

public class Solution {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        int countZero = 0;
        int number = 0;
        while(!s.equals("1")) {
            String temp = s.replace("0", "");
            countZero += (s.length()- temp.length());

            s = Integer.toBinaryString(temp.length());
            number++;
        }

        answer[0] = number;
        answer[1] = countZero;
        return answer;
    }
}
