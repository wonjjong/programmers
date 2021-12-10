package level2.JadenCase문자열만들기;

public class Solutiom {

    public static String solution(String s) {
        String answer = "";
        if (s.length() == 1) return s;
        else
            answer += Character.toUpperCase(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }
        }
        return answer;
    }
}
