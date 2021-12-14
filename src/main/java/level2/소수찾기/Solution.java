package level2.소수찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    static Set<Integer> answer;
    static List<Character> comb;
    static boolean[] isVisit;

    public static int solution(String numbers) {
        answer = new HashSet<>();
        isVisit = new boolean[numbers.length()];
        comb = new ArrayList<>();

        for (int size = 1; size <= numbers.length(); size++) {
            bruteForce(0, size, numbers);
        }
        return answer.size();
    }

    public static void bruteForce(int depth, int size, String numbers) {
        if (depth == size) {
            int number = Integer.parseInt(comb.stream().map(String::valueOf).collect(Collectors.joining()));
            boolean isPrime = isPrime(number);
            if (isPrime) answer.add(number);
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                comb.add(numbers.charAt(i));
                bruteForce(depth + 1, size, numbers);
                isVisit[i] = false;
                comb.remove(comb.size() - 1);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1 || (number != 2 && number % 2 == 0)) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
