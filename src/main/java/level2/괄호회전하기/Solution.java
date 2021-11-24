package level2.괄호회전하기;

import java.util.Stack;

public class Solution {

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String locatedString = locateLeft(i, s);
            boolean isRightBracket = checkString(locatedString);
            if (isRightBracket) answer++;
        }

        return answer;
    }

    private static boolean checkString(String locatedString) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < locatedString.length(); i++) {
            char bracket = locatedString.charAt(i);
            if (bracket == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            } else if (bracket == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            } else if (bracket == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else {
                stack.push(bracket);
            }
        }
        return stack.empty();
    }

    private static String locateLeft(int space, String s) {
        return new String(s.substring(space) + s.substring(0, space));
    }
}
