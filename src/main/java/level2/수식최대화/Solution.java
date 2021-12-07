package level2.수식최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    static boolean[] isSelected;
    static Character[] comb;
    static long answer = 0;
    static ArrayList<Character> operations;
    static ArrayList<Character> operators;

    public static long solution(String expression) {
        answer = 0;
        operators = new ArrayList<>();
        operations = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))) {
                if (!operators.contains(expression.charAt(i))) {
                    operators.add(expression.charAt(i));
                }
                operations.add(expression.charAt(i));
            }
        }

        isSelected = new boolean[operators.size()];
        comb = new Character[operators.size()];

        makePrioirty(0, operators, expression);

        return answer;
    }

    public static void makePrioirty(int cnt, ArrayList<Character> operators, String expression) {
        if (cnt == operators.size()) {
            String[] temp = expression.replaceAll("-|\\*|\\+", " ").split(" ");
            ArrayList<Long> numbers = new ArrayList<>(Arrays.stream(temp).
                    map(Long::parseLong).
                    collect(Collectors.toList()));
            ArrayList<Character> opers = new ArrayList<>(operations);

            long result = 0;
            for (int i = 0; i < operators.size(); i++) {
                for (int j = 0; j < opers.size(); j++) {
                    if (comb[i] == opers.get(j)) {
                        long cal = cal(comb[i], numbers.get(j), numbers.get(j + 1));
                        opers.remove(j);
                        numbers.remove(j);
                        numbers.remove(j);
                        numbers.add(j, cal);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(numbers.get(0)));
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            comb[cnt] = operators.get(i);
            makePrioirty(cnt + 1, operators, expression);
            isSelected[i] = false;
        }
    }

    public static long cal(char c, long x, long  y) {
        long result = 0;

        if (c == '+')
            result = x + y;
        else if (c == '*')
            result = x * y;
        else
            result = x - y;

        return result;
    }
}