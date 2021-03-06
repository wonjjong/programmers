package level2.짝지어제거하기;

import java.util.Stack;

public class Solution {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()) stack.push(s.charAt(i));
            else {
                if (s.charAt(i) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
