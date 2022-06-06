package level2.k진수에서소수개수구하기;

public class Solution {
    public static int solution(int n, int k) {
        int answer = 0;
        String convert = convert(n, k);
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < convert.length(); i++) {
            if (convert.charAt(i) != '0') {
                word.append(convert.charAt(i));
            } else {
                if (word.length() != 0 && isPrime(word.toString())) {
                    answer++;
                }
                word.setLength(0);
            }
        }

        if (word.length() != 0 && isPrime(word.toString())) {
            answer++;
        }
        return answer;
    }

    public static boolean isPrime(String word) {
        long n = Long.parseLong(word);

        if (n == 1 || (n != 2 && n / 2 == 0)) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static String convert(int n, int k) {
        StringBuilder convert = new StringBuilder();

        while (n != 0) {
            convert.append(n % k);
            n /= k;
        }
        return convert.reverse().toString();
    }


}
