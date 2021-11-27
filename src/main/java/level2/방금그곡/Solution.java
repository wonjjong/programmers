package level2.방금그곡;

import java.util.*;

public class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int playTime = 0;
        for (String musicinfo : musicinfos) {
            String[] splits = musicinfo.split(",");
            String[] melodyInfo = makeMelody(splits[0], splits[1], splits[3]);
            String melody = melodyInfo[0];
            int melodyLength = Integer.parseInt(melodyInfo[1]);

            if (m.charAt(m.length() - 1) == '#') {
                if (melody.contains(m) ) {
                    if (melodyLength > playTime) {
                        playTime = melodyLength;
                        answer = splits[2];
                    }
                }
            } else {
                int index = melody.indexOf(m);
                while (index != -1) {
                    String temp = melody.substring(index, index + m.length());

                    //#이 붙은 음인지 아닌지 확인
                    if (!(index + m.length() < melody.length() && melody.charAt(index + m.length()) == '#')) {
                        if (temp.startsWith(m)) {
                            if (melodyLength > playTime) {
                                playTime = melodyLength;
                                answer = splits[2];
                            }
                            break;
                        }
                    }
                    index = melody.indexOf(m, index + 1);
                }

            }
        }
        return answer;
    }

    private static String[] makeMelody(String startTime, String endTime, String music) {
        ArrayList<String> token = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < music.length() - 1; i++) {
            if (Character.isAlphabetic(music.charAt(i))) {
                if (music.charAt(i + 1) == '#') {
                    token.add(music.substring(i, i + 2));
                } else token.add(music.substring(i, i + 1));
            }
        }

        if (music.charAt(music.length() - 1) != '#') {
            token.add(music.substring(music.length() - 1));
        }

        int sT = Integer.parseInt(startTime.substring(0, 2)) * 60 + Integer.parseInt(startTime.substring(3));
        int eT = Integer.parseInt(endTime.substring(0, 2)) * 60 + Integer.parseInt(endTime.substring(3));
        int time = eT - sT;
        for (int i = 0; i < time; i++) {
            result.append(token.get(i % token.size()));
        }

        return new String[]{new String(result), new String(Integer.toString(time))};
    }
}