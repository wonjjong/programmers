package level1.키패드누르기;

public class Solution {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftX = 3, leftY = 0;
        int rightX = 3, rightY = 2;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number == 0 ) number = 11;
            if (number == 2 || number == 5 || number == 8 || number == 11) {
                int midX = (number - 1) / 3;
                int midY = (number - 1) % 3;
                int fromLeft = Math.abs(midX - leftX) + Math.abs(midY - leftY);
                int fromRight = Math.abs(midX - rightX) + Math.abs(midY - rightY);

                if (fromLeft < fromRight) {
                    leftX = midX;
                    leftY = midY;
                    answer.append("L");
                } else if (fromLeft > fromRight) {
                    rightX = midX;
                    rightY = midY;
                    answer.append("R");
                } else {
                    if ("right".equals(hand)) {
                        rightX = midX;
                        rightY = midY;
                        answer.append("R");
                    } else {
                        leftX = midX;
                        leftY = midY;
                        answer.append("L");
                    }
                }
            } else if (number == 1 || number == 4 || number == 7) {
                leftX = (number - 1) / 3;
                leftY = (number - 1) % 3;
                answer.append("L");
            } else {
                rightX = (number - 1) / 3;
                rightY = (number - 1) % 3;
                answer.append("R");
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        int[] numbers= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        System.out.println(solution(numbers, "left"));
    }
}
