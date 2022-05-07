package level1.비밀지도;

public class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            String a = toBinary(arr1[i],n);
            String b = toBinary(arr2[i],n);

            for (int j = 0; j < n; j++) {
                if (a.charAt(j) == '1' || b.charAt(j) == '1')
                    temp.append("#");
                else
                    temp.append(" ");
            }
            answer[i] = temp.toString();
        }

        return answer;
    }

    public static String toBinary(int value, int n) {
        StringBuffer sb = new StringBuffer();
        while (value != 0) {
            sb.append(value % 2);
            value /= 2;
        }
        while(sb.length() < n)
            sb.append("0");

        return sb.reverse().toString();
    }
}
