package level2.전화번호목록;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        String[] phone_book = {"15", "1520", "12", "123", "1235", "567", "88","5"};
        String[] phone_book = {"9","11111","222"};
        boolean solution = solution(phone_book);
        System.out.println(solution);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        String s = phone_book[0];
        for(int i=1;i<phone_book.length;i++) {
            if(phone_book[i].startsWith(s)) {
                answer = false;
                break;
            }
            else {
                s= phone_book[i];
            }
        }

        return answer;
    }
}
