package level2.파일명정렬;

import java.util.ArrayList;

public class Solution {
    public static String[] solution(String[] files) {
        String[] answer = {};

        ArrayList<File> fileList = new ArrayList<>();

        for (String file : files) {
            int headIndex = 0;
            for (; headIndex < file.length(); headIndex++) {
                if (Character.isDigit(file.charAt(headIndex))) break;
            }
            String head = file.substring(0, headIndex);

            int numberIndex = headIndex;
            for (; numberIndex < file.length(); numberIndex++) {
                if (!Character.isDigit(file.charAt(numberIndex))) break;
            }
            String number = file.substring(headIndex, numberIndex);

            String tail = file.substring(numberIndex);
            fileList.add(new File(head, number,tail));
        }

        answer =  fileList.stream().sorted().map(s -> s.head+ s.number+ s.tail).toArray(String[]::new);
        return answer;
    }

    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            if (head.toUpperCase().equals(o.head.toUpperCase())) {
                return Integer.compare(Integer.parseInt(number), Integer.parseInt(o.number) );
            } else
                return head.toUpperCase().compareTo(o.head.toUpperCase());
        }
    }
}
