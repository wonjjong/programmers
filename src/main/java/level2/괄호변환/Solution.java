package level2.괄호변환;

public class Solution {
    public static String solution(String p) {
        if (p.equals("")) return "";

        int index = findBalancedBracketIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        if (isCorrectBracketString(u)) {
            return u + solution(v);
        } else {
            String temp = "(" + solution(v) + ")";
            String temp2 = "";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') temp2 += ")";
                else temp2 += "(";
            }
            return solution(temp + temp2);
        }
    }

    public static boolean isCorrectBracketString(String string) {
        Stack<Character> stack = new Stack<>();
        stack.push(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static int findBalancedBracketIndex(String string) {
        int open = 0, close = 0;
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(')
                open++;
            else
                close++;

            if (open == close) {
                index = i;
                break;
            }
        }
        return index;
    }
}
