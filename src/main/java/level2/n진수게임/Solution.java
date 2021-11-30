package level2.n진수게임;

public class Solution {
    public static String[] AtoF = {"A","B","C","D","E","F"};


    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        StringBuilder temp= new StringBuilder("0");
        for(int i=1; i<=t*m;i++) {
            //convert method 대신 Integer.toString(number,radix)를 사용하여 변환가능
            temp.append(convert(i,n));
        }

        int index = p;
        for(int i=0;i<t;i++) {
            answer.append(temp.charAt(index-1));
            index += m;
        }
        return answer.toString();
    }

    public static String convert(int number, int base) {
        StringBuilder stringBuilder = new StringBuilder();
        while(number !=0) {
            int reminder = number % base;
            if(reminder >= 10  && reminder <= 15)
                stringBuilder.append(AtoF[reminder-10]);
            else
            stringBuilder.append(reminder);

            number /= base;
        }

        return stringBuilder.reverse().toString();
    }
}
